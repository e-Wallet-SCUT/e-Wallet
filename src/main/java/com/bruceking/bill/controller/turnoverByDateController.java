package com.bruceking.bill.controller;


import com.bruceking.bill.bean.Account;
import com.bruceking.bill.bean.TurnOver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
public class turnoverByDateController {
    @Autowired
    com.bruceking.bill.mapper.transferMapper transferMapper;

    @GetMapping("/TurnoverByDate/{id}")
    public List<TurnOver> hello(@RequestParam(name = "BeginDate", required = false) String BeginDate,
                                @RequestParam(name = "EndDate", required = false) String EndDate,
                                @PathVariable("id") Integer id, Model model){
        Date Begin=null;
        Date End=null;
        model.addAttribute("payid",id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Begin=sdf.parse(BeginDate);
            End=sdf.parse(EndDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Collection<Account> payAccount =transferMapper.selectAccount(id);

        List<TurnOver> list = new ArrayList<>();
        TurnOver account1 = new TurnOver();
        account1.setY(0.0);
        account1.setAccount_type("中国工商银行");
        TurnOver account2 = new TurnOver();
        account2.setY(0.0);
        account2.setAccount_type("income");
        TurnOver account3 = new TurnOver();
        account3.setY(0.0);
        account3.setAccount_type("零钱");
        TurnOver account4 = new TurnOver();
        account4.setY(0.0);
        account4.setAccount_type("中国农业银行");
        TurnOver account5 = new TurnOver();
        account5.setY(0.0);
        account5.setAccount_type("中国建设银行");
        TurnOver account6 = new TurnOver();
        account6.setY(0.0);
        account6.setAccount_type("中国银行");


        list.add(account1);
        list.add(account2);
        list.add(account3);
        list.add(account4);
        list.add(account5);
        list.add(account6);

        for (Account account:payAccount){

            for (com.bruceking.bill.bean.transfer transfer: transferMapper.selectTransferByBDateAndEDate(account.getAccount_id(),Begin,End)){
                switch (account.getAccount_type()){
                    case (1):
                        account1.setY(account1.getY()+transfer.getTransfer_amount());
                        break;
                    case (2):
                        account2.setY(account2.getY()+transfer.getTransfer_amount());
                        break;
                    case (3):
                        account3.setY(account3.getY()+transfer.getTransfer_amount());
                        break;
                    case (4):
                        account4.setY(account4.getY()+transfer.getTransfer_amount());
                        break;
                    case (5):
                        account5.setY(account5.getY()+transfer.getTransfer_amount());
                        break;
                    case (6):
                        account6.setY(account6.getY()+transfer.getTransfer_amount());
                        break;
                }
            }
        }
        for(int i=5;i>=0;i--){
            if((double)list.get(i).getY()==0.0){
                list.remove(i);
            }
        }
        model.addAttribute("dataPoints",list);

        return list;
    }

}
