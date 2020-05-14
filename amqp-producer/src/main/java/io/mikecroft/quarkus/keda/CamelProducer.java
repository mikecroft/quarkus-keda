package io.mikecroft.quarkus.keda;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class CamelProducer extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:foo?period=1000")
            .setBody(simple("Hello MQTT! ${header.firedTime}"))
            // .log("my message at ${header.firedTime}")
            .to("amqp:queue:myqueue");
    }

}
