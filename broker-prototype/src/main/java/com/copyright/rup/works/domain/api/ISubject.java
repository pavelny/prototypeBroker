package com.copyright.rup.works.domain.api;

import java.io.Serializable;

/**
 * Stores subject information for unified Works document.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/28/12
 *
 * @author Nikita Levyankov
 */
public interface ISubject extends Serializable {
    //TODO javadoc
    String getSubject();

    void setSubject(String subject);

    String getSubjectType();

    void setSubjectType(String subjectType);
}
