package com.copyright.rup.works.brocker;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.store.memory.MemoryPersistenceAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddableBroker.class);

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
            LOGGER.info(e.getMessage());
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
                LOGGER.info(ex.getMessage());
            }
        }
    }
}
