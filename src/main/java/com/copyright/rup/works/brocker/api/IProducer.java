package com.copyright.rup.works.brocker.api;

import com.copyright.rup.works.domain.api.IWork;

import java.util.List;

/**
 * Common producer interface.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/11/12
 *
 * @author Pavel_Yakovlev
 */
public interface IProducer {
    /**
     * Sends works to broker.
     */
    // TODO Add more details into java doc
    void sendWorks(String nameOfQueue, List<IWork> works, IMarshaler marshaler);
}
