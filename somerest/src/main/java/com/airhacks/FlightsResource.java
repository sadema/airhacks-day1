package com.airhacks;

import java.net.URI;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author airhacks.com
 */
@Path("flights")
public class FlightsResource {

    @Inject
    FlightScheduler scheduler;

    @GET
    @Path("{nbr}")
    public Flight flight(@PathParam("nbr") long nbr) {
        return this.scheduler.find(nbr);
    }

    @OPTIONS
    public Flight sample() {
        return new Flight("LH-42", 2);
    }

    @POST
    public Response save(Flight flight, @Context UriInfo info) {
        System.out.println("Saving: " + flight);
        Flight saved = this.scheduler.upsert(flight);
        URI uri = info.getAbsolutePathBuilder().
                path("/" + saved.getId()).
                build();
        return Response.created(uri).
                header("message", "have a nice flight").
                build();
    }

}
