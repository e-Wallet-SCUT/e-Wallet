package com.bruceking.main.goods.controller;


import com.bruceking.main.goods.bean.Pay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RestController
public class payController {

    @Autowired
    private com.bruceking.main.goods.Service.payService payService;



    @GetMapping("/payinit/{title}/{price}")
    public ModelAndView payinit(@PathVariable("title") String title,
                                @PathVariable("price") String price){

        System.out.println("··············");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title",title);
        modelAndView.addObject("price",price);

        System.out.println(title);
        modelAndView.setViewName("pay");

        return modelAndView;

    }

    @RequestMapping("/addpay")
    public ModelAndView pay(Pay pay){


        pay.setPay_date(new Date());
        System.out.println(pay.toString());

        payService.AddPay(pay);
        ModelAndView mv = new ModelAndView();
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
