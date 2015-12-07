package com.airhacks.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 *
 * @author airhacks.com
 */
@Path("greetings")
public class GreetingsResource {

    @GET
    public void whatever(@Suspended AsyncResponse response) {
        response.resume("async hello appserver " + System.currentTimeMillis());
    }

}
