package io.mikecroft.quarkus.keda;

import javax.json.Json;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/delay")
public class DelayResource {

    @ConfigProperty(name="consumer.delay")
    String delay;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDelay() {
        return delay;
    }

}