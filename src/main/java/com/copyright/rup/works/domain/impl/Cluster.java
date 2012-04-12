package com.copyright.rup.works.domain.impl;

import com.copyright.rup.works.domain.api.ICluster;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Implementation of ICluster interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/30/12
 *
 * @author Nikita Levyankov
 */
public class Cluster implements ICluster {

    private String type;
    private String commonAttribute;
    private String key;

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
    public String getCommonAttribute() {
        return commonAttribute;
    }

    /**
     * {@inheritDoc}
     */
    public void setCommonAttribute(String commonAttribute) {
        this.commonAttribute = commonAttribute;
    }

    /**
     * {@inheritDoc}
     */
    public String getKey() {
        return key;
    }

    /**
     * {@inheritDoc}
     */
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cluster)) {
            return false;
        }

        Cluster that = (Cluster) o;
        return new EqualsBuilder()
                .append(type, that.type)
                .append(commonAttribute, that.commonAttribute)
                .append(key, that.key)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(type)
                .append(commonAttribute)
                .append(key)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
