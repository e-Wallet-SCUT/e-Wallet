package com.bruceking.main.userInfo;

import com.bruceking.main.loginPage.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin
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
        Integer id = userInfoService.getUserInfo(username).getCustomer_id();
        model.addAttribute("username",username);
        model.addAttribute("payid",id);
        return "userPage";
    }

    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public void updateUserInfo(
                                 @RequestParam("mobile") String mobile,
                                 @RequestParam("email") String email,
                                 @RequestParam("address") String address
    ){
        userInfoService.updateUserInfo(userInfoService.getCurrentUser(),mobile,email,address);
    }

}
