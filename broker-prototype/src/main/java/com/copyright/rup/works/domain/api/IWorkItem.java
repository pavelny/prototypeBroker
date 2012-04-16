package com.copyright.rup.works.domain.api;

/**
 * Represents WorkItem for Works document. Will be used to customize Works Document structure for
 * different formats.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/28/12
 *
 * @author Nikita Levyankov
 */
public interface IWorkItem {

    String getName();

    void setName(String name);

    WorkItemType getType();

    void setType(WorkItemType type);

    String getValue();

    void setValue(String value);

}
