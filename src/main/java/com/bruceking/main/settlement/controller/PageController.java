package com.bruceking.main.settlement.controller;

import com.bruceking.main.userInfo.userInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Autowired
    private com.bruceking.main.userInfo.userInfoService userInfoService;

    @GetMapping("/settlement")
    public String index(Model model){
        model.addAttribute("username",userInfoService.getCurrentUser());
        return "settlement";
    }
    @GetMapping("/settlementInner")
    public String inner(){
        return "settlementInner";
    }
}
