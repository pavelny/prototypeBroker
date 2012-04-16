package com.copyright.rup.works.broker.impl;

import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IConsumer;
import com.copyright.rup.works.broker.api.IMarshaler;
import com.copyright.rup.works.domain.api.IWork;

import org.apache.camel.ConsumerTemplate;

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

    private ConsumerTemplate consumer;

    /**
     * The constructor.
     *
     * @param consumer
     *            the template consummer.
     */
    public JsonConsumer(ConsumerTemplate consumer) {
        this.consumer = consumer;
    }

    /**
     * {@inheritDoc}
     */
    public void receiveWorks(String nameOfQueue, int expectedSizeOfCollection,
            IMarshaler marshaler) {
        List<IWork> works = new LinkedList<IWork>();
        List<IWork> chunkWorks = new LinkedList<IWork>();

        for (int i = 0; i < UtilVarialble.WORKS_COLLECTION_SIZE / expectedSizeOfCollection; i++) {
            chunkWorks = marshaler.toEntities(consumer.receiveBody(nameOfQueue).toString());
            works.addAll(chunkWorks);
        }
    }
}
