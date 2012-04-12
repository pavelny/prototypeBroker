package com.copyright.rup.works.domain.impl;

import com.copyright.rup.works.domain.api.IAuthor;
import com.copyright.rup.works.domain.api.IContributor;
import com.copyright.rup.works.domain.api.IEditor;
import com.copyright.rup.works.domain.api.IPublisher;
import com.copyright.rup.works.domain.api.ISubject;
import com.copyright.rup.works.domain.api.ITitle;
import com.copyright.rup.works.domain.api.IWork;
import com.copyright.rup.works.domain.api.IWorkCollection;
import com.copyright.rup.works.domain.api.IWorkLanguage;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of IWork interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/29/12
 *
 * @author Nikita Levyankov
 */
public class Work implements IWork {
    private String id;
    private List<IAuthor> authors;
    private IWorkCollection workCollection;
    private List<IContributor> contributors;
    private List<IEditor> editors;
    private IWorkLanguage language;
    private String publicationType;
    private String publicationCountry;
    private IPublisher publisher;
    private ISubject subject;
    private List<ITitle> titles;
    private List<String> audience;
    private Map<String, String> workItems;

    /**
     * Default constructor.
     */
    public Work() {
        workItems = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    public String getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * {@inheritDoc}
     */
    public List<IAuthor> getAuthors() {
        return authors;
    }

    /**
     * {@inheritDoc}
     */
    public void setAuthors(List<IAuthor> authors) {
        this.authors = authors;
    }

    /**
     * {@inheritDoc}
     */
    public List<IContributor> getContributors() {
        return contributors;
    }

    /**
     * {@inheritDoc}
     */
    public void setContributors(List<IContributor> contributors) {
        this.contributors = contributors;
    }

    /**
     * {@inheritDoc}
     */
    public List<IEditor> getEditors() {
        return editors;
    }

    /**
     * {@inheritDoc}
     */
    public void setEditors(List<IEditor> editors) {
        this.editors = editors;
    }

    /**
     * {@inheritDoc}
     */
    public IWorkCollection getCollection() {
        return workCollection;
    }

    /**
     * {@inheritDoc}
     */
    public void setCollection(IWorkCollection workCollection) {
        this.workCollection = workCollection;
    }

    /**
     * {@inheritDoc}
     */
    public IWorkLanguage getLanguage() {
        return language;
    }

    /**
     * {@inheritDoc}
     */
    public void setLanguage(IWorkLanguage language) {
        this.language = language;
    }

    /**
     * {@inheritDoc}
     */
    public IPublisher getPublisher() {
        return publisher;
    }

    /**
     * {@inheritDoc}
     */
    public void setPublisher(IPublisher publisher) {
        this.publisher = publisher;
    }

    /**
     * {@inheritDoc}
     */
    public List<ITitle> getTitles() {
        return titles;
    }

    /**
     * {@inheritDoc}
     */
    public void setTitles(List<ITitle> title) {
        this.titles = title;
    }

    /**
     * {@inheritDoc}
     */
    public ISubject getSubject() {
        return subject;
    }

    /**
     * {@inheritDoc}
     */
    public void setSubject(ISubject subject) {
        this.subject = subject;
    }

    /**
     * {@inheritDoc}
     */
    public List<String> getAudience() {
        return audience;
    }

    /**
     * {@inheritDoc}
     */
    public void setAudience(List<String> audience) {
        this.audience = audience;
    }

    /**
     * {@inheritDoc}
     */
    public String getPublicationType() {
        return publicationType;
    }

    /**
     * {@inheritDoc}
     */
    public void setPublicationType(String publicationType) {
        this.publicationType = publicationType;
    }

    /**
     * {@inheritDoc}
     */
    public String getPublicationCountry() {
        return publicationCountry;
    }

    /**
     * {@inheritDoc}
     */
    public void setPublicationCountry(String publicationCountry) {
        this.publicationCountry = publicationCountry;
    }

    /**
     * {@inheritDoc}
     */
    public String getWorkItem(String key) {
        return workItems.get(key);
    }

    /**
     * {@inheritDoc}
     */
    public void addWorkItem(String key, String value) {
        workItems.put(key, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Work)) {
            return false;
        }

        Work that = (Work) o;
        return new EqualsBuilder()
                .append(id, that.id)
                .append(authors, that.authors)
                .append(contributors, that.contributors)
                .append(editors, that.editors)
                .append(publisher, that.publisher)
                .append(titles, that.titles)
                .append(subject, that.subject)
                .append(workCollection, that.workCollection)
                .append(language, that.language)
                .append(audience, that.audience)
                .append(publicationType, that.publicationType)
                .append(publicationCountry, that.publicationCountry)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(authors)
                .append(contributors)
                .append(editors)
                .append(publisher)
                .append(titles)
                .append(subject)
                .append(audience)
                .append(workCollection)
                .append(language)
                .append(publicationType)
                .append(publicationCountry)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
