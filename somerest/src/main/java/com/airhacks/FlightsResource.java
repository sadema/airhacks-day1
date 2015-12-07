package com.airhacks;

import java.net.URI;
import javax.json.JsonObject;
import javax.ws.rs.GET;
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

    @GET
    @Path("{carrier}-{nbr}")
    public Flight flight(@PathParam("carrier") String carrier, @PathParam("nbr") long nbr) {
        return new Flight(carrier + nbr, 42);
    }

    @POST
    public Response save(JsonObject flight, @Context UriInfo info) {
        System.out.println("Saving: " + flight);
        URI uri = info.getAbsolutePathBuilder().
                path("/" + System.currentTimeMillis()).
                build();
        return Response.created(uri).
                header("message", "have a nice flight").
                build();
    }

}
