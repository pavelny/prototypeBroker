package com.copyright.rup.works.domain.impl;

import com.copyright.rup.works.domain.api.INote;

/**
 * Implementation of INote interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 3/30/12
 *
 * @author Nikita Levyankov
 */
public class Note implements INote {

    private String type;
    private boolean readonly;
    private String text;

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
    public boolean isReadonly() {
        return readonly;
    }

    /**
     * {@inheritDoc}
     */
    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    /**
     * {@inheritDoc}
     */
    public String getText() {
        return text;
    }

    /**
     * {@inheritDoc}
     */
    public void setText(String text) {
        this.text = text;
    }
}
