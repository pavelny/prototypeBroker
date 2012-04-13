package com.copyright.rup.works.brocker.impl;

import com.copyright.rup.works.brocker.api.IConsumer;
import com.copyright.rup.works.brocker.api.IMarshaler;
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
            while(chunkWorks != null) {
                chunkWorks = marshaler.toEntities((String) consumer.receiveBodyNoWait(nameOfQueue));
                works.addAll(chunkWorks);
            }
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    }
}
