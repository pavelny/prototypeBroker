package com.copyright.rup.works.domain.api;

import java.io.Serializable;

/**
 * Represents title structure for unified Works document.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/28/12
 *
 * @author Nikita Levyankov
 */
public interface ITitle extends Serializable {
    //TODO javadoc
    String getTitle();

    void setTitle(String title);

    String getVolume();

    void setVolume(String volume);

    String getType();

    void setType(String type);

    String getEdition();

    void setEdition(String edition);
}
