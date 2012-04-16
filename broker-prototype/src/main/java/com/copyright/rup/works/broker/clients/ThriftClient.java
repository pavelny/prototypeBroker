package com.copyright.rup.works.broker.clients;

import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IBrokerService;
import com.copyright.rup.works.broker.impl.BrokerService;
import com.copyright.rup.works.broker.impl.ThriftConsumer;
import com.copyright.rup.works.broker.impl.ThriftProducer;

/**
 * It is a client for thrift.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 04/14/12.
 *
 * @author Andrei_Khadziukou
 *
 */
public class ThriftClient extends BaseClient {

    /**
     * The entry point for app.
     *
     * @param args
     *            the command line argument.
     */
    public static void main(String[] args) {
        ThriftClient client = new ThriftClient();
        client.start(UtilVarialble.QUEUE_THRIFT);
        client.stop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected IBrokerService createBrokerService() {
        BrokerService service = new BrokerService();
        service.setConsumer(new ThriftConsumer(getConsumerTemplate()));
        service.setProducer(new ThriftProducer(getProduceTemplate()));
        service.setMarshaler(null);
        return service;
    }

}
