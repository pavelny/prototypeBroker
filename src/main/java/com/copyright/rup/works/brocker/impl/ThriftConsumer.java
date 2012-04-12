package com.copyright.rup.works.brocker.impl;

import java.util.LinkedList;

import org.apache.camel.ConsumerTemplate;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.protocol.TBinaryProtocol;

import com.copyright.rup.works.brocker.api.IConsumer;
import com.copyright.rup.works.brocker.api.IMarshaler;
import com.copyright.rup.works.brocker.thrift.gen.WorkDto;
import com.copyright.rup.works.domain.api.ISubject;
import com.copyright.rup.works.domain.api.IWork;
import com.copyright.rup.works.domain.api.IWorkLanguage;
import com.copyright.rup.works.domain.impl.Subject;
import com.copyright.rup.works.domain.impl.Work;
import com.copyright.rup.works.domain.impl.WorkLanguage;

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
        for(int i = 0; i < expectedSizeOfCollection; i++) {
            WorkDto thriftWork = new WorkDto();
            try {
                deserializer.deserialize(thriftWork, (byte[]) consumer.receiveBody(nameOfQueue));
            } catch (Exception e) {
                ///TODO log exception
            }
            IWork work = new Work();
            work.setId(thriftWork.getId());
            work.setId(work.getId());
            IWorkLanguage language = new WorkLanguage();
            language.setLanguage(thriftWork.getLanguage());
            work.setLanguage(language);
            work.setPublicationCountry(work.getPublicationCountry());
            work.setPublicationType(work.getPublicationType());
            ISubject subject = new Subject();
            subject.setSubject(thriftWork.getSubject());
            work.setSubject(subject);
            works.add(work);
        }
    }
}
