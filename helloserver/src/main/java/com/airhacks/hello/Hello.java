package com.airhacks.hello;

import javax.enterprise.inject.Model;

/**
 *
 * @author airhacks.com
 */
@Model
public class Hello {

    public String getMessage() {
        return "for JSP " + System.currentTimeMillis();

    }

}
