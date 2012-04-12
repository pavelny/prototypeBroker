package com.copyright.rup.works.brocker;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Work dto.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/9/12
 *
 * @author Pavel_Yakovlev
 */
@XmlRootElement
public class Work implements Serializable {
        private String id;
        private String language;
        private String publicationType;
        private String publicationCountry;
        private String subject;
        private List<String> titles;
        private List<String> audience;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public List<String> getTitles() {
            return titles;
        }

        public void setTitles(List<String> title) {
            this.titles = title;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public List<String> getAudience() {
            return audience;
        }

        public void setAudience(List<String> audience) {
            this.audience = audience;
        }

        public String getPublicationType() {
            return publicationType;
        }

        public void setPublicationType(String publicationType) {
            this.publicationType = publicationType;
        }

        public String getPublicationCountry() {
            return publicationCountry;
        }

        public void setPublicationCountry(String publicationCountry) {
            this.publicationCountry = publicationCountry;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Work)) {
                return false;
            }

            Work that = (Work) o;
            return new EqualsBuilder()
                    .append(id, that.id)
                    .append(getTitles(), that.titles)
                    .append(subject, that.subject)
                    .append(language, that.language)
                    .append(audience, that.audience)
                    .append(publicationType, that.publicationType)
                    .append(publicationCountry, that.publicationCountry)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder()
                    .append(id)
                    .append(getTitles())
                    .append(subject)
                    .append(audience)
                    .append(language)
                    .append(publicationType)
                    .append(publicationCountry)
                    .toHashCode();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).toString();
        }

}
