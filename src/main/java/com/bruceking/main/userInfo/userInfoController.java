package com.bruceking.main.userInfo;

import com.bruceking.main.loginPage.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

@Controller
//@ResponseBody
//以上两个可以用 @RestController代替，表示不跳转页面，只是返回数据，可以配合前端的Ajax请求。
public class userInfoController {
    @Autowired
    private userInfoService userInfoService;

    @RequestMapping("/userInfo")
    public String getUserInfo(Model model){
        //获取userInfo
        customer userInfo = userInfoService.getUserInfo(userInfoService.getCurrentUser());
        model.addAttribute("userInfo",userInfo);
        return "userInfo";
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
