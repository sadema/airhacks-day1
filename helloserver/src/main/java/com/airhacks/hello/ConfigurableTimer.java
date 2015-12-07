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
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

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

    @Inject
    Instance<String> message;

    @PostConstruct
    public void init() {
        ScheduleExpression expression = new ScheduleExpression();
        expression.second("*/10").minute("*").hour("*");
        this.timer = service.createCalendarTimer(expression);
        System.out.println("Timer configured!");
    }

    @Timeout
    public void whatever() {
        System.out.println("--- executed at: " + LocalTime.now() + " " + message.get());
    }

    @PreDestroy
    public void onShutdown() {
        this.timer.cancel();
    }

}
