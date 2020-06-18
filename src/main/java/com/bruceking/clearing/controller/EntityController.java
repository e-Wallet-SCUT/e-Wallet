package com.bruceking.clearing.controller;

import com.bruceking.clearing.pojo.Entity;
import com.bruceking.clearing.service.EntityService;
import com.bruceking.clearing.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EntityController {

    @Autowired
    private EntityService entityService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/GetAllEntity")
    public List<Entity> selectByExample(){
        return entityService.findAllEntity();
    }





    @GetMapping("/getAllAmount")
    public List<Entity> getAllData(){
        List<Entity> entityList = entityService.findAllEntity();
        ArrayList<Entity> result = new ArrayList();
        for(Entity i : entityList){
            BigDecimal bigDecimal = transactionService.countPosition(i.getEntityId());
            i.setEntityDayPosition(bigDecimal);
            i.setEntityBalance(i.getEntityBalance().subtract(bigDecimal));
            result.add(i);
        }

        return result;
    }
}
