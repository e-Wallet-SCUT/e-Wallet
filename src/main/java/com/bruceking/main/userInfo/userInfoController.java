package com.bruceking.main.userInfo;

import com.bruceking.main.loginPage.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
//@ResponseBody
//以上两个可以用 @RestController代替，表示不跳转页面，只是返回数据，可以配合前端的Ajax请求。
public class userInfoController {
    @Autowired
    private userInfoService userInfoService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Map<String,Object> getUserInfo(){
        //获取userInfo
        Map<String,Object> map = new HashMap<>();
        Map<String,String> userInfoMap = new HashMap<>();
        try {
            customer userInfo = userInfoService.getUserInfo(userInfoService.getCurrentUser());
            userInfoMap.put("username",userInfo.getCustomer_username());
            userInfoMap.put("name",userInfo.getCustomer_name());
            userInfoMap.put("mobile",userInfo.getCustomer_mobile());
            userInfoMap.put("email",userInfo.getCustomer_email());
            userInfoMap.put("address",userInfo.getCustomer_address());
            map.put("msg","success");
            map.put("result",userInfoMap);
        }catch (NullPointerException e){
            map.put("msg","failure");
        }
        return map;
//        model.addAttribute("userInfo",userInfo);
//        return "userInfo";
    }

    @RequestMapping("/user/{username}")
    public String userPage(Model model, @PathVariable String username){
        model.addAttribute("username",username);
        return "userPage";
    }

    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public void updateUserInfo(@RequestParam("name") String name,
                                 @RequestParam("age") String age,
                                 @RequestParam("sex") String sex,
                                 @RequestParam("mobile") String mobile,
                                 @RequestParam("email") String email,
                                 @RequestParam("address") String address,
                                 @RequestParam("date") String dateString){
        Date sqlDate= Date.valueOf(dateString);
        userInfoService.updateUserInfo(userInfoService.getCurrentUser(),name,age,sex,mobile,email,address,sqlDate);
    }
}
