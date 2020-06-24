package com.bruceking.main.trans.controller;

import com.bruceking.main.loginPage.customer;
import com.bruceking.main.trans.entity.Account;
import com.bruceking.main.trans.entity.Transfer;
import com.bruceking.main.trans.service.TransService;
import com.bruceking.main.userInfo.userInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/trans")
@ComponentScan("com.bruceking.redis")
public class controller {

    @Autowired
    private TransService transService;

    @Autowired
    private userInfoService userInfoService;

    //@Autowired
    //private com.bruceking.redis.redisComponent redisComponent;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    //转账页面
    @GetMapping("")
    public String index(Model model){
        String username = userInfoService.getCurrentUser();
        customer user = userInfoService.getUserInfo(username);
        model.addAttribute("username",username);
        model.addAttribute("payid",user.getCustomer_id());
        return "transindex";
    }

    //判断余额，账户等
    @PostMapping("/transpd")
    public String tran1(Transfer transfer, Map<String,Object> map, Model model){

        Account payAccount = transService.selectAccount(transfer.getTransfer_pay_id(), transfer.getTransfer_pay_type());
        Account targetAccount = transService.selectAccount(transfer.getTransfer_target_id(), transfer.getTransfer_target_type());
        if(targetAccount != null){
            transfer.setTransfer_pay_account_id(payAccount.getAccount_id());
            transfer.setTransfer_target_account_id(targetAccount.getAccount_id());
            //将transfer加入缓存中
            redisTemplate.opsForValue().set("transfer",transfer);
        }

        //判断余额是否充足及对方账户是否存在
        if(targetAccount == null && payAccount.getAccount_balance() < transfer.getTransfer_amount()) {
            model.addAttribute("payid", transfer.getTransfer_pay_id());
            map.put("msgAccount", "对方账户不存在");
            map.put("msgBalance","账户余额不足");
            return "transindex";
        }
        else if(targetAccount != null && payAccount.getAccount_balance() < transfer.getTransfer_amount()){
            model.addAttribute("payid",transfer.getTransfer_pay_id());
            map.put("msgBalance","账户余额不足");
            return "transindex";
        }
        else if(targetAccount == null && payAccount.getAccount_balance() >= transfer.getTransfer_amount()){
            model.addAttribute("payid", transfer.getTransfer_pay_id());
            map.put("msgAccount", "对方账户不存在");
            return "transindex";
        }
        else{
            return "transpd";
        }
    }

    //判断密码，并存储交易信息
    @PostMapping("/transpd/correct")
    public String trans2(@RequestParam("password") String password,
                         Map<String,Object> map,Model model){

        //从缓存中取出transfer
        Transfer transfer = (Transfer) redisTemplate.opsForValue().get("transfer");
        assert transfer != null;
        Account account = transService.selectAccount(transfer.getTransfer_pay_id(),transfer.getTransfer_pay_type());
        String username = userInfoService.getCurrentUser();
        //判断密码是否正确
        if(account.getAccount_password().equals(password)){
            transService.insertTransfer(transfer);      //插入转账记录
            transService.updateAccount(transfer);       //更新账户余额
            transService.insertTransaction(transfer);   //插入交易记录
            model.addAttribute("username",username);
            return "transok";
        }
        else{
            map.put("msg","密码错误");
            model.addAttribute("username",username);
            return "transpd";
        }
    }

}
