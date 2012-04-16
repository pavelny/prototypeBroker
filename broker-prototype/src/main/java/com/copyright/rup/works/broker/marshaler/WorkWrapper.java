package com.copyright.rup.works.broker.marshaler;

import com.copyright.rup.works.domain.api.IWork;
import com.copyright.rup.works.domain.impl.Work;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Andrei_Khadziukou
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkWrapper {

    @XmlElement(type = Work.class)
    private List<IWork> works;

    /**
     * @return the works
     */
    public List<IWork> getWorks() {
        return works;
    }

    /**
     * @param works
     *            the works to set
     */
    public void setWorks(List<IWork> works) {
        this.works = works;
    }

}
