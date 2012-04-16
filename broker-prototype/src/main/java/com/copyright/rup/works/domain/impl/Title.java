package com.copyright.rup.works.domain.impl;

import com.copyright.rup.works.domain.api.ITitle;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Implementation of ITitle interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/29/12
 *
 * @author Nikita Levyankov
 */
public class Title implements ITitle {

    private String title;
    private String volume;
    private String type;
    private String edition;

    /**
     * {@inheritDoc}
     */
    public String getTitle() {
        return title;
    }

    /**
     * {@inheritDoc}
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * {@inheritDoc}
     */
    public String getVolume() {
        return volume;
    }

    /**
     * {@inheritDoc}
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * {@inheritDoc}
     */
    public String getType() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    public String getEdition() {
        return edition;
    }

    /**
     * {@inheritDoc}
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Title)) {
            return false;
        }

        Title that = (Title) o;
        return new EqualsBuilder()
                .append(title, that.title)
                .append(volume, that.volume)
                .append(type, that.type)
                .append(edition, that.edition)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(title)
                .append(volume)
                .append(type)
                .append(edition)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }

}
