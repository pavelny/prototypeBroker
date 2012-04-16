package com.copyright.rup.works.broker.marshaler;

import com.copyright.rup.works.domain.api.IWork;
import com.copyright.rup.works.domain.impl.Work;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * It is a wrapper class for {@link IWork} object list.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 04/13/12.
 *
 * @author Andrei_Khadziukou.
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkWrapper {

    @XmlElement(type = Work.class)
    private List<IWork> works;

    /**
     * It gets {@link IWork} object list.
     *
     * @return The {@link IWork} list.
     */
    public List<IWork> getWorks() {
        return works;
    }

    /**
     * It sets list of {@link IWork} objects.
     *
     * @param works
     *            the works to set
     */
    public void setWorks(List<IWork> works) {
        this.works = works;
    }

}
