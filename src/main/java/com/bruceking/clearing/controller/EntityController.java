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
import java.util.Calendar;
import java.util.Date;
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


/**
 * 该方法在清算部分已经用定时任务的方式实现，因此予以废止
 * 不可再手动进行清算，更新entity表中的各机构头寸
 */
//    @GetMapping("/getAllAmount")
//    public List<Entity> getAllData(){
//        List<Entity> entityList = entityService.findAllEntity();
//        ArrayList<Entity> result = new ArrayList();
//        Date today = new Date();
//        Calendar c = Calendar.getInstance();
//        c.setTime(today);
//        c.add(Calendar.DAY_OF_MONTH,-1);
//        Date yesterday = c.getTime();
//        for(Entity i : entityList){
//            BigDecimal bigDecimal = transactionService.countPosition(i.getEntityId(), yesterday);
//            i.setEntityDayPosition(bigDecimal);
//            i.setEntityBalance(i.getEntityBalance().subtract(bigDecimal));
//            result.add(i);
//        }
//
//        return result;
//    }
}
