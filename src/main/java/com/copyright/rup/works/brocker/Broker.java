package com.copyright.rup.works.brocker;

/**
 * Broker class.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/11/12
 *
 * @author Pavel_Yakovlev
 */
public final class Broker {
    private EmbeddableBroker broker;
    private String brokerUrl;

    public Broker(String url) {
        brokerUrl = url;
    }

    public void start() throws Exception {
        broker = new EmbeddableBroker(brokerUrl);
        broker.startBroker();
    }

    public void stop() throws Exception {
        synchronized (this) {
            broker.shutdown = true;
        }
        broker.join();
        broker = null;
    }

}

