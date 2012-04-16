package com.copyright.rup.works.domain.impl;

import com.copyright.rup.works.domain.api.IAuthor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * Implementation of IAuthor interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/30/12
 *
 * @author Nikita Levyankov
 */
public class Author extends BasePerson implements IAuthor {

    private String birthYear;
    private String deathYear;

    /**
     * {@inheritDoc}
     */
    public String getBirthYear() {
        return birthYear;
    }

    /**
     * {@inheritDoc}
     */
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    /**
     * {@inheritDoc}
     */
    public String getDeathYear() {
        return deathYear;
    }

    /**
     * {@inheritDoc}
     */
    public void setDeathYear(String deathYear) {
        this.deathYear = deathYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Author)) {
            return false;
        }

        Author that = (Author) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(birthYear, that.birthYear)
                .append(deathYear, that.deathYear)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(birthYear)
                .append(deathYear)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
