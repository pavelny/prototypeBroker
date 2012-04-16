package com.copyright.rup.works.broker.impl;

import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IConsumer;
import com.copyright.rup.works.broker.api.IMarshaler;
import com.copyright.rup.works.broker.thrift.gen.ThriftWork;
import com.copyright.rup.works.domain.api.IWork;

import org.apache.camel.ConsumerTemplate;
import org.apache.log4j.Logger;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.protocol.TBinaryProtocol;

import java.util.LinkedList;
import java.util.List;

/**
 * Thrift implementation of consumer.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/11/12
 *
 * @author Pavel_Yakovlev
 */
public class ThriftConsumer implements IConsumer {

    /**
     * The logger.
     */
    private static final Logger LOGGER = Logger.getLogger(ThriftConsumer.class);

    private ConsumerTemplate consumer;

    /**
     * The constructor.
     *
     * @param consumer
     *            the template consumer.
     */
    public ThriftConsumer(ConsumerTemplate consumer) {
        this.consumer = consumer;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public void receiveWorks(String nameOfQueue, int expectedSizeOfCollection,
            IMarshaler marshaler) {
        LinkedList<IWork> works = new LinkedList<IWork>();

        TDeserializer deserializer = new TDeserializer(
                new TBinaryProtocol.Factory());
        List<byte[]> bytes = new LinkedList<byte[]>();
        for (int i = 0; i <= UtilVarialble.WORKS_COLLECTION_SIZE
                /expectedSizeOfCollection - 1; i++) {
            try {
                bytes = (List<byte[]>) consumer.receiveBody(nameOfQueue);
                for (byte[] byteWork: bytes) {
                    ThriftWork thriftWork = new ThriftWork();
                    deserializer.deserialize(thriftWork, byteWork);
                    works.add(ThriftConverter.convertTo(thriftWork));
                }
            } catch (Exception e) {
                LOGGER.info("During deserialization thrift message error " +
                        "has occured: " + e.getMessage());
            }

        }
    }
}
