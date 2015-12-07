package com.airhacks.hello;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("greetings")
public class GreetingsResource {

    @Inject
    EnterpriseGreetingResource bl;

    @Inject
    @EcoMode(EcoMode.Level.SMART)
    Engine engine;

    @PostConstruct
    public void initialize() {
        System.out.println("-- initialized");
    }

    @GET
    public void whatever(@Suspended AsyncResponse response) {
        this.engine.start();
        System.out.println("-- " + bl.getClass());
        response.resume("async hello appserver " + System.currentTimeMillis() + " " + bl.getMessage());
    }

}
