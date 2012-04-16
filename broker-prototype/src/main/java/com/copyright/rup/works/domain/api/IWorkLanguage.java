package com.copyright.rup.works.domain.api;

import java.io.Serializable;

/**
 * Represents WorkLanguage data for unified Works document.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/2/12
 *
 * @author Nikita Levyankov
 */
public interface IWorkLanguage extends Serializable {
    //TODO javadoc
    String getLanguage();

    void setLanguage(String language);

    String getLanguageRole();

    void setLanguageRole(String languageRole);
}
