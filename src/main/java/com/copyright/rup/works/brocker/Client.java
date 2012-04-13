package com.copyright.rup.works.brocker;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
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
//        clientProducer.start();
        new Thread(clientProducer).start();
//        ClientProducer.start();

        ClientConsumer clientConsumer = new ClientConsumer(context.createConsumerTemplate());
        new Thread(clientConsumer).start();

    }

    static private void initContext() throws Exception{
        context = new DefaultCamelContext();
//        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
//        context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        context.addComponent("activemq", ActiveMQComponent.activeMQComponent(BROKER_URL));
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("activemq:queue:worksxstream")
                        .to("activemq:queue:storagexstream")
                        .end();
                from("activemq:queue:worksjaxb")
                        .to("activemq:queue:storagejaxb")
                        .end();
                from("activemq:queue:worksjackson")
                        .to("activemq:queue:storagejackson")
                        .end();
                from("activemq:queue:worksgson")
                        .to("activemq:queue:storagegson")
                        .end();
                from("activemq:queue:worksthrift")
                        .to("activemq:queue:storagethrift")
                        .end();
            }
        });
        context.start();

    }

}
