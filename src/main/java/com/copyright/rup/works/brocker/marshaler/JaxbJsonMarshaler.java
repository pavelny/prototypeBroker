package com.copyright.rup.works.brocker.marshaler;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLStreamWriter;

import org.codehaus.jettison.mapped.Configuration;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;

import com.copyright.rup.works.brocker.api.IMarshaler;
import com.copyright.rup.works.brocker.impl.WorkWrapper;
import com.copyright.rup.works.domain.api.IWork;

public class JaxbJsonMarshaler implements IMarshaler {

    public String toJson(Object object) throws IOException, JAXBException {
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
    }

    @Override
    public <T> T toEntity(String json, Class<T> clazz) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> List<T> toEntities(String json) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
