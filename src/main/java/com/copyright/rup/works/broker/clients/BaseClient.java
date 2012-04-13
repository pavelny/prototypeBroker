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

import java.util.LinkedList;
import java.util.List;

/**
 * @author Andrei_Khadziukou
 *
 */
public abstract class BaseClient {

    private static CamelContext context;
    private IBrokerService service;

    public BaseClient() throws Exception {
        initContext();
        service = createBrokerService();
    }

    private List<IWork> works;

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
        context.addRoutes(new RouteBuilder() {
            /**
             * {@inheritDoc}
             */
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

    protected ProducerTemplate getProduceTemplate() {
        return context.createProducerTemplate();
    }

    protected ConsumerTemplate getConsumerTemplate() {
        return context.createConsumerTemplate();
    }

    /**
     *
     */
    private void runConsummer(String queue) {
        service.receive(queue);
    }

    /**
     *
     */
    private void runProducer(String queue) {
        service.send(createWorksCollection(UtilVarialble.WORKS_COLLECTION_SIZE), queue);
    }

    protected abstract IBrokerService createBrokerService();

    /**
     *
     */
    public void start(String producerQueue, String consumerQueue) {
        runProducer(producerQueue);
        runConsummer(consumerQueue);
    }
}
