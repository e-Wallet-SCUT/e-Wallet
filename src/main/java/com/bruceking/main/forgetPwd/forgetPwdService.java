package com.bruceking.main.forgetPwd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class forgetPwdService {
    @Autowired
    private forgetPwdDao forgetPwdDao;
}
