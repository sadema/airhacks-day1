package com.airhacks.hello;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author airhacks.com
 */
public class EngineController {

    public void onNewStart(@Observes(during = TransactionPhase.AFTER_SUCCESS) String startEvent) {
        System.out.println("###################startEvent = " + startEvent);
    }

    public void onFailedStart(@Observes(during = TransactionPhase.AFTER_FAILURE) String startEvent) {
        System.out.println("-------------------startEvent = " + startEvent);
    }

}
