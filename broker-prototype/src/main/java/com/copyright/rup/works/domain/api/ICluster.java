package com.copyright.rup.works.domain.api;

/**
 * A cluster key is composed of the following:
 * 1. cluster type = 'M', 'S', 'A', or 'C'
 * 2. common attribute name = 'SHORTTITLE', 'VALISBN13', 'VALISSN'
 * 3. common attribute value
 * 4. media type = 'M' or 'O'
 * 5. cluster key = concatenation of components
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/30/12
 *
 * @author Nikita Levyankov
 */
public interface ICluster {

    String getType();

    void setType(String type);

    String getCommonAttribute();

    void setCommonAttribute(String commonAttribute);

    String getKey();

    void setKey(String key);
}
