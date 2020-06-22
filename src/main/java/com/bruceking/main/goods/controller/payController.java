package com.bruceking.main.goods.controller;



import com.bruceking.main.goods.Service.payService;
import com.bruceking.main.goods.bean.Pay;
import com.bruceking.main.goods.bean.Transaction;
import com.bruceking.main.loginPage.customer;
import com.bruceking.main.userInfo.userInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class payController {

    @Autowired
    private payService payService;

    @Autowired
    private userInfoService userInfoService;


    @GetMapping("/payinit/{title}/{price}")
    public ModelAndView payinit(@PathVariable("title") String title,
                                @PathVariable("price") String price){
        String currentUser = userInfoService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("username",currentUser);



        customer user = userInfoService.getUserInfo(currentUser);

        String customer_id = Integer.toString(user.getCustomer_id());
        modelAndView.addObject("user_id",customer_id);
        modelAndView.addObject("title",title);
        modelAndView.addObject("price",price);

        System.out.println(title);
        modelAndView.setViewName("pay");

        return modelAndView;

    }
    @RequestMapping("/addpay")
    public ModelAndView pay(Pay pay){


        pay.setPay_date(new Date());

        payService.AddPay(pay);
        ModelAndView mv = new ModelAndView();
        int primaryID = payService.SelectTransaction(Integer.parseInt(pay.getPay_account_id()));
        Transaction transaction = new Transaction();
        System.out.println(primaryID);
        transaction.setTransactionEntityLongId(primaryID);
        transaction.setTransactionLongAmount(BigDecimal.valueOf(pay.getPay_amount()));
        transaction.setTransactionShortAmount(BigDecimal.valueOf(pay.getPay_amount()));
        transaction.setTransactionDescription(pay.getPay_description());
        payService.AddTransaction(transaction);

        mv.addObject("msg", "支付成功");
        mv.setViewName("return");
        return mv;
    }


    @RequestMapping("/pay/service")
    public String addPay(@RequestParam(value = "pay_account_id") Integer pay_account_id, Model model){
        model.addAttribute("pay_account_id",pay_account_id);
        System.out.println(pay_account_id);
        return "pay";
    }
}
