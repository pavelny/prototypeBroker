package com.copyright.rup.works.broker.impl;

import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IMarshaler;
import com.copyright.rup.works.broker.api.IProducer;
import com.copyright.rup.works.domain.api.IWork;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

import java.util.List;

/**
 * Json implementation of producer.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/11/12
 *
 * @author Pavel_Yakovlev
 */
// TODO Add javadoc to field
public class JsonProducer implements IProducer {

    /**
     *
     */
    ProducerTemplate producer;

    /**
     * @param producer
     */
    public JsonProducer(ProducerTemplate producer) {
        this.producer = producer;
    }

    /**
     * {@inheritDoc}
     */
    public void sendWorks(String nameOfQueue, List<IWork> works, IMarshaler marshaler) {

        // for (IWork work: works) {
        try {
            String jsonWork = marshaler.toJson(works);
            producer.sendBodyAndHeader(nameOfQueue, ExchangePattern.InOnly, jsonWork,
                    UtilVarialble.MESSAGE_HEADER, UtilVarialble.MESSAGE_VARIABLE);
        } catch (Exception e) {
            // TODO Add logging
            e.printStackTrace();
        }
        // }
    }

}
