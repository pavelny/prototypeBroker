package com.copyright.rup.works.broker;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.store.memory.MemoryPersistenceAdapter;

import java.io.File;

/**
 * Simple embeddable broker.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/11/12
 *
 * @author Pavel_Yakovlev
 */
public class EmbeddableBroker extends Thread {

    final String brokerUrl;
    Exception exception;
    boolean shutdown;

    public EmbeddableBroker(String url) {
        brokerUrl = url;
    }

    public void run() {
        try {
            BrokerService broker = new BrokerService();
            synchronized (this) {
                broker.setPersistenceAdapter(new MemoryPersistenceAdapter());
                broker.setTmpDataDirectory(new File(UtilVarialble.BROKER_TMP_DATA_DIRECTORY));
                broker.addConnector(brokerUrl);
                broker.start();
                Thread.sleep(200);
                notifyAll();
            }
            synchronized (this) {
                while (!shutdown) {
                    wait(1000);
                }
            }
            broker.stop();
        } catch (Exception e) {
            exception = e;
            e.printStackTrace();
        }
    }

    public void startBroker() throws Exception {
        synchronized (this) {
            super.start();
            try {
                wait();
                if (exception != null) {
                    throw exception;
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}