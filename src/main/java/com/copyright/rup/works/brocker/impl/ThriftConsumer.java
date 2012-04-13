package com.copyright.rup.works.brocker.impl;

import com.copyright.rup.works.brocker.api.IConsumer;
import com.copyright.rup.works.brocker.api.IMarshaler;
import com.copyright.rup.works.brocker.thrift.gen.ThriftWork;
import com.copyright.rup.works.domain.api.IWork;

import org.apache.camel.ConsumerTemplate;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.protocol.TBinaryProtocol;

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
public class ThriftConsumer implements IConsumer {

    private ConsumerTemplate consumer;

    public ThriftConsumer(ConsumerTemplate consumer) {
        this.consumer = consumer;
    }

    public void receiveWorks(String nameOfQueue, int expectedSizeOfCollection, IMarshaler marshaler) {
        LinkedList<IWork> works = new LinkedList<IWork>();

        TDeserializer deserializer = new TDeserializer(new TBinaryProtocol.Factory());
        List<byte[]> bytes = new LinkedList<byte[]>();
        while (bytes != null) {
            try {
                bytes = (List<byte[]>) consumer.receiveBodyNoWait(nameOfQueue);
                for (byte[] byteWork: bytes) {
                    ThriftWork thriftWork = new ThriftWork();
                    deserializer.deserialize(thriftWork, byteWork);
                    works.add(ThriftBuilder.buildTo(thriftWork));
                }
            } catch (Exception e) {
                // /TODO log exception
            }

        }
    }
}
