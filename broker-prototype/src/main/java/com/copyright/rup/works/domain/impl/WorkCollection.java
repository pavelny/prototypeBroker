package com.copyright.rup.works.domain.impl;

import com.copyright.rup.works.domain.api.IWorkCollection;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * Implementation of Collection interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/2/12
 *
 * @author Nikita Levyankov
 */
public class WorkCollection implements IWorkCollection {
    private String collectionName;
    private String collectionType;
    private String dataProvider;
    private String submittedByUser;
    private Date submittedDatetime;
    private Date submitProcessedDatetime;
    private String createByFileSubmittedPath;
    private String createByFileOSFilePath;
    private String importFileType;
    private String importFileContentType;

    /**
     * {@inheritDoc}
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * {@inheritDoc}
     */
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    /**
     * {@inheritDoc}
     */
    public String getCollectionType() {
        return collectionType;
    }

    /**
     * {@inheritDoc}
     */
    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    /**
     * {@inheritDoc}
     */
    public String getDataProvider() {
        return dataProvider;
    }

    /**
     * {@inheritDoc}
     */
    public void setDataProvider(String dataProvider) {
        this.dataProvider = dataProvider;
    }

    /**
     * {@inheritDoc}
     */
    public String getSubmittedByUser() {
        return submittedByUser;
    }

    /**
     * {@inheritDoc}
     */
    public void setSubmittedByUser(String submittedByUser) {
        this.submittedByUser = submittedByUser;
    }

    /**
     * {@inheritDoc}
     */
    public Date getSubmittedDatetime() {
        return submittedDatetime;
    }

    /**
     * {@inheritDoc}
     */
    public void setSubmittedDatetime(Date submittedDatetime) {
        this.submittedDatetime = submittedDatetime;
    }

    /**
     * {@inheritDoc}
     */
    public Date getSubmitProcessedDatetime() {
        return submitProcessedDatetime;
    }

    /**
     * {@inheritDoc}
     */
    public void setSubmitProcessedDatetime(Date submitProcessedDatetime) {
        this.submitProcessedDatetime = submitProcessedDatetime;
    }

    /**
     * {@inheritDoc}
     */
    public String getCreateByFileSubmittedPath() {
        return createByFileSubmittedPath;
    }

    /**
     * {@inheritDoc}
     */
    public void setCreateByFileSubmittedPath(String createByFileSubmittedPath) {
        this.createByFileSubmittedPath = createByFileSubmittedPath;
    }

    /**
     * {@inheritDoc}
     */
    public String getCreateByFileOSFilePath() {
        return createByFileOSFilePath;
    }

    /**
     * {@inheritDoc}
     */
    public void setCreateByFileOSFilePath(String createByFileOSFilePath) {
        this.createByFileOSFilePath = createByFileOSFilePath;
    }

    /**
     * {@inheritDoc}
     */
    public String getImportFileType() {
        return importFileType;
    }

    /**
     * {@inheritDoc}
     */
    public void setImportFileType(String importFileType) {
        this.importFileType = importFileType;
    }

    /**
     * {@inheritDoc}
     */
    public String getImportFileContentType() {
        return importFileContentType;
    }

    /**
     * {@inheritDoc}
     */
    public void setImportFileContentType(String importFileContentType) {
        this.importFileContentType = importFileContentType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WorkCollection)) {
            return false;
        }

        WorkCollection that = (WorkCollection) o;
        return new EqualsBuilder()
                .append(collectionName, that.collectionName)
                .append(collectionType, that.collectionType)
                .append(dataProvider, that.dataProvider)
                .append(submittedByUser, that.submittedByUser)
                .append(submittedDatetime, that.submittedDatetime)
                .append(submitProcessedDatetime, that.submitProcessedDatetime)
                .append(createByFileSubmittedPath, that.createByFileSubmittedPath)
                .append(createByFileOSFilePath, that.createByFileOSFilePath)
                .append(importFileType, that.importFileType)
                .append(importFileContentType, that.importFileContentType)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(collectionName)
                .append(collectionType)
                .append(dataProvider)
                .append(submittedByUser)
                .append(submittedDatetime)
                .append(submitProcessedDatetime)
                .append(createByFileSubmittedPath)
                .append(createByFileOSFilePath)
                .append(importFileType)
                .append(importFileContentType)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
