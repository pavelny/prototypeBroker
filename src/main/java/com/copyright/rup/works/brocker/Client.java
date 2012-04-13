package com.copyright.rup.works.brocker;

import static com.copyright.rup.works.brocker.UtilVarialble.*;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

// TODO Add javadoc
public final class Client {

    private static CamelContext context;
    private static final String CONTEXT_COMPANENT_NAME = "jms";

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
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(UtilVarialble.BROKER_CLIENT_URL);
        context.addComponent(CONTEXT_COMPANENT_NAME, JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(PRODUCER_QUEUE_XSTREM)
                        .to(CONSUMER_QUEUE_XSTREM)
                        .end();
                from(PRODUCER_QUEUE_JAXB)
                        .to(CONSUMER_QUEUE_JAXB)
                        .end();
                from(PRODUCER_QUEUE_JACKSON)
                        .to(CONSUMER_QUEUE_JACKSON)
                        .end();
                from(PRODUCER_QUEUE_GSON)
                        .to(CONSUMER_QUEUE_GSON)
                        .end();
                from(PRODUCER_QUEUE_THRIFT)
                        .to(CONSUMER_QUEUE_THRIFT)
                        .end();
            }
        });
        context.start();

    }

}
