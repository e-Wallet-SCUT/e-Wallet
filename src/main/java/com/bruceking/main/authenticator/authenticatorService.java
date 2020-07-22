package com.bruceking.main.authenticator;

import com.bruceking.main.loginPage.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class authenticatorService {
    @Autowired
    private com.bruceking.main.loginPage.customerDao customerDao;

    public boolean checkUserPwd(String username, String password){
        try {
            customer user = customerDao.getUserByUsername(username);
            String pwd = user.getCustomer_password();
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            return bCryptPasswordEncoder.matches(password,pwd);
        }catch (NullPointerException e){
            return false;
        }
    }
}
