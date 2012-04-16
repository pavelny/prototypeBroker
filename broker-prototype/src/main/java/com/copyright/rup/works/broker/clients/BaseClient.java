package com.copyright.rup.works.broker.clients;

import static com.copyright.rup.works.broker.UtilVarialble.CONTEXT_COMPANENT_NAME;

import com.copyright.rup.works.broker.Generator;
import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IBrokerService;
import com.copyright.rup.works.domain.api.IWork;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import java.util.LinkedList;
import java.util.List;

import javax.management.RuntimeErrorException;

/**
 * It is base class for clients.
 *
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/13/12
 *
 * @author Andrei_Khadziukou.
 *
 */
public abstract class BaseClient {

    private final Logger logger = Logger.getLogger(BaseClient.class);

    private static CamelContext context;
    private IBrokerService service;

    private List<IWork> works;

    /**
     * The default constructor
     */
    public BaseClient() {
        initContext();
        service = createBrokerService();
    }

    /**
     * The method for running producing and consumming.
     *
     * @param queue The name of queue, where messages will be stored and retrieved.
     */
    public void start(String queue) {
        runProducer(queue);
        runConsummer(queue);
    }

    /**
     * The method for creating specific broker service for client
     *
     * @return The specific broker service.
     */
    protected abstract IBrokerService createBrokerService();

    protected ConsumerTemplate getConsumerTemplate() {
        return context.createConsumerTemplate();
    }

    /**
     * @return
     */
    protected ProducerTemplate getProduceTemplate() {
        return context.createProducerTemplate();
    }

    private List<IWork> createWorksCollection(int size) {
        if (works == null || works.size() != size) {
            works = new LinkedList<IWork>();
            for (int i = 0; i < size; i++) {
                works.add(Generator.generateWork());
            }
        }
        return works;
    }

    private void initContext() {
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
        try {
            context.start();
        } catch (Error | Exception e) {
            logger.info("The default cammel context is not started.");
            throw new RuntimeErrorException(new Error(), "The context is not started. See logger information.");
        }
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

    /**
     * The method for stopping context.
     */
    public void stop() {
        try {
            context.stop();
        } catch (Exception e) {
            logger.info("The default camel context cannot be stoped!" + e.getMessage());
        }
    }
}
