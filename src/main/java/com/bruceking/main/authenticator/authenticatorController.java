package com.bruceking.main.authenticator;

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

    @RequestMapping("/auLogin")
    @ResponseBody
    @CrossOrigin
    public Map<String,Boolean> auLogin(@RequestParam("username") String username,@RequestParam("password") String password){
        Map<String,Boolean> map = new HashMap<>();
        map.put("result",authenticatorService.checkUserPwd(username,password));
        return map;
    }
}
