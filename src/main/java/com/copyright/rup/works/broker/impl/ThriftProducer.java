package com.copyright.rup.works.broker.impl;

import com.copyright.rup.works.broker.api.IMarshaler;
import com.copyright.rup.works.broker.api.IProducer;
import com.copyright.rup.works.broker.thrift.gen.ThriftWork;
import com.copyright.rup.works.domain.api.IWork;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;

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
        for (IWork work : works) {
            ThriftWork thriftWork = new ThriftBuilder().buildFrom(work);
            try {
                byte[] result = serializer.serialize(thriftWork);
                producer.sendBodyAndHeader(nameOfQueue, ExchangePattern.InOnly, result,
                        "work_message", "inJson");
            } catch (TException e) {
                e.printStackTrace();
            }
        }
    }

}
