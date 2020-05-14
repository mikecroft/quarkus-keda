package io.mikecroft.quarkus.keda;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class CamelConsumer extends RouteBuilder {

    long delay = 1600L;

    @Override
    public void configure() throws Exception {
        from("amqp:queue:myqueue")
            .delay(getDelay())
            .log("${body}");
    }

    public void setDelayInSeconds(long delayInSeconds) {
        setDelay(delayInSeconds * 1000);
    }

    public void setDelay(long delayInMillis) {
        this.delay = delayInMillis;
    }

    public long getDelay(){
        return this.delay;
    }

}