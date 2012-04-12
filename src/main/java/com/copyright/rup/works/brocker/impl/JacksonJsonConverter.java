package com.copyright.rup.works.brocker.impl;

import java.io.IOException;
import java.util.List;

import com.copyright.rup.works.brocker.api.IConverter;
import com.copyright.rup.works.domain.api.IAffiliation;
import com.copyright.rup.works.domain.api.IAuthor;
import com.copyright.rup.works.domain.api.IEditor;
import com.copyright.rup.works.domain.api.IPublisher;
import com.copyright.rup.works.domain.api.ISubject;
import com.copyright.rup.works.domain.api.ITitle;
import com.copyright.rup.works.domain.api.IWork;
import com.copyright.rup.works.domain.api.IWorkCollection;
import com.copyright.rup.works.domain.api.IWorkLanguage;
import com.copyright.rup.works.domain.impl.Affiliation;
import com.copyright.rup.works.domain.impl.Author;
import com.copyright.rup.works.domain.impl.Editor;
import com.copyright.rup.works.domain.impl.Publisher;
import com.copyright.rup.works.domain.impl.Subject;
import com.copyright.rup.works.domain.impl.Title;
import com.copyright.rup.works.domain.impl.Work;
import com.copyright.rup.works.domain.impl.WorkCollection;
import com.copyright.rup.works.domain.impl.WorkLanguage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * This class implements the {@link IConverter} interface.
 * It uses <a href="http://wiki.fasterxml.com/JacksonHome">Jackson</a> libraries for converting.
 *
 * @author Andrei_Khadziukou
 *
 */
public class JacksonJsonConverter implements IConverter {

    /**
     * {@inheritDoc}
     */
    public String toJson(Object obj) throws IOException {
        ObjectMapper mapper = new  ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    /**
     * {@inheritDoc}
     */
    public <T> T toEntity(String json, Class<T> clazz) throws Exception {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addAbstractTypeMapping(IAuthor.class, Author.class);
        simpleModule.addAbstractTypeMapping(IWorkCollection.class, WorkCollection.class);
        simpleModule.addAbstractTypeMapping(IEditor.class, Editor.class);
        simpleModule.addAbstractTypeMapping(IAffiliation.class, Affiliation.class);
        simpleModule.addAbstractTypeMapping(IWorkLanguage.class, WorkLanguage.class);
        simpleModule.addAbstractTypeMapping(IPublisher.class, Publisher.class);
        simpleModule.addAbstractTypeMapping(ISubject.class, Subject.class);
        simpleModule.addAbstractTypeMapping(ITitle.class, Title.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(simpleModule);
        return mapper.readValue(json, clazz);
    }

    /**
     * {@inheritDoc}
     */
    public List<IWork> toEntities(String json) throws Exception {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addAbstractTypeMapping(IWork.class, Work.class);
        simpleModule.addAbstractTypeMapping(IAuthor.class, Author.class);
        simpleModule.addAbstractTypeMapping(IWorkCollection.class, WorkCollection.class);
        simpleModule.addAbstractTypeMapping(IEditor.class, Editor.class);
        simpleModule.addAbstractTypeMapping(IAffiliation.class, Affiliation.class);
        simpleModule.addAbstractTypeMapping(IWorkLanguage.class, WorkLanguage.class);
        simpleModule.addAbstractTypeMapping(IPublisher.class, Publisher.class);
        simpleModule.addAbstractTypeMapping(ISubject.class, Subject.class);
        simpleModule.addAbstractTypeMapping(ITitle.class, Title.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(simpleModule);

        return mapper.readValue(json, WorkWrapper.class).getWorks();
    }

    //private static final Version VERSION = Version.unknownVersion();
}
