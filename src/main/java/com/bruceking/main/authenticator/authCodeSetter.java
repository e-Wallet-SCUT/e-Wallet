package com.bruceking.main.authenticator;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
public class authCodeSetter implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(() -> {
            System.out.println("aaa");
        }, triggerContext -> {
            CronTrigger cronTrigger = new CronTrigger("0/1 * * * * ?");
            return cronTrigger.nextExecutionTime(triggerContext);
        });
    }
}
