package com.airhacks.hello;

import javax.annotation.PostConstruct;
import javax.interceptor.Interceptors;

/**
 *
 * @author airhacks.com
 */
@Interceptors(PerformanceMonitor.class)
public class EnterpriseGreetingResource {

    @PostConstruct
    public void init() {
        System.out.println("initializing = " + this);
    }

    public String getMessage() {
        return "hello from muc" + System.currentTimeMillis();
    }

}
