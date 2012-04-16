package com.copyright.rup.works.domain.impl;

import com.copyright.rup.works.domain.api.IWorkLanguage;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Implementation of IWorkLanguage interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/2/12
 *
 * @author Nikita Levyankov
 */
public class WorkLanguage implements IWorkLanguage {

    private String language;
    private String languageRole;

    /**
     * {@inheritDoc}
     */
    public String getLanguage() {
        return language;
    }

    /**
     * {@inheritDoc}
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * {@inheritDoc}
     */
    public String getLanguageRole() {
        return languageRole;
    }

    /**
     * {@inheritDoc}
     */
    public void setLanguageRole(String languageRole) {
        this.languageRole = languageRole;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WorkLanguage)) {
            return false;
        }

        WorkLanguage that = (WorkLanguage) o;
        return new EqualsBuilder()
                .append(language, that.language)
                .append(languageRole, that.languageRole)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(language)
                .append(languageRole)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
