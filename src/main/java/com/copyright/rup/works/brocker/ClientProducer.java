package com.copyright.rup.works.brocker;

import com.copyright.rup.works.brocker.api.IProducer;
import com.copyright.rup.works.brocker.impl.BrokerService;
import com.copyright.rup.works.brocker.impl.JsonProducer;
import com.copyright.rup.works.brocker.marshaler.GsonMarshaler;
import com.copyright.rup.works.brocker.marshaler.JacksonMarshaler;
import com.copyright.rup.works.brocker.marshaler.JaxbMarshaler;
import com.copyright.rup.works.brocker.marshaler.XStreamMarshaler;
import com.copyright.rup.works.domain.api.IWork;

import org.apache.camel.ProducerTemplate;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public final class ClientProducer implements Runnable {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientProducer.class);

    private Thread currentThread;

    private ProducerTemplate producerTemplate;

    public ClientProducer(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    public void start() {
        currentThread = new Thread(this);
        currentThread.start();
    }

    public void stop() {
        currentThread = null;
    }

    public void run() {
        List<IWork> works = createWorksCollection(UtilVarialble.WORKS_COLLECTION_SIZE);

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

//        StopWatch stopWatchThrift = new Log4JStopWatch("produce.thrift");
//        service.setProducer(new ThriftProducer(producerTemplate));
//        service.setMarshaler(null);
//        service.send(works, UtilVarialble.PRODUCER_QUEUE_THRIFT);
//        stopWatchThrift.stop();

        try {
            producerTemplate.stop();
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        stop();
        Thread thread = Thread.currentThread();
        try {
            thread.sleep(100);
            thread.interrupt();
        } catch (InterruptedException e){
        }
    }

    private List<IWork> createWorksCollection(int size) {
        List<IWork> works = new LinkedList<IWork>();
        for (int i = 0; i < size; i++) {
            works.add(Runner.generateWork());
        }
        return works;
    }

}
