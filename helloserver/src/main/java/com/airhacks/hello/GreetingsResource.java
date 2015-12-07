package com.airhacks.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("greetings")
public class GreetingsResource {

    @GET
    public String whatever() {
        return "hello appserver " + System.currentTimeMillis();
    }

}
