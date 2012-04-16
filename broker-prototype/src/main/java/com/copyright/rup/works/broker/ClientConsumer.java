package com.copyright.rup.works.broker;

import com.copyright.rup.works.broker.api.IConsumer;
import com.copyright.rup.works.broker.impl.BrokerService;
import com.copyright.rup.works.broker.impl.JsonConsumer;
import com.copyright.rup.works.broker.impl.ThriftConsumer;
import com.copyright.rup.works.broker.marshaler.GsonMarshaler;
import com.copyright.rup.works.broker.marshaler.JacksonMarshaler;
import com.copyright.rup.works.broker.marshaler.JaxbMarshaler;
import com.copyright.rup.works.broker.marshaler.XStreamMarshaler;

import org.apache.camel.ConsumerTemplate;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO Add javadoc everywhere
public final class ClientConsumer implements Runnable {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientConsumer.class);

    private Thread currentThread;

    private ConsumerTemplate consumerTemplate;

    public ClientConsumer(ConsumerTemplate consumerTemplate) {
        this.consumerTemplate = consumerTemplate;
    }

    public void start() {
        currentThread = new Thread(this);
    }

    public void stop() {
        currentThread = null;
    }

    public void run() {

        currentThread = new Thread(this);

        IConsumer consumer = new JsonConsumer(consumerTemplate);
        BrokerService service = new BrokerService();
        service.setConsumer(consumer);

//        // TODO move string literal into constant (remove from code)
        StopWatch stopWatchXStream = new Log4JStopWatch("consume.xstream");
        service.setMarshaler(new XStreamMarshaler());
        service.receive(UtilVarialble.CONSUMER_QUEUE_XSTREM);
        stopWatchXStream.stop();

        StopWatch stopWatchJaxb = new Log4JStopWatch("consume.jaxb");
        service.setMarshaler(new JaxbMarshaler());
        service.receive(UtilVarialble.CONSUMER_QUEUE_JAXB);
        stopWatchJaxb.stop();

        StopWatch stopWatchJackson = new Log4JStopWatch("consume.jackson");
        service.setMarshaler(new JacksonMarshaler());
        service.receive(UtilVarialble.CONSUMER_QUEUE_JACKSON);
        stopWatchJackson.stop();

        StopWatch stopWatchGson = new Log4JStopWatch("consume.gson");
        service.setMarshaler(new GsonMarshaler());
        service.receive(UtilVarialble.CONSUMER_QUEUE_GSON);
        stopWatchGson.stop();
//
        StopWatch stopWatchThrift = new Log4JStopWatch("consume.thrift");
        service.setConsumer(new ThriftConsumer(consumerTemplate));
        service.setMarshaler(null);
        service.receive(UtilVarialble.CONSUMER_QUEUE_THRIFT);
        stopWatchThrift.stop();

        try {
            consumerTemplate.stop();
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        stop();
    }
}
