package com.copyright.rup.works.broker;

import com.copyright.rup.works.broker.api.IProducer;
import com.copyright.rup.works.broker.impl.BrokerService;
import com.copyright.rup.works.broker.impl.JsonProducer;
import com.copyright.rup.works.broker.impl.ThriftProducer;
import com.copyright.rup.works.broker.marshaler.GsonMarshaler;
import com.copyright.rup.works.broker.marshaler.JacksonMarshaler;
import com.copyright.rup.works.broker.marshaler.JaxbMarshaler;
import com.copyright.rup.works.broker.marshaler.XStreamMarshaler;
import com.copyright.rup.works.domain.api.IWork;

import org.apache.camel.ProducerTemplate;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import java.util.List;

public final class ClientProducer implements Runnable {

    private Thread currentThread;

    private ProducerTemplate producerTemplate;

    public ClientProducer(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    public void run() {
        List<IWork> works = null;// createWorksCollection(UtilVarialble.WORKS_COLLECTION_SIZE);

        IProducer producer = new JsonProducer(producerTemplate);
        BrokerService service = new BrokerService();
        service.setProducer(producer);

        StopWatch stopWatchXStream = new Log4JStopWatch("produce.xstream");
        service.setMarshaler(new XStreamMarshaler());
        service.send(works, UtilVarialble.PRODUCER_QUEUE_XSTREM);
        stopWatchXStream.stop();

        StopWatch stopWatchJaxb = new Log4JStopWatch("produce.jaxb");
        service.setMarshaler(new JaxbMarshaler());
        service.send(works, UtilVarialble.PRODUCER_QUEUE_JAXB);
        stopWatchJaxb.stop();

        StopWatch stopWatchJackson = new Log4JStopWatch("produce.jackson");
        service.setMarshaler(new JacksonMarshaler());
        service.send(works, UtilVarialble.PRODUCER_QUEUE_JACKSON);
        stopWatchJackson.stop();

        StopWatch stopWatchGson = new Log4JStopWatch("produce.gson");
        service.setMarshaler(new GsonMarshaler());
        service.send(works, UtilVarialble.PRODUCER_QUEUE_GSON);
        stopWatchGson.stop();

        StopWatch stopWatchThrift = new Log4JStopWatch("produce.thrift");
        service.setProducer(new ThriftProducer(producerTemplate));
        service.setMarshaler(null);
        service.send(works, UtilVarialble.PRODUCER_QUEUE_THRIFT);
        stopWatchThrift.stop();

        try {
            producerTemplate.stop();
        } catch (Exception e) {
            // /TODO use logger here
            e.printStackTrace();
        }
        stop();
        Thread thread = Thread.currentThread();
        try {
            thread.sleep(100);
            thread.interrupt();
        } catch (InterruptedException e) {
        }
    }

    public void start() {
        currentThread = new Thread(this);
        currentThread.start();
    }

    public void stop() {
        currentThread = null;
    }

}
