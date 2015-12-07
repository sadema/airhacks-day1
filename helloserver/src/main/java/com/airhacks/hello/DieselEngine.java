package com.airhacks.hello;

import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
@EcoMode(EcoMode.Level.SMART)
public class DieselEngine implements Engine {

    @Inject
    @EcoMode(EcoMode.Level.SMART)
    Event<String> startListeners;

    @Override
    public void start() {
        System.out.println(" starting diesel ");
        startListeners.fire("engine started");
    }

}
