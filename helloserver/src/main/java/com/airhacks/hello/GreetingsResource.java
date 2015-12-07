package com.airhacks.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
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

    @Inject
    HeavyLifting lift;

    @Resource
    SessionContext ctx;

    @PostConstruct
    public void initialize() {
        System.out.println("-- initialized");
    }

    @GET
    public void whatever(@Suspended AsyncResponse response) {
        List<Future<String>> computations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> future = lift.lift();
            computations.add(future);
        }
        for (Future<String> computation : computations) {
            try {
                System.out.println(computation.get());
            } catch (InterruptedException | ExecutionException ex) {

            }
        }
        this.engine.start();
        System.out.println("-- " + bl.getClass());
        response.resume("async hello appserver " + System.currentTimeMillis() + " " + bl.getMessage());
    }

}
