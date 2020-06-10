package com.bruceking.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @GetMapping({"/","goodsIndex"})
    public String index(){
        return "goodsIndex";
    }






}
