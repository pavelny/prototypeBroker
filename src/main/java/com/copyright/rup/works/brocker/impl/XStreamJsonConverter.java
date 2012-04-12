package com.copyright.rup.works.brocker.impl;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.copyright.rup.works.brocker.api.IConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

public class XStreamJsonConverter implements IConverter {

    /**
     * {@inheritDoc}
     */
    public String toJson(Object obj) throws IOException {
        XStream xStream = new XStream(new JsonHierarchicalStreamDriver() {

            /**
             * {@inheritDoc}
             */
            @Override
            public HierarchicalStreamWriter createWriter(Writer writer) {
                return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
            }

        });
        // TODO Check which mode is needed
        xStream.setMode(XStream.NO_REFERENCES);
        // TODO Check how it works
        xStream.alias(obj.getClass().getName().toLowerCase(), obj.getClass());
        return xStream.toXML(obj);
    }

    @Override
    public <T> T toEntity(String json, Class<T> clazz) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> List<T> toEntities(String json) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
