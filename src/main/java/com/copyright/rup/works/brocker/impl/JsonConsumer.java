package com.copyright.rup.works.brocker.impl;

import com.copyright.rup.works.brocker.api.IConsumer;
import com.copyright.rup.works.brocker.api.IMarshaler;
import com.copyright.rup.works.domain.api.IWork;

import org.apache.camel.ConsumerTemplate;

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

    public JsonConsumer(ConsumerTemplate consumer) {
        this.consumer = consumer;
    }

    /**
     * {@inheritDoc}
     */
    public void receiveWorks(String nameOfQueue, int expectedSizeOfCollection, IMarshaler marshaler) {
        List<IWork> works = null;

        // for(int i = 0; i < expectedSizeOfCollection; i++) {
        try {
            works = marshaler.toEntities((String) consumer.receiveBody(nameOfQueue));
            // IWork work = marshaler.toEntity((String) consumer.receiveBody(nameOfQueue),
            // IWork.class);
            // works.add(work);
        } catch (Exception e) {
            // TODO log exception
        }
        // }

        // works.size();
    }
}
