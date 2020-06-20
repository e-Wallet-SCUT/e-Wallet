package com.bruceking.main.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class GoodsIndexController {

    @GetMapping("/goodsIndex")
    public String index(){
        return "goodsIndex";
    }






}
