package com.copyright.rup.works.brocker.impl;

import com.copyright.rup.works.brocker.api.IConsumer;
import com.copyright.rup.works.brocker.api.IMarshaler;
import com.copyright.rup.works.brocker.thrift.gen.ThriftWork;
import com.copyright.rup.works.domain.api.IWork;

import org.apache.camel.ConsumerTemplate;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

/**
 * Json implementation of consumer.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/11/12
 *
 * @author Pavel_Yakovlev
 */
public class ThriftConsumer implements IConsumer {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ThriftConsumer.class);

    private ConsumerTemplate consumer;

    public ThriftConsumer(ConsumerTemplate consumer) {
        this.consumer = consumer;
    }

    public void receiveWorks(String nameOfQueue, int expectedSizeOfCollection, IMarshaler marshaler) {
        LinkedList<IWork> works = new LinkedList<IWork>();

        TDeserializer deserializer = new TDeserializer(new TBinaryProtocol.Factory());
        for (int i = 0; i < expectedSizeOfCollection; i++) {
            ThriftWork thriftWork = new ThriftWork();
            try {
                deserializer.deserialize(thriftWork, (byte[]) consumer.receiveBody(nameOfQueue));
                IWork work = new ThriftBuilder().buildTo(thriftWork);
                works.add(work);
            } catch (Exception e) {
                LOGGER.info(e.getMessage());
            }

        }
    }
}
