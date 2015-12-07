package com.airhacks.hello;

/**
 *
 * @author airhacks.com
 */
@EcoMode(EcoMode.Level.SMART)
public class DieselEngine implements Engine {

    @Override
    public void start() {
        System.out.println(" starting diesel ");
    }

}
