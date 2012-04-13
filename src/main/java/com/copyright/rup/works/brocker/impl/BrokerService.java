/**
 *
 */
package com.copyright.rup.works.brocker.impl;

import java.util.List;

import com.copyright.rup.works.brocker.api.IBrokerService;
import com.copyright.rup.works.brocker.api.IConsumer;
import com.copyright.rup.works.brocker.api.IMarshaler;
import com.copyright.rup.works.brocker.api.IProducer;
import com.copyright.rup.works.domain.api.IWork;

/**
 * @author Andrei_Khadziukou
 *
 */
// TODO Add javadoc for type and file
public class BrokerService implements IBrokerService {

    private IMarshaler marshaler;
    private IConsumer consumer;
    private IProducer producer;

    /**
     * {@inheritDoc}
     */
    public void send(List<IWork> works, String queueName) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    public List<IWork> recive(String queueName) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return the marshaler
     */
    public IMarshaler getMarshaler() {
        return marshaler;
    }

    /**
     * @param marshaler the marshaler to set
     */
    public void setMarshaler(IMarshaler marshaler) {
        this.marshaler = marshaler;
    }

    /**
     * @return the consumer
     */
    public IConsumer getConsumer() {
        return consumer;
    }

    /**
     * @param consumer the consumer to set
     */
    public void setConsumer(IConsumer consumer) {
        this.consumer = consumer;
    }

    /**
     * @return the producer
     */
    public IProducer getProducer() {
        return producer;
    }

    /**
     * @param producer the producer to set
     */
    public void setProducer(IProducer producer) {
        this.producer = producer;
    }

}
