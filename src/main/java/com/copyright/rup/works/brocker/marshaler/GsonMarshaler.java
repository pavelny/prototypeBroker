package com.copyright.rup.works.brocker.marshaler;

import com.copyright.rup.works.brocker.api.IMarshaler;
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

public class GsonMarshaler implements IMarshaler {

    /**
     * {@inheritDoc}
     */
    public List<IWork> toEntities(String json) throws Exception {

        Gson gson = generateGsonBuilder().create();

        // TODO Problem with deserialisation of list, when it was created by way Arrays.asList()
        return gson.fromJson(json, WorkWrapper.class).getWorks();
    }

    /**
     * {@inheritDoc}
     */
    public <T> T toEntity(String json, Class<T> clazz) throws Exception {
        Gson gson = generateGsonBuilder().create();

        // TODO Problem with deserialisation of list, when it was created by way Arrays.asList()
        return gson.fromJson(json, clazz);
    }

    /**
     * {@inheritDoc}
     */
    public String toJson(Object obj) throws Exception {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

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

    // TODO Add javadoc
    private class AffiliationAdapter implements JsonDeserializer<IAffiliation> {

        /**
         * {@inheritDoc}
         */
        public IAffiliation deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, Affiliation.class);
        }

    }

    // TODO Add javadoc
    private class AuthorAdapter implements JsonDeserializer<IAuthor> {

        public IAuthor deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, Author.class);
        }

    }

    // TODO Add javadoc
    private class ContributorAdapter implements JsonDeserializer<IContributor> {

        /**
         * {@inheritDoc}
         */
        public IContributor deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, Contributor.class);
        }

    }

    // TODO Add javadoc
    private class EditorAdapter implements JsonDeserializer<IEditor> {

        /**
         * {@inheritDoc}
         */
        public IEditor deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, Editor.class);
        }

    }

    // TODO Add javadoc
    private class PublisherAdapter implements JsonDeserializer<IPublisher> {

        /**
         * {@inheritDoc}
         */
        public IPublisher deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, Publisher.class);
        }

    }

    // TODO Add javadoc
    private class SubjectAdapter implements JsonDeserializer<ISubject> {

        /**
         * {@inheritDoc}
         */
        public ISubject deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, Subject.class);
        }

    }

    // TODO Add javadoc
    private class TitleAdapter implements JsonDeserializer<ITitle> {

        /**
         * {@inheritDoc}
         */
        public ITitle deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            return context.deserialize(json, Title.class);
        }

    }

    // TODO Add javadoc
    private class WorkAdapter implements JsonDeserializer<IWork> {

        /**
         * {@inheritDoc}
         */
        public IWork deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            return context.deserialize(json, Work.class);
        }

    }

    // TODO Add javadoc
    private class WorkCollectionAdapter implements JsonDeserializer<IWorkCollection> {

        public IWorkCollection deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return context.deserialize(json, WorkCollection.class);
        }

    }

    // TODO Add javadoc
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
