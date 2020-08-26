package com.bruceking.main.authenticator;

import com.bruceking.main.redis.redisComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class authenticatorController {

    @Autowired
    private authenticatorService authenticatorService;

    @Autowired
    private redisComponent redisComponent;

    @RequestMapping("/auLogin")
    @ResponseBody
    @CrossOrigin
    public Map<String,Boolean> auLogin(@RequestParam("username") String username,@RequestParam("password") String password){
        Map<String,Boolean> map = new HashMap<>();
        map.put("result",authenticatorService.checkUserPwd(username,password));
        return map;
    }

    @RequestMapping("/setAuthCode")
    @CrossOrigin
    @ResponseBody
    public void setAuthCode(@RequestParam("username") String username, @RequestParam("code") String authCode){
        System.out.println(username+","+authCode);
        redisComponent.setKey(username+"-authCode",authCode,20);
//        System.out.println(redisComponent.getKey(username+"-authCode"));
    }
}
