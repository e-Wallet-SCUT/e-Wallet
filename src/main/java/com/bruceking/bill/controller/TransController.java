package com.bruceking.bill.controller;


import com.bruceking.bill.bean.Account;
import com.bruceking.bill.bean.transfer;
import com.bruceking.bill.mapper.transferMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class TransController {
    @Autowired
    com.bruceking.bill.mapper.transferMapper transferMapper;

    @GetMapping("/bill/{id}")
    public String  hello(@PathVariable("id") Integer id, Model model){
        model.addAttribute("payid",id);
        Collection<Account> payAccount =transferMapper.selectAccount(id);
        Map<Integer, transfer> transfers = new HashMap<>();
        for (Account account:payAccount){

            for (transfer transfer: transferMapper.selectTransfer(account.getAccount_id())){
                switch (account.getAccount_type()){
                    case (1):
                        transfer.setTransfer_pay_type("中国工商银行");
                        break;
                    case (2):
                        transfer.setTransfer_pay_type("income");
                        break;
                    case (3):
                        transfer.setTransfer_pay_type("零钱");
                        break;
                    case (4):
                        transfer.setTransfer_pay_type("中国农业银行");
                        break;
                    case (5):
                        transfer.setTransfer_pay_type("中国建设银行");
                        break;
                    case (6):
                        transfer.setTransfer_pay_type("中国银行");
                        break;
                }
                transfers.put(transfer.getTransfer_id(),transfer);
            }
        }

        model.addAttribute("transfers",transfers.values());
        return "bill";
    }

    @PostMapping("/bill/{id}")
    public String hello(@RequestParam(name = "BeginDate", required = false) String BeginDate,
                        @RequestParam(name = "EndDate", required = false) String EndDate,
                        @PathVariable("id") Integer id, Model model,Map<String,Object> map, HttpSession session){
        Date Begin=null;
        Date End=null;
        model.addAttribute("payid",id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Begin=sdf.parse(BeginDate);
            End=sdf.parse(EndDate);
        } catch (ParseException e) {
            model.addAttribute("msg","日期为空或格式错误");
            return "redirect:/bill/"+id;
        }
        Collection<Account> payAccount =transferMapper.selectAccount(id);
        Map<Integer, transfer> transfers = new HashMap<>();
        for (Account account:payAccount){

            for (transfer transfer: transferMapper.selectTransferByBDateAndEDate(account.getAccount_id(),Begin,End)){
                switch (account.getAccount_type()){
                    case (1):
                        transfer.setTransfer_pay_type("中国工商银行");
                        break;
                    case (2):
                        transfer.setTransfer_pay_type("income");
                        break;
                    case (3):
                        transfer.setTransfer_pay_type("零钱");
                        break;
                    case (4):
                        transfer.setTransfer_pay_type("中国农业银行");
                        break;
                    case (5):
                        transfer.setTransfer_pay_type("中国建设银行");
                        break;
                    case (6):
                        transfer.setTransfer_pay_type("中国银行");
                        break;
                }
                transfers.put(transfer.getTransfer_id(),transfer);
            }
        }

        model.addAttribute("transfers",transfers.values());
        Calendar c= Calendar.getInstance();
        c.setTime(Begin);
        Calendar c2= Calendar.getInstance();
        c2.setTime(End);
        String url1="../TurnoverByDate/"+id+"?BeginDate="+c.get(Calendar.YEAR)+"%2F"+(c.get(Calendar.MONTH)+1)+"%2F"+c.get(Calendar.DAY_OF_MONTH);
        String url2="EndDate="+c2.get(Calendar.YEAR)+"%2F"+(c2.get(Calendar.MONTH)+1)+"%2F"+c2.get(Calendar.DAY_OF_MONTH);
        model.addAttribute("url1",url1);
        model.addAttribute("url2",url2);
        System.out.println(url1);
        model.addAttribute("Begin",BeginDate);
        model.addAttribute("End",EndDate);
        System.out.println( "BeginDate：" + BeginDate + "\nEndDate：" + EndDate);
        return "bill";
    }


}
