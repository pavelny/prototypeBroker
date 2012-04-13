package com.copyright.rup.works.brocker.impl;

import com.copyright.rup.works.brocker.api.IMarshaler;
import com.copyright.rup.works.brocker.api.IProducer;
import com.copyright.rup.works.brocker.thrift.gen.ThriftWork;
import com.copyright.rup.works.domain.api.IWork;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
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

    private ProducerTemplate producer;

    public ThriftProducer(ProducerTemplate producer) {
        this.producer = producer;
    }

    @Override
    public void sendWorks(String nameOfQueue, List<IWork> works, IMarshaler marshaler) {

        TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
            List<byte[]> results = new LinkedList<byte[]>();
            try {
                for (IWork work : works) {
                    ThriftWork thriftWork = ThriftBuilder.buildFrom(work);
                    byte[] result = serializer.serialize(thriftWork);
                    results.add(result);
                }
                producer.sendBodyAndHeader(nameOfQueue, ExchangePattern.InOnly, results,
                        "work_message", "inJson");
            } catch (TException e) {
                e.printStackTrace();
            }
    }

}
