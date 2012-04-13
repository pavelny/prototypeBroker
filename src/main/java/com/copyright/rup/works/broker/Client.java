package com.copyright.rup.works.broker;

import static com.copyright.rup.works.broker.UtilVarialble.CONSUMER_QUEUE_GSON;
import static com.copyright.rup.works.broker.UtilVarialble.CONSUMER_QUEUE_JACKSON;
import static com.copyright.rup.works.broker.UtilVarialble.CONSUMER_QUEUE_JAXB;
import static com.copyright.rup.works.broker.UtilVarialble.CONSUMER_QUEUE_THRIFT;
import static com.copyright.rup.works.broker.UtilVarialble.CONSUMER_QUEUE_XSTREM;
import static com.copyright.rup.works.broker.UtilVarialble.CONTEXT_COMPANENT_NAME;
import static com.copyright.rup.works.broker.UtilVarialble.PRODUCER_QUEUE_GSON;
import static com.copyright.rup.works.broker.UtilVarialble.PRODUCER_QUEUE_JACKSON;
import static com.copyright.rup.works.broker.UtilVarialble.PRODUCER_QUEUE_JAXB;
import static com.copyright.rup.works.broker.UtilVarialble.PRODUCER_QUEUE_THRIFT;
import static com.copyright.rup.works.broker.UtilVarialble.PRODUCER_QUEUE_XSTREM;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

// TODO Add javadoc
public final class Client {

    private static CamelContext context;


    public static void main(String args[]) throws Exception {
        initContext();

//        ClientProducer clientProducer = new ClientProducer(context.createProducerTemplate());
//        new Thread(clientProducer).start();
//        clientProducer.start();

//        ClientConsumer clientConsumer = new ClientConsumer(context.createConsumerTemplate());
//        new Thread(clientConsumer).start();

    }

    static private void initContext() throws Exception {
        context = new DefaultCamelContext();
        context.addComponent(CONTEXT_COMPANENT_NAME,
                ActiveMQComponent.activeMQComponent(UtilVarialble.BROKER_CLIENT_URL));
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(PRODUCER_QUEUE_XSTREM).to(CONSUMER_QUEUE_XSTREM).end();
                from(PRODUCER_QUEUE_JAXB).to(CONSUMER_QUEUE_JAXB).end();
                from(PRODUCER_QUEUE_JACKSON).to(CONSUMER_QUEUE_JACKSON).end();
                from(PRODUCER_QUEUE_GSON).to(CONSUMER_QUEUE_GSON).end();
                from(PRODUCER_QUEUE_THRIFT).to(CONSUMER_QUEUE_THRIFT).end();
            }
        });
        context.start();

    }

    private Client() {
    }

}
