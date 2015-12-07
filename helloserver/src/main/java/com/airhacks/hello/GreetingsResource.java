package com.airhacks.hello;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 *
 * @author airhacks.com
 */
@ApplicationScoped
@Path("greetings")
public class GreetingsResource {

    @Inject
    EnterpriseGreetingResource bl;

    @PostConstruct
    public void initialize() {
        System.out.println("-- initialized");
    }

    @GET
    public void whatever(@Suspended AsyncResponse response) {
        response.resume("async hello appserver " + System.currentTimeMillis() + " " + bl.getMessage());
    }

}
