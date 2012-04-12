package com.copyright.rup.works.brocker.impl;

import java.lang.reflect.Type;
import java.util.List;

import com.copyright.rup.works.brocker.api.IConverter;
import com.copyright.rup.works.domain.api.IAuthor;
import com.copyright.rup.works.domain.api.IContributor;
import com.copyright.rup.works.domain.api.IEditor;
import com.copyright.rup.works.domain.api.IPublisher;
import com.copyright.rup.works.domain.api.ISubject;
import com.copyright.rup.works.domain.api.ITitle;
import com.copyright.rup.works.domain.api.IWork;
import com.copyright.rup.works.domain.api.IWorkCollection;
import com.copyright.rup.works.domain.api.IWorkLanguage;
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
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class GsonConverter implements IConverter {

    /**
     * {@inheritDoc}
     */
    public String toJson(Object obj) throws Exception {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * {@inheritDoc}
     */
    public <T> T toEntity(String json, Class<T> clazz) throws Exception {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(IAuthor.class, new AuthorAdapter())
        .registerTypeAdapter(IWorkCollection.class, new WorkCollectionAdapter())
        .registerTypeAdapter(IEditor.class, new EditorAdapter())
        .registerTypeAdapter(IWorkLanguage.class, new WorkLanguageAdapter())
        .registerTypeAdapter(IPublisher.class, new PublisherAdapter())
        .registerTypeAdapter(ISubject.class, new SubjectAdapter())
        .registerTypeAdapter(ITitle.class, new TitleAdapter());
        Gson gson = builder.create();
        // TODO Problem with deserialisation of list, when it was created by way Arrays.asList()
        return gson.fromJson(json, clazz);
    }

    /**
     * {@inheritDoc}
     */
    public List<IWork> toEntities(String json) throws Exception {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(IWork.class, new WorkAdapter()).registerTypeAdapter(IAuthor.class, new AuthorAdapter())
        .registerTypeAdapter(IWorkCollection.class, new WorkCollectionAdapter())
        .registerTypeAdapter(IEditor.class, new EditorAdapter())
        .registerTypeAdapter(IWorkLanguage.class, new WorkLanguageAdapter())
        .registerTypeAdapter(IPublisher.class, new PublisherAdapter())
        .registerTypeAdapter(ISubject.class, new SubjectAdapter())
        .registerTypeAdapter(ITitle.class, new TitleAdapter());
        Gson gson = builder.create();
        // TODO Problem with deserialisation of list, when it was created by way Arrays.asList()

        return gson.fromJson(json, WorkWrapper.class).getWorks();
    }

    private class WorkAdapter implements JsonDeserializer<IWork> {

        @Override
        public IWork deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            Work work = new Work();

            return work;
        }

    }

    // TODO Add javadoc
    private class AuthorAdapter implements JsonDeserializer<IAuthor> {

        public IAuthor deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            Author author = new Author();

            JsonObject jsonObject = json.getAsJsonObject();

            author.setName(jsonObject.get(NAME).getAsString());
            author.setRole(jsonObject.get(ROLE).getAsString());

            return author;
        }

    }

    // TODO Add javadoc
    private class WorkCollectionAdapter implements JsonDeserializer<IWorkCollection> {

        public IWorkCollection deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            WorkCollection workCollection = new WorkCollection();
            return workCollection;
        }

    }

    // TODO Add javadoc
    private class ContributorAdapter implements JsonDeserializer<IContributor> {


        /**
         * {@inheritDoc}
         */
        public IContributor deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            Contributor contributor = new Contributor();
            return contributor;
        }

    }

    // TODO Add javadoc
    private class EditorAdapter implements JsonDeserializer<IEditor> {

        /**
         * {@inheritDoc}
         */
        public IEditor deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            Editor editor = new Editor();
            return editor;
        }

    }

    // TODO Add javadoc
    private class WorkLanguageAdapter implements JsonDeserializer<IWorkLanguage> {

        /**
         * {@inheritDoc}
         */
        public IWorkLanguage deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            WorkLanguage workLanguage= new WorkLanguage();
            return workLanguage;
        }

    }

    // TODO Add javadoc
    private class PublisherAdapter implements JsonDeserializer<IPublisher> {

        /**
         * {@inheritDoc}
         */
        public IPublisher deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            Publisher publisher = new Publisher();
            return publisher;
        }

    }

    // TODO Add javadoc
    private class SubjectAdapter implements JsonDeserializer<ISubject> {

        /**
         * {@inheritDoc}
         */
        public ISubject deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            Subject subject = new Subject();
            return subject;
        }

    }

    // TODO Add javadoc
    private class TitleAdapter implements JsonDeserializer<ITitle> {

        /**
         * {@inheritDoc}
         */
        public ITitle deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            Title title = new Title();
            return title;
        }

    }

    private static final String NAME = "name";
    private static final String ROLE = "role";
}
