package com.copyright.rup.works.broker.clients;

import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IBrokerService;
import com.copyright.rup.works.broker.impl.BrokerService;
import com.copyright.rup.works.broker.impl.JsonConsumer;
import com.copyright.rup.works.broker.impl.JsonProducer;
import com.copyright.rup.works.broker.marshaler.XStreamMarshaler;

/**
 * It is a client class for Xstream.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 04/13/12.
 *
 * @author Andrei_Khadziukou.
 *
 */
public class XstreamClient extends BaseClient {

    /**
     * The entry point for app.
     *
     * @param args the command linr argument
     */
    public static void main(String[] args) {

        try {
            XstreamClient client = new XstreamClient();
            client.start(UtilVarialble.QUEUE_XSTREM);
            client.stop();
        } catch (Exception exc) {
            // TODO Add log
            exc.printStackTrace();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected IBrokerService createBrokerService() {
        BrokerService service = new BrokerService();
        service.setConsumer(new JsonConsumer(getConsumerTemplate()));
        service.setProducer(new JsonProducer(getProduceTemplate()));
        service.setMarshaler(new XStreamMarshaler());
        return service;
    }

}