package com.copyright.rup.works.broker.marshaler;

import com.copyright.rup.works.broker.api.IMarshaler;
import com.copyright.rup.works.domain.api.IWork;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.mapped.Configuration;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamReader;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 * It is a marshaler for JAXB.
 *
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 04/11/12.
 *
 * @author Andrei_Khadziukou.
 *
 */
public class JaxbMarshaler implements IMarshaler {

    /**
     * The loger.
     */
    private static final Logger LOGER = Logger.getLogger(JaxbMarshaler.class);

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<IWork> toEntities(String json) {
        try {
            JAXBContext jc = JAXBContext.newInstance(WorkWrapper.class);
            JSONObject obj = new JSONObject(json);
            Configuration config = new Configuration();
            MappedNamespaceConvention con = new MappedNamespaceConvention(config);
            XMLStreamReader xmlStreamReader = new MappedXMLStreamReader(obj, con);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            WorkWrapper wrapper = (WorkWrapper) unmarshaller.unmarshal(xmlStreamReader);
            return wrapper.getWorks();
        } catch (JAXBException | JSONException | XMLStreamException e) {
            LOGER.info("Problem with converting");
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public <T> T toEntity(String json, Class<T> clazz) {
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            JSONObject obj = new JSONObject(json);
            Configuration config = new Configuration();
            MappedNamespaceConvention con = new MappedNamespaceConvention(config);
            XMLStreamReader xmlStreamReader = new MappedXMLStreamReader(obj, con);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            return (T) unmarshaller.unmarshal(xmlStreamReader);
        } catch (JAXBException | JSONException | XMLStreamException e) {
            LOGER.info("Problem with converting");
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public String toJson(Object object) {
        try {

            Object obj = object;

            if (ArrayList.class == obj.getClass()) {
                WorkWrapper wrapper = new WorkWrapper();
                wrapper.setWorks((List<IWork>) obj);
                obj = wrapper;
            }

            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Configuration config = new Configuration();
            MappedNamespaceConvention convention = new MappedNamespaceConvention(config);
            StringWriter writerString = new StringWriter();
            XMLStreamWriter xmlWriter = new MappedXMLStreamWriter(convention, writerString);

            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(obj, xmlWriter);
            return writerString.toString();
        } catch (JAXBException e) {
            LOGER.info("Problem with converting");
        }
        return null;
    }
}
