package com.copyright.rup.works.domain.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.copyright.rup.works.domain.api.IAffiliation;
import com.copyright.rup.works.domain.api.IBasePerson;

/**
 * Implementation of IBasePerson interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/30/12
 *
 * @author Nikita Levyankov
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BasePerson implements IBasePerson {
    private String name;
    private String role;
    @XmlElement(type = Affiliation.class)
    private IAffiliation affiliation;

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    public String getRole() {
        return role;
    }

    /**
     * {@inheritDoc}
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * {@inheritDoc}
     */
    public IAffiliation getAffiliation() {
        return affiliation;
    }

    /**
     * {@inheritDoc}
     */
    public void setAffiliation(IAffiliation affiliation) {
        this.affiliation = affiliation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BasePerson)) {
            return false;
        }

        BasePerson that = (BasePerson) o;
        return new EqualsBuilder()
                .append(name, that.name)
                .append(role, that.role)
                .append(affiliation, that.affiliation)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(name)
                .append(role)
                .append(affiliation)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
