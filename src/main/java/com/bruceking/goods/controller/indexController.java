package com.bruceking.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@ComponentScan("com.bruceking.redis") /**Scan到redis**/
public class indexController {

    @Autowired
    private com.bruceking.redis.redisComponent redisComponent;

    @GetMapping({"/","goodsIndex"})
    public String index(HttpServletRequest httpServletRequest){
        Cookie[] cookies =  httpServletRequest.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("JSESSIONID")){
                    if (!redisComponent.getSet(cookie.getValue()).isEmpty()){
                        return "goodsIndex";
                    }else {
                        return "redirect:http://localhost/login";
                    }
                }
            }
        }
        return "redirect:http://localhost/login";
    }






}
