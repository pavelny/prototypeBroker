package com.copyright.rup.works.broker.impl;

import com.copyright.rup.works.broker.api.IMarshaler;
import com.copyright.rup.works.broker.api.IProducer;
import com.copyright.rup.works.broker.thrift.gen.ThriftWork;
import com.copyright.rup.works.domain.api.IWork;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.log4j.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;

import java.util.LinkedList;
import java.util.List;

/**
 * Thrift implementation of producer.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/11/12
 *
 * @author Pavel_Yakovlev
 */
public class ThriftProducer implements IProducer {

    /**
     * The logger.
     */
    private static final Logger LOGGER = Logger.getLogger(ThriftProducer.class);

    private ProducerTemplate producer;

    /**
     * The constructor.
     *
     * @param producer
     *            the template producer.
     */
    public ThriftProducer(ProducerTemplate producer) {
        this.producer = producer;
    }

    /**
     * {@inheritDoc}
     */
    public void sendWorks(String nameOfQueue, List<IWork> works, IMarshaler marshaler) {

        TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
        List<byte[]> results = new LinkedList<byte[]>();
        try {
            for (IWork work : works) {
                ThriftWork thriftWork = ThriftConverter.convertFrom(work);
                byte[] result = serializer.serialize(thriftWork);
                results.add(result);
            }
            producer.sendBodyAndHeader(nameOfQueue, ExchangePattern.InOnly, results,
                    "work_message", "inJson");
        } catch (TException e) {
            LOGGER.info("During serialization thrift structure error" +
                    " has occured: " + e.getMessage());
        }
    }

}
