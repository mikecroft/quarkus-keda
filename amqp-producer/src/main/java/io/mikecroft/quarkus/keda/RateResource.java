package io.mikecroft.quarkus.keda;

import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rate")
public class RateResource {

    private int rate = 5;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRate() {
        return Json.createObjectBuilder()
            .add("rate", rate)
            .build()
            .toString();
    }

    @GET
    @Path("{rate}")
    @Produces(MediaType.APPLICATION_JSON)
    public String setRate(@PathParam("rate") int rate) {
        this.rate = rate;
        return Json.createObjectBuilder()
            .add("rate", rate)
            .build()
            .toString();        
    }
}