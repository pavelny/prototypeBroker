package com.copyright.rup.works.broker.marshaler;

import com.copyright.rup.works.broker.api.IMarshaler;
import com.copyright.rup.works.domain.api.IAffiliation;
import com.copyright.rup.works.domain.api.IAuthor;
import com.copyright.rup.works.domain.api.IContributor;
import com.copyright.rup.works.domain.api.IEditor;
import com.copyright.rup.works.domain.api.IPublisher;
import com.copyright.rup.works.domain.api.ISubject;
import com.copyright.rup.works.domain.api.ITitle;
import com.copyright.rup.works.domain.api.IWork;
import com.copyright.rup.works.domain.api.IWorkCollection;
import com.copyright.rup.works.domain.api.IWorkLanguage;
import com.copyright.rup.works.domain.impl.Affiliation;
import com.copyright.rup.works.domain.impl.Author;
import com.copyright.rup.works.domain.impl.Contributor;
import com.copyright.rup.works.domain.impl.Editor;
import com.copyright.rup.works.domain.impl.Publisher;
import com.copyright.rup.works.domain.impl.Subject;
import com.copyright.rup.works.domain.impl.Title;
import com.copyright.rup.works.domain.impl.Work;
import com.copyright.rup.works.domain.impl.WorkCollection;
import com.copyright.rup.works.domain.impl.WorkLanguage;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.util.List;

/**
 * This class implements the {@link IMarshaler} interface. It uses
 * <a href="http://wiki.fasterxml.com/JacksonHome"> Jackson</a> libraries for converting.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 04/13/12.
 *
 * @author Andrei_Khadziukou
 */
public class JacksonMarshaler implements IMarshaler {

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<IWork> toEntities(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(generateModule());

            return mapper.readValue(json, WorkWrapper.class).getWorks();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public <T> T toEntity(String json, Class<T> clazz) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(generateModule());
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public String toJson(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        Object object = obj;
        if (obj instanceof List) {
            WorkWrapper wrapper = new WorkWrapper();
            @SuppressWarnings("unchecked")
            List<IWork> list = (List<IWork>) obj;
            wrapper.setWorks(list);
            object = wrapper;
        }
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * It generates module to help converting JSON to POJO.
     *
     * @return The {@link Module}.
     */
    private Module generateModule() {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addAbstractTypeMapping(IWork.class, Work.class);
        simpleModule.addAbstractTypeMapping(IAuthor.class, Author.class);
        simpleModule.addAbstractTypeMapping(IWorkCollection.class, WorkCollection.class);
        simpleModule.addAbstractTypeMapping(IEditor.class, Editor.class);
        simpleModule.addAbstractTypeMapping(IAffiliation.class, Affiliation.class);
        simpleModule.addAbstractTypeMapping(IWorkLanguage.class, WorkLanguage.class);
        simpleModule.addAbstractTypeMapping(IPublisher.class, Publisher.class);
        simpleModule.addAbstractTypeMapping(IContributor.class, Contributor.class);
        simpleModule.addAbstractTypeMapping(ISubject.class, Subject.class);
        simpleModule.addAbstractTypeMapping(ITitle.class, Title.class);

        return simpleModule;
    }

}
