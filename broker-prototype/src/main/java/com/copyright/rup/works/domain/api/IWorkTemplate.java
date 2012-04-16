package com.copyright.rup.works.domain.api;

import java.util.List;
import java.util.Map;

/**
 * Dynamically generated template structure for Works document.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/28/12
 *
 * @author Nikita Levyankov
 */
public interface IWorkTemplate {
    /**
     * @return unique mapping Key and a list of tree-like elements to display path to the mapped value in file
     */
    Map<String, List<String>> getWorkMapping();

    void setWorkMapping(Map<String, List<String>> workMapping);

    /**
     * @return unique mapping Key and {@link IWorkItemTemplate} interface which describes type of mapped value
     */
    Map<String, IWorkItemTemplate> getWorkItemTemplates();

    void setWorkItemTemplates(Map<String, IWorkItemTemplate> workItemTemplates);
}
