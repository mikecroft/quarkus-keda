package io.mikecroft.quarkus.keda;

import javax.json.Json;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/delay")
public class HelloResource {

    @Inject
    CamelConsumer consumer;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return Json.createObjectBuilder()
        .add("delay", this.consumer.getDelay())
        .build()
        .toString();
    }

    @GET
    @Path("{delay}")
    @Produces(MediaType.APPLICATION_JSON)
    public String setRate(@PathParam("delay") int delay) {
        consumer.setDelay(delay);
        return Json.createObjectBuilder()
            .add("delay", consumer.getDelay())
            .build()
            .toString();        
    }
}