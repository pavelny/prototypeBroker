package com.copyright.rup.works.domain.api;

import java.io.Serializable;

/**
 * Represents publisher data for unified Works document.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/30/12
 *
 * @author Nikita Levyankov
 */
public interface IPublisher extends Serializable {
    //TODO javadoc
    String getName();

    void setName(String name);

    String getRole();

    void setRole(String role);

    String getPublicationPlace();

    void setPublicationPlace(String publicationPlace);

    String getStatus();

    void setStatus(String status);

    Integer getSortOrder();

    void setSortOrder(Integer sortOrder);
}
