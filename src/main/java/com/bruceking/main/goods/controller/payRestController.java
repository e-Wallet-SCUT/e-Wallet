package com.bruceking.main.goods.controller;

import org.springframework.web.bind.annotation.RestController;


import com.bruceking.main.goods.Service.payService;

import com.bruceking.main.loginPage.customer;
import com.bruceking.main.userInfo.userInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class payRestController {

    @Autowired
    private payService payService;

    @Autowired
    private userInfoService userInfoService;


    @GetMapping("/payinit/{title}/{price}")
    public ModelAndView payinit(@PathVariable("title") String title,
                                @PathVariable("price") String price) {
        String currentUser = userInfoService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("username", currentUser);


        customer user = userInfoService.getUserInfo(currentUser);

        String customer_id = Integer.toString(user.getCustomer_id());
        modelAndView.addObject("user_id", customer_id);
        modelAndView.addObject("title", title);
        modelAndView.addObject("price", price);

        System.out.println(title);
        modelAndView.setViewName("pay");

        return modelAndView;
    }

    @GetMapping("/verify/{password}")
    public Boolean verifypassword(@PathVariable String password){
        String currentUser = userInfoService.getCurrentUser();

        customer user = userInfoService.getUserInfo(currentUser);

        //这里应该改为支付密码
        String pswd = user.getCustomer_password();
System.out.println(pswd);
        if(password.equals(pswd)){
            return true;
        }else {
            return false;
        }

    }


}
