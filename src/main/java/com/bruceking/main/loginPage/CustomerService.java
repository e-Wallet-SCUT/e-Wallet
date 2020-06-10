package com.bruceking.main.loginPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomerService implements UserDetailsService {
    @Autowired
    private customerDao customerDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        customer userByUsername = customerDao.getUserByUsername(s);
        //创建一个新的UserDetails对象，最后验证登陆的需要
        UserDetails userDetails=null;
        if(userByUsername!=null){
            //创建一个集合来存放权限
            Collection<GrantedAuthority> authorities = getAuthorities(userByUsername);
            //实例化UserDetails对象
            userDetails=new User(s,userByUsername.getCustomer_password(),true,true,true,true, authorities);
        }
        return userDetails;
    }

    //获取权限
    private Collection<GrantedAuthority> getAuthorities(customer user){
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority("ROLE_"+"USER")); //将所有权限设为用户
        return authList;
    }



}
