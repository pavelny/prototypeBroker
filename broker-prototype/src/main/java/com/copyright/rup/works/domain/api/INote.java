package com.copyright.rup.works.domain.api;

import java.io.Serializable;

/**
 * Represents Note data for unified Works document.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/30/12
 *
 * @author Nikita Levyankov
 */
public interface INote extends Serializable {

    String getType();

    void setType(String type);

    boolean isReadonly();

    void setReadonly(boolean readonly);

    String getText();

    void setText(String text);
}
