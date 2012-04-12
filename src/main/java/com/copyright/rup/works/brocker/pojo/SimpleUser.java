package com.copyright.rup.works.brocker.pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.copyright.rup.works.brocker.api.ISimpleUser;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SimpleUser implements ISimpleUser {

    private String name;
    private int year;
    private Integer number;
    @XmlAnyElement
    private List<ISimpleUser> children;

    private Map<String, String> association;

    private Date birthday;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return the children
     */
    public List<ISimpleUser> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<ISimpleUser> children) {
        this.children = children;
    }

    /**
     * @return the association
     */
    public Map<String, String> getAssociation() {
        return association;
    }

    /**
     * @param association the association to set
     */
    public void setAssociation(Map<String, String> association) {
        this.association = association;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
