package com.copyright.rup.works.broker;

import org.apache.camel.builder.RouteBuilder;

/**
 * Routing rules for the broker.
 */
public class BrokerRoute extends RouteBuilder {

    public void configure() {
        from("jms:queue:works").to("jms:queue:storage").end();
        // from("jms:queue:storage").process(new WorksProcessor());
    }

}
