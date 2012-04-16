package com.copyright.rup.works.domain.api;

/**
 * Represents Authors data for unified Works document.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/30/12
 *
 * @author Nikita Levyankov
 */
public interface IAuthor extends IBasePerson {
    //TODO javadoc
    String getBirthYear();

    void setBirthYear(String birthYear);

    String getDeathYear();

    void setDeathYear(String deathYear);
}
