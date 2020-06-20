package com.bruceking.main.goods.controller;

import com.bruceking.main.userInfo.userInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GoodsIndexController {
    @Autowired
    private com.bruceking.main.userInfo.userInfoService userInfoService;

    @GetMapping("/goodsIndex")
    public String index(Model model){
        String currentUser = userInfoService.getCurrentUser();

        if (currentUser.equals("anonymousUser")){
            model.addAttribute("logined",true);
        }else {
            Map<String, Object> map = new HashMap<>();
            map.put("logined",false);
            map.put("username",currentUser);
            model.addAllAttributes(map);
        }

        return "goodsIndex";
    }






}
