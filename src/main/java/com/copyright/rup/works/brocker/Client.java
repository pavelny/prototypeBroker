package com.copyright.rup.works.brocker;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public final class Client {

    private static final String BROKER_URL = "tcp://EPBYVITW0014:61616";
    private static final String PRODUCER_QUEUE = "jms:queue:works";
    private static final String CONSUMER_QUEUE = "jms:queue:storage";

    private static final int WORKS_COLLECTION_SIZE = 1000;

    private static CamelContext context;

    private Client() {
    }

    public static void main(String args[]) throws Exception {
        initContext();

        ClientProducer clientProducer = new ClientProducer(context.createProducerTemplate());
        new Thread(clientProducer).start();

        ClientConsumer clientConsumer = new ClientConsumer(context.createConsumerTemplate());
        new Thread(clientConsumer).start();

    }

    static private void initContext() throws Exception{
        context = new DefaultCamelContext();
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("jms:queue:worksxstream")
                        .to("jms:queue:storagexstream")
                        .end();
                from("jms:queue:worksjaxb")
                        .to("jms:queue:storagejaxb")
                        .end();
                from("jms:queue:worksjackson")
                        .to("jms:queue:storagejackson")
                        .end();
                from("jms:queue:worksgson")
                        .to("jms:queue:storagegson")
                        .end();
                from("jms:queue:worksthrift")
                        .to("jms:queue:storagethrift")
                        .end();
            }
        });
        context.start();

    }

}
