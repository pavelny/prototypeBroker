package com.copyright.rup.works.broker.api;

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
     *
     * @param nameOfQueue
     *            the name of queue.
     * @param works
     *            The POJO list to send.
     * @param marshaler
     *            the marshaler.
     */
    void sendWorks(String nameOfQueue, List<IWork> works, IMarshaler marshaler);
}
