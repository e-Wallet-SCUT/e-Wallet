package com.bruceking.clearing.schedule;

import com.bruceking.clearing.pojo.Entity;
import com.bruceking.clearing.service.EntityService;
import com.bruceking.clearing.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 定时任务类，在每天的零点执行，用于将transaction表中前一天的transactions轧平成entity表中的各金融机构的头寸
 */
@Component
public class ScheduledService {

    @Autowired
    private EntityService entityService;

    @Autowired
    private TransactionService transactionService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void schedule(){

        List<Entity> entityList = entityService.findAllEntity();
        ArrayList<Entity> result = new ArrayList();
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH,-1);
        Date yesterday = c.getTime();
        for(Entity i : entityList){
            BigDecimal bigDecimal = transactionService.countPosition(i.getEntityId(), yesterday);
            i.setEntityDayPosition(bigDecimal);
            i.setEntityBalance(i.getEntityBalance().subtract(bigDecimal));
            entityService.modifyEntity(i);
        }

    }
}
