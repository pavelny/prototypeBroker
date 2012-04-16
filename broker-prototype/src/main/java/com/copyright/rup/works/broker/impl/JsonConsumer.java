package com.copyright.rup.works.broker.impl;

<<<<<<< HEAD:src/main/java/com/copyright/rup/works/brocker/impl/JsonConsumer.java
import com.copyright.rup.works.brocker.api.IConsumer;
import com.copyright.rup.works.brocker.api.IMarshaler;
=======
import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IConsumer;
import com.copyright.rup.works.broker.api.IMarshaler;
>>>>>>> 2f054807a815ed8a61117676e1ffbd0930864d91:broker-prototype/src/main/java/com/copyright/rup/works/broker/impl/JsonConsumer.java
import com.copyright.rup.works.domain.api.IWork;

import org.apache.camel.ConsumerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Json implementation of consumer.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/11/12
 *
 * @author Pavel_Yakovlev
 */
// TODO Add javadoc
public class JsonConsumer implements IConsumer {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonConsumer.class);

    private ConsumerTemplate consumer;

    public JsonConsumer(ConsumerTemplate consumer) {
        this.consumer = consumer;
    }

    /**
     * {@inheritDoc}
     */
    public void receiveWorks(String nameOfQueue, int expectedSizeOfCollection, IMarshaler marshaler) {
        List<IWork> works = new LinkedList<IWork>();
        List<IWork> chunkWorks = new LinkedList<IWork>();

        try {
            ///TODO realize another method of retrieving messages
            for (int i = 0; i < UtilVarialble.WORKS_COLLECTION_SIZE/expectedSizeOfCollection; i++) {
                chunkWorks = marshaler.toEntities(consumer.receiveBody(nameOfQueue).toString());
                works.addAll(chunkWorks);
            }
        } catch (Exception e) {
<<<<<<< HEAD:src/main/java/com/copyright/rup/works/brocker/impl/JsonConsumer.java
            LOGGER.info(e.getMessage());
=======
            e.printStackTrace();
>>>>>>> 2f054807a815ed8a61117676e1ffbd0930864d91:broker-prototype/src/main/java/com/copyright/rup/works/broker/impl/JsonConsumer.java
        }
    }
}
