package com.copyright.rup.works.domain.impl;

import com.copyright.rup.works.domain.api.IWorkItemTemplate;
import com.copyright.rup.works.domain.api.WorkItemType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Implementation of WorkItemTemplate interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/29/12
 *
 * @author Nikita Levyankov
 */
public class WorkItemTemplate implements IWorkItemTemplate {
    private String name;
    private WorkItemType type;
    private boolean required;

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
    public WorkItemType getType() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    public void setType(WorkItemType type) {
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * {@inheritDoc}
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WorkItemTemplate)) {
            return false;
        }

        WorkItemTemplate that = (WorkItemTemplate) o;
        return new EqualsBuilder()
                .append(name, that.name)
                .append(type, that.type)
                .append(required, that.required)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(name)
                .append(type)
                .append(required)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
