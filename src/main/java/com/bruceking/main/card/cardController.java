package com.bruceking.main.card;

import com.bruceking.main.loginPage.customer;
import com.bruceking.main.userInfo.userInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin
public class cardController {

    @Autowired
    private cardService cardService;
    @Autowired
    private com.bruceking.main.userInfo.userInfoService userInfoService;
    @Autowired
    private com.bruceking.redis.redisComponent redisComponent;

    @RequestMapping("/checkPwd")
    @ResponseBody
    public Map<String, Boolean> checkPwdAPI(@RequestParam("pwd") String pwd){
        String username = userInfoService.getCurrentUser();
        customer user = userInfoService.getUserInfo(username);
        int userID = user.getCustomer_id();
//        int userID  = 1;
        Map<String,Boolean> map = new HashMap<>();
        if (cardService.checkPwd(pwd,userID)){
            map.put("result",true);
        }
        else {
            map.put("result",false);
        }
        return map;
    }

    @RequestMapping("/haveCard")
    @ResponseBody
    public Map<String,Boolean> haveCard(@RequestParam("cardNum") String cardNum){
//        String username = "用户1";
        String username = userInfoService.getCurrentUser();
        customer user = userInfoService.getUserInfo(username);
        String name = user.getCustomer_name();
        Map<String,Boolean> map = new HashMap<>();
        if (cardService.haveCard(name,cardNum))
            map.put("result",true);
        else
            map.put("result",false);
        return map;
    }

    @RequestMapping("/addCard")
    @ResponseBody
    public Map<String,Boolean> addCard(@RequestParam("cardNum") String cardNum,@RequestParam("pwd") String pwd,@RequestParam("code")int inputCode){
//        int userID  = 1;
        String username = userInfoService.getCurrentUser();
        customer user = userInfoService.getUserInfo(username);
        int userID = user.getCustomer_id();
        Map<String,Boolean> map = new HashMap<>();
        int code = Integer.parseInt(redisComponent.getKey(cardNum).toString().trim());
        if (code == inputCode){
            if (cardService.addCard(cardNum,userID,pwd))
                map.put("result",true);
        }
        else
            map.put("result",false);
        return map;
    }

    @RequestMapping("/getCode")
    @ResponseBody
    public Map<String,String> getCode(@RequestParam("cardNum") String cardNum){
        String code = String.valueOf((int)Math.round((Math.random()+1) * 1000));
        redisComponent.delKey(cardNum);
        redisComponent.setKey(cardNum,code,600);
        Map<String,String> map = new HashMap<>();
        map.put("code",code);
        return map;

    }
}
