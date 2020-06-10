package com.bruceking.main.userInfo;


import com.bruceking.main.loginPage.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class userInfoService {

    @Autowired(required = false)
    private userInfoDao userInfoDao;

    public customer getUserInfo(String s){
        customer userInfo = userInfoDao.getUserInfoByUsername(s);
        return userInfo;
    }

    public void updateUserInfo(String username,
                               String name,
                               String age,
                               String sex,
                               String mobile,
                               String email,
                               String address,
                               Date date){
        userInfoDao.updateUserInfo(username,name,age,sex,mobile,email,address,date);
    }

    public String getCurrentUser(){
        //获取当前登录的username
        String currentUser = "";
        Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principl instanceof UserDetails) {
            currentUser = ((UserDetails)principl).getUsername();
        }else {
            currentUser = principl.toString();
        }
        return currentUser;
    }
}
