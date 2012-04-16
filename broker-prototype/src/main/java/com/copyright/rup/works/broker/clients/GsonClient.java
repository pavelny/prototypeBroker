package com.copyright.rup.works.broker.clients;

import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IBrokerService;
import com.copyright.rup.works.broker.impl.BrokerService;
import com.copyright.rup.works.broker.impl.JsonConsumer;
import com.copyright.rup.works.broker.impl.JsonProducer;
import com.copyright.rup.works.broker.marshaler.GsonMarshaler;

/**
 * The client for Gson.
 *
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 04/12/12
 *
 * @author Andrei_Khadziukou
 *
 */
public class GsonClient extends BaseClient {

    /**
     * The entry point for running app.
     *
     * @param args
     *            The command line arguments.
     */
    public static void main(String[] args) {
        GsonClient client = new GsonClient();
        client.start(UtilVarialble.QUEUE_GSON);
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
        service.setMarshaler(new GsonMarshaler());
        return service;
    }

}
