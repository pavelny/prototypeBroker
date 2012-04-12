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

//
//
//        List<Work> works = createWorksCollection(WORKS_COLLECTION_SIZE);
//
//        ProducerTemplate producerTemplate = context.createProducerTemplate();
//        IProducer producer = new JsonProducer(producerTemplate);
//
//        StopWatch stopWatchXStream = new Log4JStopWatch("produce.xstream");
//
//        producer.sendWorks(PRODUCER_QUEUE, works, new XStreamJsonMarshaler());
//        ConsumerTemplate consumerTemplate = context.createConsumerTemplate();
//        IConsumer consumer = new JsonConsumer(consumerTemplate);
//        consumer.receiveWorks(CONSUMER_QUEUE, WORKS_COLLECTION_SIZE);
//
//        stopWatchXStream.stop();
//
//        StopWatch stopWatchJaxb = new Log4JStopWatch("produce.jaxb");
//
//        producer.sendWorks(PRODUCER_QUEUE, works, new JaxbJsonMarshaler());
//        consumer.receiveWorks(CONSUMER_QUEUE, WORKS_COLLECTION_SIZE);
//
//        stopWatchJaxb.stop();
//
//        StopWatch stopWatchJackson = new Log4JStopWatch("produce.jackson");
//
//        producer.sendWorks(PRODUCER_QUEUE, works, new JacksonJsonMarshaler());
//        consumer.receiveWorks(CONSUMER_QUEUE, WORKS_COLLECTION_SIZE);
//
//        stopWatchJackson.stop();
//
//        StopWatch stopWatchGson = new Log4JStopWatch("produce.gson");
//
//        producer.sendWorks(PRODUCER_QUEUE, works, new GsonMarshaler());
//        consumer.receiveWorks(CONSUMER_QUEUE, WORKS_COLLECTION_SIZE);
//
//        stopWatchGson.stop();
//
//        StopWatch stopWatchThrift = new Log4JStopWatch("produce.thrift");
//
//        producer = new ThriftProducer(producerTemplate);
//        producer.sendWorks(PRODUCER_QUEUE, works, null);
//        consumer = new ThriftConsumer(consumerTemplate);
//        consumer.receiveWorks(CONSUMER_QUEUE, WORKS_COLLECTION_SIZE);
//
//        stopWatchThrift.stop();
//
//        producerTemplate.stop();
//        consumerTemplate.stop();
//        context.stop();
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

    static private List<Work> createWorksCollection(int sizeOfCollection) {
        List<Work> works = new LinkedList<Work>();
        for (int i = 0; i < sizeOfCollection; i++) {
            long time = (new Date()).getTime();
            Work work = createWork(time + i);
            works.add(work);
        }
        return works;
    }

    static private Work createWork(long time) {
        Work work = new Work();
        work.setId(String.valueOf(time));
        work.setLanguage("English");
        List<String> titles = new ArrayList<String>();
        for (int i = 1; i < 11; i++) {
            titles.add("TestTitle" + i);
        }
        work.setTitles(titles);
        return work;
    }

}
