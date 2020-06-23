package com.bruceking.main.card;

import com.bruceking.main.loginPage.customer;
import com.bruceking.main.userInfo.userInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cardService {
    @Autowired
    private cardDao cardDao;
    @Autowired
    private com.bruceking.main.userInfo.userInfoService userInfoService;

    public boolean checkPwd(String inputPwd,int id){
        String pwd = cardDao.getAccountPwdByCustomerID(id);
        if (inputPwd.equals(pwd))
            return true;
        else
            return false;
    }

    public boolean haveCard(String name,String inputCard){
        List<String> cards = cardDao.getAccount_numberByCustomerName(name);
        int userID = cardDao.getIDByCustomer_name(name);
        List<String> bind = cardDao.getAccount_numberByCustomerID(userID);
        if (cards.contains(inputCard) && !bind.contains(inputCard))
            return true;
        else
            return false;
    }

    public boolean addCard(String account_number,int id,String account_password){
        int type = cardDao.getCardType(account_number);
        float balance = cardDao.getCardBalance(account_number);
        try {
            cardDao.addAccount_numberByCustomerID(account_number,id,type,balance,account_password);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
