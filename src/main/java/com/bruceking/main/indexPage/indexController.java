package com.bruceking.main.indexPage;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class indexController {
    @RequestMapping("/info")
    @ResponseBody
    public String UserInfo(){
        String currentUser = "";
        Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principl instanceof UserDetails) {
            currentUser = ((UserDetails)principl).getUsername();
        }else {
            currentUser = principl.toString();
        }
        return currentUser;
    }

    @RequestMapping("/")
    public String index(Model model){
        String currentUser = "";
        Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principl instanceof UserDetails) {
            currentUser = ((UserDetails)principl).getUsername();
        }else {
            currentUser = principl.toString();
        }
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

}
