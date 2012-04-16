package com.copyright.rup.works.broker.clients;

import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IBrokerService;
import com.copyright.rup.works.broker.impl.BrokerService;
import com.copyright.rup.works.broker.impl.JsonConsumer;
import com.copyright.rup.works.broker.impl.JsonProducer;
import com.copyright.rup.works.broker.marshaler.JaxbMarshaler;

/**
 * It is a client for JAXB.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 04/14/12þ
 *
 * @author Andrei_Khadziukou
 *
 */
public class JaxbClient extends BaseClient {

    /**
     * The entry point for app.
     *
     * @param args
     *            the command line argument.
     */
    public static void main(String[] args) {
        JaxbClient client = new JaxbClient();
        client.start(UtilVarialble.QUEUE_JAXB);
        client.stop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected IBrokerService createBrokerService() {
        BrokerService service = new BrokerService();
        service.setConsumer(new JsonConsumer(getConsumerTemplate()));
        service.setProducer(new JsonProducer(getProduceTemplate()));
        service.setMarshaler(new JaxbMarshaler());
        return service;
    }

}
