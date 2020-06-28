package com.bruceking.main.trans.controller;

import com.bruceking.main.loginPage.customer;
import com.bruceking.main.trans.entity.Account;
import com.bruceking.main.trans.entity.Withdraw;
import com.bruceking.main.trans.service.TransService;
import com.bruceking.main.userInfo.userInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/withdraw")
@ComponentScan("com.bruceking.redis")
public class WithdrawController {

    @Autowired
    private TransService transService;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private com.bruceking.main.userInfo.userInfoService userInfoService;

    //提现页面
    @GetMapping("")
    public String index(Model model){
        String username = userInfoService.getCurrentUser();
        customer user = userInfoService.getUserInfo(username);
        model.addAttribute("username",username);
        model.addAttribute("payid",user.getCustomer_id());
        return "withdrawindex";
    }

    //判断条件
    @PostMapping("/withdrawpd")
    public String withdrawpd(Withdraw withdraw, Map<String, Object> map, Model model){

        redisTemplate.opsForValue().set("withdraw",withdraw);
        Account pay_account = transService.selectAccount(withdraw.getId(),3);
        if (pay_account.getAccount_balance()<withdraw.getAmount()) {
            model.addAttribute("payid",withdraw.getId());
            map.put("msgBalance", "账户余额不足");
            return "withdrawindex";
        }
        else{
            return "withdrawpd";
        }
    }

    @PostMapping("/withdrawpd/correct")
    public String withdrawpd2(@RequestParam("password") String password, Map<String,Object> map){
        Withdraw withdraw = (Withdraw) redisTemplate.opsForValue().get("withdraw");
        assert withdraw != null;
        Account account = transService.selectAccount(withdraw.getId(),3);
        if (account.getAccount_password().equals(password)){
            transService.updateAccountw(withdraw);
            transService.insertWithdraw(withdraw);
            transService.updateIncome(withdraw);
            return "transok";
        }
        else{
            map.put("msg","密码错误");
            return "withdrawpd";
        }
    }
}
