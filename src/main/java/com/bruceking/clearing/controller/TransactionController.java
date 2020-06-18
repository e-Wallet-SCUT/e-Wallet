package com.bruceking.clearing.controller;

import com.bruceking.clearing.pojo.Transaction;
import com.bruceking.clearing.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/addTransaction")
    public String addTransaction(Transaction transaction){
        try {
            transactionService.addTransaction(transaction);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "redirect:/ok";
    }

    @GetMapping("/findAllTransaction")
    public String findAllTransaction(Model model){
        try {
            List<Transaction> transactions = transactionService.findAllTransaction();
            model.addAttribute("transactions",transactions);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "showTransaction";
    }

    @GetMapping("/countPosition/{entityId}")
    public BigDecimal countPosition(@PathVariable int entityId){

        BigDecimal bigDecimal = transactionService.countPosition(entityId);
        return bigDecimal;

    }




}
