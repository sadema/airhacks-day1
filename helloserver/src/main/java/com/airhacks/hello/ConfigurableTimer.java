package com.airhacks.hello;

import java.time.LocalTime;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

/**
 *
 * @author airhacks.com
 */
@Startup
@Singleton
public class ConfigurableTimer {

    @Resource
    TimerService service;
    private Timer timer;

    @PostConstruct
    public void init() {
        ScheduleExpression expression = new ScheduleExpression();
        expression.second("*/10").minute("*").hour("*");
        this.timer = service.createCalendarTimer(expression);
        System.out.println("Timer configured!");
    }

    @Timeout
    public void whatever() {
        System.out.println("--- executed at: " + LocalTime.now());
    }

    @PreDestroy
    public void onShutdown() {
        this.timer.cancel();
    }

}
