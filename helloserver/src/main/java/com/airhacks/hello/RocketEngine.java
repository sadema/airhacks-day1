package com.airhacks.hello;

/**
 *
 * @author airhacks.com
 */
@EcoMode(EcoMode.Level.USUAL)
public class RocketEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Starting rocket");
    }

}
