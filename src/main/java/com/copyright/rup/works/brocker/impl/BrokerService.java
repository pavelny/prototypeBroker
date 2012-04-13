/**
 *
 */
package com.copyright.rup.works.brocker.impl;

import com.copyright.rup.works.brocker.UtilVarialble;
import com.copyright.rup.works.brocker.api.IBrokerService;
import com.copyright.rup.works.brocker.api.IConsumer;
import com.copyright.rup.works.brocker.api.IMarshaler;
import com.copyright.rup.works.brocker.api.IProducer;
import com.copyright.rup.works.domain.api.IWork;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrei_Khadziukou
 *
 */
// TODO Add javadoc for type, variable, method and file
// TODO Create 2 interface for receive and send message.
public class BrokerService implements IBrokerService {

    // Constant variable for consumer and producer
    // private static final

    private IConsumer consumer;
    private IMarshaler marshaler;
    private IProducer producer;

    /**
     * @return the consumer
     */
    public IConsumer getConsumer() {
        return consumer;
    }

    /**
     * @return the marshaler
     */
    public IMarshaler getMarshaler() {
        return marshaler;
    }

    /**
     * @return the producer
     */
    public IProducer getProducer() {
        return producer;
    }

    /**
     * {@inheritDoc}
     */
    public List<IWork> receive(String queueName) {
        consumer.receiveWorks(queueName, UtilVarialble.CHUNK_SIZE, marshaler);
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void send(List<IWork> works, String queueName) {

        int startIndex = 0;
        int endIndex = UtilVarialble.CHUNK_SIZE;

        List<IWork> chunkWorks;
        do {
            if (endIndex > works.size()) {
                endIndex = works.size();
            }
            chunkWorks = new ArrayList<>(works.subList(startIndex, endIndex));
            startIndex = endIndex;
            endIndex += UtilVarialble.CHUNK_SIZE;
            producer.sendWorks(queueName, chunkWorks, marshaler);
            // TODO Check while (index <= works.size())
        } while (startIndex < works.size());
    }

    /**
     * @param consumer
     *            the consumer to set
     */
    public void setConsumer(IConsumer consumer) {
        this.consumer = consumer;
    }

    /**
     * @param marshaler
     *            the marshaler to set
     */
    public void setMarshaler(IMarshaler marshaler) {
        this.marshaler = marshaler;
    }

    /**
     * @param producer
     *            the producer to set
     */
    public void setProducer(IProducer producer) {
        this.producer = producer;
    }

}
