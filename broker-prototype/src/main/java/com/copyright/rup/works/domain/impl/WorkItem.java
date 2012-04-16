package com.copyright.rup.works.domain.impl;

import com.copyright.rup.works.domain.api.IWorkItem;
import com.copyright.rup.works.domain.api.WorkItemType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Implementation of IWorkItem interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/29/12
 *
 * @author Nikita Levyankov
 */
public class WorkItem implements IWorkItem {
    private String name;
    private WorkItemType type;
    private String value;

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
    public String getValue() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WorkItem)) {
            return false;
        }

        WorkItem that = (WorkItem) o;
        return new EqualsBuilder()
                .append(name, that.name)
                .append(type, that.type)
                .append(value, that.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(name)
                .append(type)
                .append(value)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
