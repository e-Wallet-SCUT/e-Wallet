package com.bruceking.main.goods.controller;



import com.bruceking.main.goods.Service.payService;
import com.bruceking.main.goods.bean.Account;
import com.bruceking.main.goods.bean.Pay;
import com.bruceking.main.goods.bean.Transaction;
import com.bruceking.main.loginPage.customer;
import com.bruceking.main.userInfo.userInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Date;


@Controller
public class payController {

    @Autowired
    private payService payService;

    @Autowired
    private userInfoService userInfoService;




    @RequestMapping("/addpay")
    public String pay(Pay pay){


        pay.setPay_date(new Date());


        ModelAndView mv = new ModelAndView();
        int primaryID = payService.SelectTransaction(Integer.parseInt(pay.getPay_account_id()));
        Account payAccount = payService.selectAccount(primaryID);
        System.out.println(payAccount.toString());
        Transaction transaction = new Transaction();

        if(payAccount.getAccount_balance()<pay.getPay_amount()){
            return "redirect:/return_error";
        }else {

            transaction.setTransactionEntityLongId(primaryID);
            transaction.setTransactionLongAmount(BigDecimal.valueOf(pay.getPay_amount()));
            transaction.setTransactionShortAmount(BigDecimal.valueOf(pay.getPay_amount()));
            transaction.setTransactionDescription(pay.getPay_description());

            payService.AddPay(pay);
            payService.AddTransaction(transaction);

            return "forward:/return";
        }
    }

    @RequestMapping("/return")
    public String toReturn(){
        System.out.println("aaaa");
        return "return";
    }



}
