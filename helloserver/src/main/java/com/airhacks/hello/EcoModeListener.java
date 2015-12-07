package com.airhacks.hello;

import javax.enterprise.event.Observes;

/**
 *
 * @author airhacks.com
 */
public class EcoModeListener {

    public void onEvent(@Observes @EcoMode(EcoMode.Level.SMART) String event) {
        System.out.println("Smart event: " + event);
    }

}
