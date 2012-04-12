package com.copyright.rup.works.brocker.impl;

import java.util.List;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

import com.copyright.rup.works.brocker.api.IMarshaler;
import com.copyright.rup.works.brocker.api.IProducer;
import com.copyright.rup.works.domain.api.IWork;

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

    ProducerTemplate producer;

    public JsonProducer(ProducerTemplate producer) {
        this.producer = producer;
    }

    @Override
    public void sendWorks(String nameOfQueue, List<IWork> works, IMarshaler marshaler) {
        for (IWork work: works) {
            try {
                String jsonWork = marshaler.toJson(work);
                producer.sendBodyAndHeader(nameOfQueue, ExchangePattern.InOnly, jsonWork,
                        "work_message", "inJson");
            } catch(Exception e) {
                System.out.println("Exception e: " + e.getMessage());
            }
        }
    }

}
