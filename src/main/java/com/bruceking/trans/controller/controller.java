package com.bruceking.trans.controller;

import com.bruceking.trans.entity.Account;
import com.bruceking.trans.entity.Transfer;
import com.bruceking.trans.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/trans")
public class controller {

    @Autowired
    private TransService transService;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    //转账页面
    @GetMapping("/{id}")
    public String index(@PathVariable("id") Integer id, Model model){
        model.addAttribute("payid",id);
        return "transindex";
    }

    //判断余额，账户等
    @PostMapping("/transpd")
    public String tran1(Transfer transfer, Map<String,Object> map, Model model){

        //将transfer加入缓存中
        redisTemplate.opsForValue().set("transfer",transfer);
        Account payAccount = transService.selectAccount(transfer.getTransfer_pay_id(), transfer.getTransfer_pay_bank());
        Account targetAccount = transService.selectAccount(transfer.getTransfer_target_id(), transfer.getTransfer_target_bank());

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
                         Map<String,Object> map){

        //从缓存中取出transfer
        Transfer transfer = (Transfer) redisTemplate.opsForValue().get("transfer");
        assert transfer != null;
        Account account = transService.selectAccount(transfer.getTransfer_pay_id(),transfer.getTransfer_pay_bank());

        //判断密码是否正确
        if(account.getAccount_password().equals(password)){
            transService.insertTrans(transfer);     //插入转账记录
            transService.updateAccount(transfer);   //更新账户余额
            return "transok";
        }
        else{
            map.put("msg","密码错误");
            return "transpd";
        }
    }

}
