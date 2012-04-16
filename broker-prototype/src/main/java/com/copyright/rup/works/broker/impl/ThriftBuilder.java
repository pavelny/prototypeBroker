package com.copyright.rup.works.broker.impl;

import com.copyright.rup.works.broker.thrift.gen.ThriftAffiliation;
import com.copyright.rup.works.broker.thrift.gen.ThriftAuthor;
import com.copyright.rup.works.broker.thrift.gen.ThriftPerson;
import com.copyright.rup.works.broker.thrift.gen.ThriftPublisher;
import com.copyright.rup.works.broker.thrift.gen.ThriftSubject;
import com.copyright.rup.works.broker.thrift.gen.ThriftTitle;
import com.copyright.rup.works.broker.thrift.gen.ThriftWork;
import com.copyright.rup.works.broker.thrift.gen.ThriftWorkCollection;
import com.copyright.rup.works.broker.thrift.gen.ThriftWorkLanguage;
import com.copyright.rup.works.domain.api.IAffiliation;
import com.copyright.rup.works.domain.api.IAuthor;
import com.copyright.rup.works.domain.api.IContributor;
import com.copyright.rup.works.domain.api.IEditor;
import com.copyright.rup.works.domain.api.IPublisher;
import com.copyright.rup.works.domain.api.ISubject;
import com.copyright.rup.works.domain.api.ITitle;
import com.copyright.rup.works.domain.api.IWork;
import com.copyright.rup.works.domain.api.IWorkLanguage;
import com.copyright.rup.works.domain.impl.Affiliation;
import com.copyright.rup.works.domain.impl.Author;
import com.copyright.rup.works.domain.impl.BasePerson;
import com.copyright.rup.works.domain.impl.Contributor;
import com.copyright.rup.works.domain.impl.Editor;
import com.copyright.rup.works.domain.impl.Publisher;
import com.copyright.rup.works.domain.impl.Subject;
import com.copyright.rup.works.domain.impl.Title;
import com.copyright.rup.works.domain.impl.Work;
import com.copyright.rup.works.domain.impl.WorkCollection;
import com.copyright.rup.works.domain.impl.WorkLanguage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * The builder for ThriftWork structure.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/13/12
 *
 * @author Pavel_Yakovlev
 */
