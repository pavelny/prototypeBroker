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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.List;

/**
 * It is a Gson marshaler.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: Apr 17, 2012
 *
 * @author Andrei_Khadziukou
 *
 */
public class GsonMarshaler implements IMarshaler {

    /**
     * {@inheritDoc}
     */
    public List<IWork> toEntities(String json) {

        Gson gson = generateGsonBuilder().create();

        // TODO Problem with deserialisation of list, when it was created by way Arrays.asList()
        return gson.fromJson(json, WorkWrapper.class).getWorks();
    }

    /**
     * {@inheritDoc}
     */
    public <T> T toEntity(String json, Class<T> clazz) {
        Gson gson = generateGsonBuilder().create();

        // TODO Problem with deserialisation of list, when it was created by way Arrays.asList()
        return gson.fromJson(json, clazz);
    }

    /**
     * {@inheritDoc}
     */
    public String toJson(Object obj) {
        Gson gson = new Gson();
        Object object = obj;
        if (obj instanceof List) {
            WorkWrapper wrapper = new WorkWrapper();
            @SuppressWarnings("unchecked")
            List<IWork> list = (List<IWork>) obj;
            wrapper.setWorks(list);
            object = wrapper;
        }
        return gson.toJson(object);
    }

    /**
     * It generates {@link GsonBuilder} for configuration unmarshaling process.
     *
     * @return The builder.
     */
    private GsonBuilder generateGsonBuilder() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(IWork.class, new WorkAdapter())
                .registerTypeAdapter(IAuthor.class, new AuthorAdapter())
                .registerTypeAdapter(IAffiliation.class, new AffiliationAdapter())
                .registerTypeAdapter(IWorkCollection.class, new WorkCollectionAdapter())
                .registerTypeAdapter(IEditor.class, new EditorAdapter())
                .registerTypeAdapter(IWorkLanguage.class, new WorkLanguageAdapter())
                .registerTypeAdapter(IPublisher.class, new PublisherAdapter())
                .registerTypeAdapter(ISubject.class, new SubjectAdapter())
                .registerTypeAdapter(IContributor.class, new ContributorAdapter())
                .registerTypeAdapter(ITitle.class, new TitleAdapter());
        return builder;
    }

    /**
     * It is a adapter for deserialization {@link IAffiliation} object.
     *
     * <p/>
     * Copyright (C) 2012 copyright.com
     * <p/>
     * Date: 04/13/12.
     *
     * @author Andrei_Khadziukou
     *
     */
    private class AffiliationAdapter implements JsonDeserializer<IAffiliation> {

        /**
         * {@inheritDoc}
         */
        public IAffiliation deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, Affiliation.class);
        }

    }

    /**
     * It is a adapter for deserialization {@link IAuthor} object.
     * <p/>
     * Copyright (C) 2012 copyright.com
     * <p/>
     * Date: Apr 17, 2012
     *
     * @author Andrei_Khadziukou
     *
     */
    private class AuthorAdapter implements JsonDeserializer<IAuthor> {

        public IAuthor deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, Author.class);
        }

    }

    /**
     * It is a adapter for deserialization {@link IContributor} object.
     * <p/>
     * Copyright (C) 2012 copyright.com
     * <p/>
     * Date: Apr 17, 2012
     *
     * @author Andrei_Khadziukou
     *
     */
    private class ContributorAdapter implements JsonDeserializer<IContributor> {

        /**
         * {@inheritDoc}
         */
        public IContributor deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, Contributor.class);
        }

    }

    /**
     * It is a adapter for deserialization {@link IEditor} object.
     * <p/>
     * Copyright (C) 2012 copyright.com
     * <p/>
     * Date: Apr 17, 2012
     *
     * @author Andrei_Khadziukou
     *
     */
    private class EditorAdapter implements JsonDeserializer<IEditor> {

        /**
         * {@inheritDoc}
         */
        public IEditor deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, Editor.class);
        }

    }

    /**
     * It is a adapter for deserialization {@link IPublisher} object.
     * <p/>
     * Copyright (C) 2012 copyright.com
     * <p/>
     * Date: Apr 17, 2012
     *
     * @author Andrei_Khadziukou
     *
     */
    private class PublisherAdapter implements JsonDeserializer<IPublisher> {

        /**
         * {@inheritDoc}
         */
        public IPublisher deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, Publisher.class);
        }

    }

    /**
     * It is a adapter for deserialization {@link ISubject} object.
     * <p/>
     * Copyright (C) 2012 copyright.com
     * <p/>
     * Date: Apr 17, 2012
     *
     * @author Andrei_Khadziukou
     *
     */
    private class SubjectAdapter implements JsonDeserializer<ISubject> {

        /**
         * {@inheritDoc}
         */
        public ISubject deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, Subject.class);
        }

    }

    /**
     * It is a adapter for deserialization {@link ITitle} object.
     * <p/>
     * Copyright (C) 2012 copyright.com
     * <p/>
     * Date: Apr 17, 2012
     *
     * @author Andrei_Khadziukou
     *
     */
    private class TitleAdapter implements JsonDeserializer<ITitle> {

        /**
         * {@inheritDoc}
         */
        public ITitle deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, Title.class);
        }

    }

    /**
     * It is a adapter for deserialization {@link IWork} object.
     * <p/>
     * Copyright (C) 2012 copyright.com
     * <p/>
     * Date: Apr 17, 2012
     *
     * @author Andrei_Khadziukou
     *
     */
    private class WorkAdapter implements JsonDeserializer<IWork> {

        /**
         * {@inheritDoc}
         */
        public IWork deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, Work.class);
        }

    }

    /**
     * It is a adapter for deserialization {@link IWorkCollection} object.
     * <p/>
     * Copyright (C) 2012 copyright.com
     * <p/>
     * Date: Apr 17, 2012
     *
     * @author Andrei_Khadziukou
     *
     */
    private class WorkCollectionAdapter implements JsonDeserializer<IWorkCollection> {

        public IWorkCollection deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, WorkCollection.class);
        }

    }

    /**
     * It is a adapter for deserialization {@link IWorkLanguage} object.
     * <p/>
     * Copyright (C) 2012 copyright.com
     * <p/>
     * Date: Apr 17, 2012
     *
     * @author Andrei_Khadziukou
     *
     */
    private class WorkLanguageAdapter implements JsonDeserializer<IWorkLanguage> {

        /**
         * {@inheritDoc}
         */
        public IWorkLanguage deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, WorkLanguage.class);
        }

    }
}
