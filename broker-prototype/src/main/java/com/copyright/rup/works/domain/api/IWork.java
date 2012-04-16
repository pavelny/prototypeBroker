package com.copyright.rup.works.domain.api;

import java.io.Serializable;
import java.util.List;

/**
 * Represents unified Works document structure.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/28/12
 *
 * @author Nikita Levyankov
 */
public interface IWork extends Serializable {
    //TODO javadoc
    String getId();

    void setId(String id);

    List<IAuthor> getAuthors();

    void setAuthors(List<IAuthor> authors);

    IWorkCollection getCollection();

    void setCollection(IWorkCollection workCollection);

    List<IContributor> getContributors();

    void setContributors(List<IContributor> contributors);

    List<IEditor> getEditors();

    void setEditors(List<IEditor> editors);

    IWorkLanguage getLanguage();

    void setLanguage(IWorkLanguage language);

    String getPublicationType();

    void setPublicationType(String publicationType);

    String getPublicationCountry();

    void setPublicationCountry(String publicationCountry);

    IPublisher getPublisher();

    void setPublisher(IPublisher publisher);

    ISubject getSubject();

    void setSubject(ISubject subject);

    List<ITitle> getTitles();

    void setTitles(List<ITitle> titles);

    List<String> getAudience();

    void setAudience(List<String> audience);

    String getWorkItem(String key);

    void addWorkItem(String key, String value);
}
