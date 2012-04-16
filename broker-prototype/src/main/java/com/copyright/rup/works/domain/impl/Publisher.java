package com.copyright.rup.works.domain.impl;

import com.copyright.rup.works.domain.api.IPublisher;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Implementation of IPublisher interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/30/12
 *
 * @author Nikita Levyankov
 */
public class Publisher implements IPublisher {

    private String name;
    private String role;
    private String publicationPlace;
    private String status;
    private Integer sortOrder;

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
    public String getPublicationPlace() {
        return publicationPlace;
    }

    /**
     * {@inheritDoc}
     */
    public void setPublicationPlace(String publicationPlace) {
        this.publicationPlace = publicationPlace;
    }

    /**
     * {@inheritDoc}
     */
    public String getStatus() {
        return status;
    }

    /**
     * {@inheritDoc}
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * {@inheritDoc}
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * {@inheritDoc}
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Publisher)) {
            return false;
        }

        Publisher that = (Publisher) o;
        return new EqualsBuilder()
                .append(name, that.name)
                .append(role, that.role)
                .append(publicationPlace, that.publicationPlace)
                .append(status, that.status)
                .append(sortOrder, that.sortOrder)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(name)
                .append(role)
                .append(publicationPlace)
                .append(status)
                .append(sortOrder)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
