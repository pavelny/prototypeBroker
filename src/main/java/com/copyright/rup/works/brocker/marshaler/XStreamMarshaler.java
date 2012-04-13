package com.copyright.rup.works.brocker.marshaler;

import java.io.IOException;
import java.util.List;

import com.copyright.rup.works.brocker.api.IMarshaler;
import com.copyright.rup.works.domain.api.IWork;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

/**
 * @author Andrei_Khadziukou
 *
 */
public class XStreamMarshaler implements IMarshaler {

    /**
     * {@inheritDoc}
     */
    public String toJson(Object obj) throws IOException {
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
        Object object = obj;
        if (obj instanceof List) {
            WorkWrapper workWrapper = new WorkWrapper();
            workWrapper.setWorks((List<IWork>) obj);
            object = workWrapper;
        }
        /*
        (new JsonHierarchicalStreamDriver() {

            /**
             * {@inheritDoc}
             /
            @Override
            public HierarchicalStreamWriter createWriter(Writer writer) {
                return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
            }

        });
        */
        // TODO Check which mode is needed
        xStream.setMode(XStream.NO_REFERENCES);
        // TODO Check how it works
        xStream.alias(object.getClass().getName().toLowerCase(), object.getClass());
        return xStream.toXML(object);
    }

    /**
     * {@inheritDoc}
     */
    public <T> T toEntity(String json, Class<T> clazz) throws Exception {
        XStream xStream = new XStream(new JettisonMappedXmlDriver());

        xStream.alias(clazz.getName().toLowerCase(), clazz);
        @SuppressWarnings("unchecked")
        T result = (T) xStream.fromXML(json);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public <T> List<T> toEntities(String json) throws Exception {
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
        xStream.alias(WorkWrapper.class.getName().toLowerCase(), WorkWrapper.class);
        @SuppressWarnings("unchecked")
        WorkWrapper result = (WorkWrapper) xStream.fromXML(json);
        return (List<T>) result.getWorks();  //To change body of implemented methods use File | Settings | File Templates.
    }
}