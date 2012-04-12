package com.copyright.rup.works.domain.api;

import java.io.Serializable;

/**
 * Represents base person data for unified Works document: Name, Role, Affiliation.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/30/12
 *
 * @author Nikita Levyankov
 */
public interface IBasePerson extends Serializable {
    //TODO javadoc
    String getName();

    void setName(String name);

    String getRole();

    void setRole(String role);

    IAffiliation getAffiliation();

    void setAffiliation(IAffiliation affiliation);
}
