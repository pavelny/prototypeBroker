package com.copyright.rup.works.broker.clients;

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

import com.copyright.rup.works.broker.Runner;
import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IBrokerService;
import com.copyright.rup.works.domain.api.IWork;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import java.util.LinkedList;
import java.util.List;

/**
 * It is base class for running clients.
 *
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/13/12
 *
 * @author Andrei_Khadziukou.
 *
 */
// TODO Add comments
public abstract class BaseClient {

    private static CamelContext context;
    private IBrokerService service;

    private List<IWork> works;

    public BaseClient() throws Exception {
        initContext();
        service = createBrokerService();
    }

    public void start(String queue) {
        runProducer(queue);
        runConsummer(queue);
    }

    protected abstract IBrokerService createBrokerService();

    protected ConsumerTemplate getConsumerTemplate() {
        return context.createConsumerTemplate();
    }

    protected ProducerTemplate getProduceTemplate() {
        return context.createProducerTemplate();
    }

    private List<IWork> createWorksCollection(int size) {
        if (works == null || works.size() != size) {
            works = new LinkedList<IWork>();
            for (int i = 0; i < size; i++) {
                works.add(Runner.generateWork());
            }
        }
        return works;
    }

    private void initContext() throws Exception {
        context = new DefaultCamelContext();
        context.addComponent(CONTEXT_COMPANENT_NAME,
                ActiveMQComponent.activeMQComponent(UtilVarialble.BROKER_CLIENT_URL));
//        context.addRoutes(new RouteBuilder() {
//            /**
//             * {@inheritDoc}
//             */
//            @Override
//            public void configure() throws Exception {
//                from(PRODUCER_QUEUE_XSTREM).to(CONSUMER_QUEUE_XSTREM).end();
//                from(PRODUCER_QUEUE_JAXB).to(CONSUMER_QUEUE_JAXB).end();
//                from(PRODUCER_QUEUE_JACKSON).to(CONSUMER_QUEUE_JACKSON).end();
//                from(PRODUCER_QUEUE_GSON).to(CONSUMER_QUEUE_GSON).end();
//                from(PRODUCER_QUEUE_THRIFT).to(CONSUMER_QUEUE_THRIFT).end();
//            }
//        });
        context.start();
    }

    /**
     *
     */
    private void runConsummer(String queue) {
        StopWatch stopWatchXStream = new Log4JStopWatch("consumer: " + queue);
        service.receive(queue);
        stopWatchXStream.stop();
    }

    /**
     *
     */
    private void runProducer(String queue) {
        List<IWork> works =  createWorksCollection(UtilVarialble.WORKS_COLLECTION_SIZE);
        StopWatch stopWatchXStream = new Log4JStopWatch("produce: " + queue);
        service.send(works, queue);
        stopWatchXStream.stop();
    }

    public void stop() throws Exception {
        context.stop();
    }
}
