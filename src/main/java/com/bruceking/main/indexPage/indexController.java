package com.bruceking.main.indexPage;

import com.bruceking.main.userInfo.userInfoService;
import com.bruceking.redis.redisComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@ComponentScan("com.bruceking.redis") /**Scan到redis**/
public class indexController {

    @Autowired
    private userInfoService userInfoService;
    @Autowired
    private redisComponent redisComponent;


    @RequestMapping("/info")
    @ResponseBody
    public String UserInfo(){
        String currentUser = userInfoService.getCurrentUser();
        return currentUser;
    }

    @RequestMapping("/")
    public String index(Model model){
        String currentUser = userInfoService.getCurrentUser();

        if (currentUser == "anonymousUser"){
            model.addAttribute("logined",true);
        }else {
            Map<String, Object> map = new HashMap<>();
            map.put("logined",false);
            map.put("username",currentUser);
            model.addAllAttributes(map);
        }

        return "index";
    }


    @RequestMapping("/getSessionID")
    @ResponseBody
    public Map testRedis(@RequestParam("key") String key){
        Map<String,Object> map = new HashMap<>();
        map.put("result", redisComponent.getSet(key));
        return map;
    }

}
