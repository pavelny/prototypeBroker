package com.copyright.rup.works.domain.impl;

import com.copyright.rup.works.domain.api.ISubject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Implementation of ISubject interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/29/12
 *
 * @author Nikita Levyankov
 */
public class Subject implements ISubject {
    private String subject;
    private String subjectType;

    /**
     * {@inheritDoc}
     */
    public String getSubject() {
        return subject;
    }

    /**
     * {@inheritDoc}
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * {@inheritDoc}
     */
    public String getSubjectType() {
        return subjectType;
    }

    /**
     * {@inheritDoc}
     */
    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Subject)) {
            return false;
        }

        Subject that = (Subject) o;
        return new EqualsBuilder()
                .append(subject, that.subject)
                .append(subjectType, that.subjectType)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(subject)
                .append(subjectType)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
