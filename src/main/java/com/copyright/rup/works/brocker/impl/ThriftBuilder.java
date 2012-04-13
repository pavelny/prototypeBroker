package com.copyright.rup.works.brocker.impl;

import com.copyright.rup.works.brocker.thrift.gen.ThriftAuthor;
import com.copyright.rup.works.brocker.thrift.gen.ThriftWork;
import com.copyright.rup.works.brocker.thrift.gen.ThriftWorkCollection;
import com.copyright.rup.works.brocker.thrift.gen.ThriftWorkLanguage;
import com.copyright.rup.works.domain.api.IAuthor;
import com.copyright.rup.works.domain.api.IWork;
import com.copyright.rup.works.domain.api.IWorkLanguage;
import com.copyright.rup.works.domain.impl.Author;
import com.copyright.rup.works.domain.impl.Work;
import com.copyright.rup.works.domain.impl.WorkCollection;
import com.copyright.rup.works.domain.impl.WorkLanguage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * The builder for ThriftWork class.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/13/12
 *
 * @author Pavel_Yakovlev
 */
public class ThriftBuilder {

    public ThriftWork buildFrom(IWork work) {

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

        ThriftWorkLanguage thriftWorkLanguage = new ThriftWorkLanguage();
        thriftWorkLanguage.setLanguage(work.getLanguage().getLanguage());
        thriftWorkLanguage.setLanguageRole(work.getLanguage().getLanguageRole());
        thriftWork.setWorkLanguage(thriftWorkLanguage);

        return thriftWork;
    }

    public IWork buildTo(ThriftWork thriftWork) {

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
        try {
            workCollection.setSubmittedDatetime((new SimpleDateFormat()).parse(thriftWork
                    .getCollection().getSubmittedDatetime()));
            workCollection.setSubmitProcessedDatetime((new SimpleDateFormat()).parse(thriftWork
                    .getCollection().getSubmittedProcessedDatetime().toString()));
        } catch (ParseException e) {
            // /TODO log exception here
        }
        workCollection.setCreateByFileSubmittedPath(thriftWork.getCollection()
                .getCreateByFileSubmittedPath());
        workCollection.setCreateByFileOSFilePath((thriftWork.getCollection()
                .getCreateByfileOsFilePath()));
        workCollection.setImportFileType(thriftWork.getCollection().getImportFileType());
        workCollection.setImportFileContentType(thriftWork.getCollection()
                .getImportFileContentType());
        work.setCollection(workCollection);

        IWorkLanguage workLanguage = new WorkLanguage();
        workLanguage.setLanguage(thriftWork.getWorkLanguage().getLanguage());
        workLanguage.setLanguageRole(thriftWork.getWorkLanguage().getLanguageRole());
        work.setLanguage(workLanguage);

        return work;
    }
}
