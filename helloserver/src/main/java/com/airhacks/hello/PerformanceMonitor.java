package com.airhacks.hello;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author airhacks.com
 */
public class PerformanceMonitor {

    @AroundInvoke
    public Object monitor(InvocationContext ic) throws Exception {
        System.out.println("-- " + ic.getMethod());
        return ic.proceed();
    }

}
