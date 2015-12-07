package com.airhacks.hello;

import javax.annotation.PostConstruct;

/**
 *
 * @author airhacks.com
 */
public class EnterpriseGreetingResource {

    @PostConstruct
    public void init() {
        System.out.println("initializing = " + this);
    }

    public String getMessage() {
        return "hello from muc" + System.currentTimeMillis();
    }

}
