package com.copyright.rup.works.domain.api;

import java.io.Serializable;

/**
 * Represents Abstract data for unified Works document.
 * For ex. AbstractCopyrightOwner, AbstractText.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/30/12
 *
 * @author Nikita Levyankov
 */
public interface IAbstract extends Serializable {

    String getText();

    void setText(String text);

    String getCopyrightOwner();

    void setCopyrightOwner(String copyrightOwner);

}
