package com.copyright.rup.works.domain.impl;

import com.copyright.rup.works.domain.api.IAbstract;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Implementation of IAbstract interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/30/12
 *
 * @author Nikita Levyankov
 */
public class AbstractItem implements IAbstract {
    private String text;
    private String copyrightOwner;

    /**
     * {@inheritDoc}
     */
    public String getText() {
        return text;
    }

    /**
     * {@inheritDoc}
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * {@inheritDoc}
     */
    public String getCopyrightOwner() {
        return copyrightOwner;
    }

    /**
     * {@inheritDoc}
     */
    public void setCopyrightOwner(String copyrightOwner) {
        this.copyrightOwner = copyrightOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractItem)) {
            return false;
        }

        AbstractItem that = (AbstractItem) o;
        return new EqualsBuilder()
                .append(text, that.text)
                .append(copyrightOwner, that.copyrightOwner)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(text)
                .append(copyrightOwner)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
