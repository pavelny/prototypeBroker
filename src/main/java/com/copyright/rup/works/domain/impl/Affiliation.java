package com.copyright.rup.works.domain.impl;

import com.copyright.rup.works.domain.api.IAffiliation;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Implementation of Affiliation interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/30/12
 *
 * @author Nikita Levyankov
 */
public class Affiliation implements IAffiliation {
    private String address;
    private String country;

    /**
     * {@inheritDoc}
     */
    public String getAddress() {
        return address;
    }

    /**
     * {@inheritDoc}
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * {@inheritDoc}
     */
    public String getCountry() {
        return country;
    }

    /**
     * {@inheritDoc}
     */
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Affiliation)) {
            return false;
        }

        Affiliation that = (Affiliation) o;
        return new EqualsBuilder()
                .append(address, that.address)
                .append(country, that.country)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(address)
                .append(country)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
