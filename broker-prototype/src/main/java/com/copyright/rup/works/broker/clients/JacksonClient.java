package com.copyright.rup.works.broker.clients;

import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IBrokerService;
import com.copyright.rup.works.broker.impl.BrokerService;
import com.copyright.rup.works.broker.impl.JsonConsumer;
import com.copyright.rup.works.broker.impl.JsonProducer;
import com.copyright.rup.works.broker.marshaler.JacksonMarshaler;

/**
 * It is a client class for Jackson.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 04/14/12.
 *
 * @author Andrei_Khadziukou
 */
public class JacksonClient extends BaseClient {

    /**
     * The entry point for app.
     *
     * @param args
     *            the command line argument.
     */
    public static void main(String[] args) {
        JacksonClient client = new JacksonClient();
        client.start(UtilVarialble.QUEUE_JACKSON);
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
        service.setMarshaler(new JacksonMarshaler());
        return service;
    }

}
