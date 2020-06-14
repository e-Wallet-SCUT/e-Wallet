package com.bruceking.trans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class controller {

    @RequestMapping({"/","/transindex"})
    public String index(){
        return "transindex";
    }

    @PostMapping("/transpd")
    public String tran1(){
        //提取相关信息

        return "transpd";
    }

    @PostMapping("/transpd/correct")
    public String trans2(@RequestParam("password") String password,
                         Map<String,Object> map){
        if("123456".equals(password)){
           return "transok";
        }
        else{
            map.put("msg","密码错误");
            return "transpd";
        }
    }

}
