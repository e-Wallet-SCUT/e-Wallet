package com.bruceking.main.settlement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/settlement")
    public String index(){
        return "settlement";
    }
    @GetMapping("/settlementInner")
    public String inner(){
        return "settlementInner";
    }
}