public class ThriftBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThriftBuilder.class);

    static public ThriftWork buildFrom(IWork work) {

        ThriftWork thriftWork = new ThriftWork();
        thriftWork.setId(work.getId());
        List<ThriftAuthor> thriftAuthors = new LinkedList<ThriftAuthor>();
        for (IAuthor author : work.getAuthors()) {
            ThriftAuthor thriftAuthor = new ThriftAuthor();
            thriftAuthor.setBirthYear(author.getBirthYear());
            thriftAuthor.setDeathYear(author.getDeathYear());
            thriftAuthors.add(thriftAuthor);
        }
        thriftWork.setAuthors(thriftAuthors);

        ThriftWorkCollection thriftWorkCollection = new ThriftWorkCollection();
        thriftWorkCollection.setCollectionName(work.getCollection().getCollectionName());
        thriftWorkCollection.setCollectionType(work.getCollection().getCollectionType());
        thriftWorkCollection.setDataProvider(work.getCollection().getDataProvider());
        thriftWorkCollection.setSubmittedByUser(work.getCollection().getSubmittedByUser());
        thriftWorkCollection.setSubmittedDatetime(work.getCollection().getSubmittedDatetime()
                .toString());
        thriftWorkCollection.setSubmittedProcessedDatetime(work.getCollection()
                .getSubmitProcessedDatetime().toString());
        thriftWorkCollection.setCreateByFileSubmittedPath(work.getCollection()
                .getCreateByFileSubmittedPath());
        thriftWorkCollection.setCreateByfileOsFilePath(work.getCollection()
                .getCreateByFileOSFilePath());
        thriftWorkCollection.setImportFileType(work.getCollection().getImportFileType());
        thriftWorkCollection.setImportFileContentType(work.getCollection()
                .getImportFileContentType());
        thriftWork.setCollection(thriftWorkCollection);

        List<ThriftPerson> contributors = new LinkedList<ThriftPerson>();
        for (IContributor contributor: work.getContributors()) {
            ThriftPerson thriftPerson = new ThriftPerson();
            thriftPerson.setName(contributor.getName());
            thriftPerson.setRole(contributor.getRole());
            ThriftAffiliation thriftAffiliation = new ThriftAffiliation();
            thriftAffiliation.setAddress(contributor.getAffiliation().getAddress());
            thriftAffiliation.setCountry(contributor.getAffiliation().getCountry());
            thriftPerson.setAffiliation(thriftAffiliation);
            contributors.add(thriftPerson);
        }
        thriftWork.setContributors(contributors);

        List<ThriftPerson> editors = new LinkedList<ThriftPerson>();
        for (IEditor editor: work.getEditors()) {
            ThriftPerson thriftPerson = new ThriftPerson();
            thriftPerson.setName(editor.getName());
            thriftPerson.setRole(editor.getRole());
            ThriftAffiliation thriftAffiliation = new ThriftAffiliation();
            thriftAffiliation.setAddress(editor.getAffiliation().getAddress());
            thriftAffiliation.setCountry(editor.getAffiliation().getCountry());
            thriftPerson.setAffiliation(thriftAffiliation);
            editors.add(thriftPerson);
        }
        thriftWork.setEditors(editors);

        ThriftWorkLanguage thriftWorkLanguage = new ThriftWorkLanguage();
        thriftWorkLanguage.setLanguage(work.getLanguage().getLanguage());
        thriftWorkLanguage.setLanguageRole(work.getLanguage().getLanguageRole());
        thriftWork.setWorkLanguage(thriftWorkLanguage);
        thriftWork.setPublicationType(work.getPublicationType());
        thriftWork.setPuclicationCountry(work.getPublicationCountry());

        ThriftPublisher thriftPublisher = new ThriftPublisher();
        thriftPublisher.setName(work.getPublisher().getName());
        thriftPublisher.setPublicationPlace(work.getPublisher().getPublicationPlace());
        thriftPublisher.setRole(work.getPublisher().getRole());
        thriftPublisher.setStatus(work.getPublisher().getStatus());
        thriftPublisher.setSortOrder(work.getPublisher().getSortOrder());
        thriftWork.setPublisher(thriftPublisher);

        ThriftSubject thriftSubject = new ThriftSubject();
        thriftSubject.setSubject(work.getSubject().getSubject());
        thriftSubject.setSubjectType(work.getSubject().getSubjectType());
        thriftWork.setSubject(thriftSubject);

        List<ThriftTitle> thriftTitles = new LinkedList<ThriftTitle>();
        for (ITitle title: work.getTitles()) {
            ThriftTitle thriftTitle = new ThriftTitle();
            thriftTitle.setTitle(title.getTitle());
            thriftTitle.setEdition(title.getEdition());
            thriftTitle.setType(title.getType());
            thriftTitle.setVolume(title.getVolume());
            thriftTitles.add(thriftTitle);
        }
        thriftWork.setTitles(thriftTitles);

        thriftWork.setAudience(work.getAudience());

        return thriftWork;
    }

    static public IWork buildTo(ThriftWork thriftWork) {

        IWork work = new Work();
        work.setId(thriftWork.getId());
        List<IAuthor> authors = new LinkedList<IAuthor>();
        for (ThriftAuthor thriftAuthor : thriftWork.getAuthors()) {
            IAuthor author = new Author();
            author.setBirthYear(thriftAuthor.getBirthYear());
            author.setDeathYear(thriftAuthor.getDeathYear());
            authors.add(author);
        }
        work.setAuthors(authors);

        WorkCollection workCollection = new WorkCollection();
        workCollection.setCollectionName(thriftWork.getCollection().getCollectionName());
        workCollection.setCollectionType(thriftWork.getCollection().getCollectionType());
        workCollection.setDataProvider(thriftWork.getCollection().getDataProvider());
        workCollection.setSubmittedByUser(thriftWork.getCollection().getSubmittedByUser());
//        try {
//            workCollection.setSubmittedDatetime((new SimpleDateFormat()).parse(thriftWork
//                    .getCollection().getSubmittedDatetime()));
//            workCollection.setSubmitProcessedDatetime((new SimpleDateFormat()).parse(thriftWork
//                    .getCollection().getSubmittedProcessedDatetime().toString()));
//        } catch (ParseException e) {
//            LOGGER.info("Parse exception in ThriftBuilder class: " + e.getMessage());
//        }
        workCollection.setCreateByFileSubmittedPath(thriftWork.getCollection()
                .getCreateByFileSubmittedPath());
        workCollection.setCreateByFileOSFilePath((thriftWork.getCollection()
                .getCreateByfileOsFilePath()));
        workCollection.setImportFileType(thriftWork.getCollection().getImportFileType());
        workCollection.setImportFileContentType(thriftWork.getCollection()
                .getImportFileContentType());
        work.setCollection(workCollection);

        List<IContributor> contributors = new LinkedList<IContributor>();
        for (ThriftPerson thriftContributor: thriftWork.getContributors()) {
            IContributor contributor = new Contributor();
            contributor.setName(thriftContributor.getName());
            contributor.setRole(thriftContributor.getRole());
            IAffiliation affiliation = new Affiliation();
            affiliation.setAddress(thriftContributor.getAffiliation().getAddress());
            affiliation.setCountry(thriftContributor.getAffiliation().getCountry());
            contributor.setAffiliation(affiliation);
            contributors.add(contributor);
        }
        work.setContributors(contributors);

        List<IEditor> editors = new LinkedList<IEditor>();
        for (ThriftPerson thriftEditor: thriftWork.getEditors()) {
            IEditor editor = new Editor();
            editor.setName(thriftEditor.getName());
            editor.setRole(thriftEditor.getRole());
            IAffiliation affiliation = new Affiliation();
            affiliation.setAddress(thriftEditor.getAffiliation().getAddress());
            affiliation.setCountry(thriftEditor.getAffiliation().getCountry());
            editor.setAffiliation(affiliation);
            editors.add(editor);
        }
        work.setEditors(editors);


        IWorkLanguage workLanguage = new WorkLanguage();
        workLanguage.setLanguage(thriftWork.getWorkLanguage().getLanguage());
        workLanguage.setLanguageRole(thriftWork.getWorkLanguage().getLanguageRole());
        work.setLanguage(workLanguage);

        work.setPublicationType(thriftWork.getPublicationType());
        work.setPublicationCountry(thriftWork.getPuclicationCountry());

        IPublisher publisher = new Publisher();
        publisher.setName(thriftWork.getPublisher().getName());
        publisher.setPublicationPlace(thriftWork.getPublisher().getPublicationPlace());
        publisher.setRole(thriftWork.getPublisher().getRole());
        publisher.setStatus(thriftWork.getPublisher().getStatus());
        publisher.setSortOrder(thriftWork.getPublisher().getSortOrder());
        work.setPublisher(publisher);

        ISubject subject = new Subject();
        subject.setSubject(thriftWork.getSubject().getSubject());
        subject.setSubjectType(thriftWork.getSubject().getSubjectType());
        work.setSubject(subject);

        List<ITitle> titles = new LinkedList<ITitle>();
        for (ThriftTitle thriftTitle: thriftWork.getTitles()) {
            ITitle title = new Title();
            title.setTitle(thriftTitle.getTitle());
            title.setEdition(thriftTitle.getEdition());
            title.setType(thriftTitle.getType());
            title.setVolume(thriftTitle.getVolume());
            titles.add(title);
        }
        work.setTitles(titles);

        work.setAudience(thriftWork.getAudience());
        return work;
    }
}
