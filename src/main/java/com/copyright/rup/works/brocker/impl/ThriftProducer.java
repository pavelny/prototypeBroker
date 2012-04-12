package com.copyright.rup.works.brocker.impl;

import java.util.List;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;

import com.copyright.rup.works.brocker.api.IMarshaler;
import com.copyright.rup.works.brocker.api.IProducer;
import com.copyright.rup.works.brocker.thrift.gen.WorkDto;
import com.copyright.rup.works.domain.api.IWork;

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
        for (IWork work: works) {
            WorkDto thriftWork = new WorkDto();
            thriftWork.setId(work.getId());
            thriftWork.setLanguage(work.getLanguage().getLanguage());
            thriftWork.setPublicationCountry(work.getPublicationCountry());
            thriftWork.setPublicationType(work.getPublicationType());
            if (work.getSubject() != null) {
                thriftWork.setSubject(work.getSubject().getSubject());
            }
            try {
                byte[] result = serializer.serialize(thriftWork);
                producer.sendBodyAndHeader(nameOfQueue, ExchangePattern.InOnly, result, "work_message", "inJson");
            } catch (TException e) {
                e.printStackTrace();
            }
        }
    }

}
