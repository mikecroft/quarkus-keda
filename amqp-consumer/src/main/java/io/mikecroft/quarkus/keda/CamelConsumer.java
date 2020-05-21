package io.mikecroft.quarkus.keda;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.json.Json;

import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class CamelConsumer extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("amqp:queue:myqueue")
            .delay(simple("{{consumer.delay}}"))
            .log("${body}");
    }

}