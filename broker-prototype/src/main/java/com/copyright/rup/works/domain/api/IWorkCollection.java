package com.copyright.rup.works.domain.api;

import java.util.Date;

/**
 * Represents Collection data for unified Works document.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/2/12
 *
 * @author Nikita Levyankov
 */
public interface IWorkCollection {
    //TODO javadoc
    String getCollectionName();

    void setCollectionName(String collectionName);

    String getCollectionType();

    void setCollectionType(String collectionType);

    String getDataProvider();

    void setDataProvider(String dataProvider);

    String getSubmittedByUser();

    void setSubmittedByUser(String submittedByUser);

    Date getSubmittedDatetime();

    void setSubmittedDatetime(Date submittedDatetime);

    Date getSubmitProcessedDatetime();

    void setSubmitProcessedDatetime(Date submitProcessedDatetime);

    String getCreateByFileSubmittedPath();

    void setCreateByFileSubmittedPath(String createByFileSubmittedPath);

    String getCreateByFileOSFilePath();

    void setCreateByFileOSFilePath(String createByFileOSFilePath);

    String getImportFileType();

    void setImportFileType(String importFileType);

    String getImportFileContentType();

    void setImportFileContentType(String importFileContentType);
}
