package com.airhacks.hello;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author airhacks.com
 */
public class Configurator {

    @Produces
    public String expose(InjectionPoint ip) {
        Class<?> declaringClass = ip.getMember().getDeclaringClass();
        String name = ip.getMember().getName();
        return "configured 42 " + declaringClass.getName() + "." + name;
    }

}
