package com.copyright.rup.works.domain.api;

/**
 * Represents template for WorkItem. Has name, type and required fields.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/28/12
 *
 * @author Nikita Levyankov
 */
public interface IWorkItemTemplate {

    String getName();

    void setName(String name);

    WorkItemType getType();

    void setType(WorkItemType type);

    boolean isRequired();

    void setRequired(boolean required);

}
