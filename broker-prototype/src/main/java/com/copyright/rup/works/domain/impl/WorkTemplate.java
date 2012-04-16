package com.copyright.rup.works.domain.impl;

import com.copyright.rup.works.domain.api.IWorkItemTemplate;
import com.copyright.rup.works.domain.api.IWorkTemplate;

import java.util.List;
import java.util.Map;

/**
 * Implementation of IWorkTemplate interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/29/12
 *
 * @author Nikita Levyankov
 */
public class WorkTemplate implements IWorkTemplate {
    /**
     * holds unique mapping Key and a list of tree-like elements to display path to the mapped value in file
     */
    private Map<String, List<String>> workMapping;
    /**
     * holds unique mapping Key and WorkItemTemplate class which describes type of mapped value
     */
    private Map<String, IWorkItemTemplate> workItemTemplates;

    /**
     * {@inheritDoc}
     */
    public Map<String, List<String>> getWorkMapping() {
        return workMapping;
    }

    /**
     * {@inheritDoc}
     */
    public void setWorkMapping(Map<String, List<String>> workMapping) {
        this.workMapping = workMapping;
    }

    /**
     * {@inheritDoc}
     */
    public Map<String, IWorkItemTemplate> getWorkItemTemplates() {
        return workItemTemplates;
    }

    /**
     * {@inheritDoc}
     */
    public void setWorkItemTemplates(Map<String, IWorkItemTemplate> workItemTemplates) {
        this.workItemTemplates = workItemTemplates;
    }
}
