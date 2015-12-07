package com.airhacks.hello;

import java.time.LocalTime;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author airhacks.com
 */
@Startup
@Singleton
public class HeavyLifting {

    @PostConstruct
    public void init() {
        System.out.println("-- starting the singleton");
    }

    @Asynchronous
    public Future<String> lift() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HeavyLifting.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new AsyncResult<>("42");
    }

    //@Schedule(hour = "*", minute = "*", second = "*/2")
    public void repetetiveWork() {
        System.out.println("--- executing " + LocalTime.now());
    }

}
