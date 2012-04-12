package com.copyright.rup.works.brocker;

import java.util.LinkedList;
import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.copyright.rup.works.brocker.api.IProducer;
import com.copyright.rup.works.brocker.impl.JsonProducer;
import com.copyright.rup.works.brocker.impl.ThriftProducer;
import com.copyright.rup.works.brocker.marshaler.GsonMarshaler;
import com.copyright.rup.works.brocker.marshaler.JacksonJsonMarshaler;
import com.copyright.rup.works.brocker.marshaler.JaxbJsonMarshaler;
import com.copyright.rup.works.brocker.marshaler.XStreamJsonMarshaler;
import com.copyright.rup.works.domain.api.IWork;

public final class ClientProducer implements Runnable {

    private static final String PRODUCER_QUEUE_XSTREM = "jms:queue:worksxstream";
    private static final String PRODUCER_QUEUE_JAXB = "jms:queue:worksjaxb";
    private static final String PRODUCER_QUEUE_JACKSON = "jms:queue:worksjackson";
    private static final String PRODUCER_QUEUE_GSON = "jms:queue:worksgson";
    private static final String PRODUCER_QUEUE_THRIFT = "jms:queue:worksthrift";

    private static final int WORKS_COLLECTION_SIZE = 1000;

    private ProducerTemplate producerTemplate;

    public ClientProducer(ProducerTemplate producerTemplate) {
        this.producerTemplate =  producerTemplate;
    }

    public void run() {
        List<IWork> works = createWorksCollection(WORKS_COLLECTION_SIZE);


        IProducer producer = new JsonProducer(producerTemplate);

        StopWatch stopWatchXStream = new Log4JStopWatch("produce.xstream");
        producer.sendWorks(PRODUCER_QUEUE_XSTREM, works, new XStreamJsonMarshaler());
        stopWatchXStream.stop();

        StopWatch stopWatchJaxb = new Log4JStopWatch("produce.jaxb");
        producer.sendWorks(PRODUCER_QUEUE_JAXB, works, new JaxbJsonMarshaler());
        stopWatchJaxb.stop();

        StopWatch stopWatchJackson = new Log4JStopWatch("produce.jackson");
        producer.sendWorks(PRODUCER_QUEUE_JACKSON, works, new JacksonJsonMarshaler());
        stopWatchJackson.stop();

        StopWatch stopWatchGson = new Log4JStopWatch("produce.gson");
        producer.sendWorks(PRODUCER_QUEUE_GSON, works, new GsonMarshaler());
        stopWatchGson.stop();

        StopWatch stopWatchThrift = new Log4JStopWatch("produce.thrift");
        producer = new ThriftProducer(producerTemplate);
        producer.sendWorks(PRODUCER_QUEUE_THRIFT, works, null);
        stopWatchThrift.stop();

        try {
            producerTemplate.stop();
        } catch (Exception e) {
           ///TODO use logger here
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
