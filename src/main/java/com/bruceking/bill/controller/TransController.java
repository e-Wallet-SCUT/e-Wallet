package com.e_wallet.springboot.controller;

import com.e_wallet.springboot.bean.Account;
import com.e_wallet.springboot.bean.transfer;
import com.e_wallet.springboot.mapper.transferMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TransController {
    @Autowired
    transferMapper transferMapper;

    @GetMapping("/bill/{id}")
    public String index(@PathVariable("id") Integer id, Model model){
        model.addAttribute("payid",id);
        Collection<Account> payAccount =transferMapper.selectAccount(id);
        Map<Integer, transfer> transfers = new HashMap<>();
        for (Account account:payAccount){

            for (transfer transfer: transferMapper.selectTransfer(account.getAccount_id())){
                switch (transfer.getTransfer_pay_type()){
                    case ("1"):
                        transfer.setTransfer_pay_type("中国工商银行");
                        break;
                    case ("3"):
                        transfer.setTransfer_pay_type("零钱");
                        break;
                    case ("4"):
                        transfer.setTransfer_pay_type("中国农业银行");
                        break;
                    case ("5"):
                        transfer.setTransfer_pay_type("中国建设银行");
                        break;
                    case ("6"):
                        transfer.setTransfer_pay_type("中国银行");
                        break;
                }
                transfers.put(transfer.getTransfer_id(),transfer);
            }
        }
        model.addAttribute("transfers",transfers.values());
        return "bill";
    }

}
