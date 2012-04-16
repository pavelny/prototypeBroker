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
public class JsonProducer implements IProducer {

    /**
     * The template producer.
     */
    private ProducerTemplate producer;

    /**
     * The constructor.
     *
     * @param producer
     *            the template prosucer
     */
    public JsonProducer(ProducerTemplate producer) {
        this.producer = producer;
    }

    /**
     * {@inheritDoc}
     */
    public void sendWorks(String nameOfQueue, List<IWork> works, IMarshaler marshaler) {
        String jsonWork = marshaler.toJson(works);
        producer.sendBodyAndHeader(nameOfQueue, ExchangePattern.InOnly, jsonWork,
                UtilVarialble.MESSAGE_HEADER, UtilVarialble.MESSAGE_VARIABLE);
    }

}
