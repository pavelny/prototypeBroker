package com.copyright.rup.works.domain.api;

import java.io.Serializable;

/**
 * Represents Affiliation data for Authors, Contributors, etc.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/30/12
 *
 * @author Nikita Levyankov
 */
public interface IAffiliation extends Serializable {
    //TODO javadoc
    String getAddress();

    void setAddress(String address);

    String getCountry();

    void setCountry(String country);
}
