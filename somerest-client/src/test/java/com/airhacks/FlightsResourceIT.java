package com.airhacks;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class FlightsResourceIT {

    private Client client;
    private WebTarget tut;

    @Before
    public void initClient() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8080/somerest/resources/flights/");
    }

    @Test
    public void flight() {
//{"id":0,"name":"LH-42","capacity":2}
        JsonObject input = Json.createObjectBuilder().add("name", "salt lake city").
                add("capacity", 2).build();

        Response response = this.tut.request().post(Entity.json(input));
        assertThat(response.getStatus(), is(201));
        String headerString = response.getHeaderString("Location");
        System.out.println("headerString = " + headerString);

        JsonObject createdFlight = this.client.target(headerString).
                request(MediaType.APPLICATION_JSON).
                get(JsonObject.class);
        System.out.println("createdFlight = " + createdFlight);

    }

}
