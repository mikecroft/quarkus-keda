package io.mikecroft.quarkus.keda;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class CamelProducer extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:foo?period={{timer.period}}")
            .setBody(simple("Hello AMQ! ${header.firedTime}"))
            // .log("my message at ${header.firedTime}")
            .to("amqp:queue:myqueue");
    }

}
