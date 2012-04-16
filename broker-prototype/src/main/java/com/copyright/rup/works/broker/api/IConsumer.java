package com.copyright.rup.works.broker.api;

/**
 * Common interface to work with consumer.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/11/12
 *
 * @author Pavel_Yakovlev
 */
public interface IConsumer {

    /**
     * Receives works from broker.
     *
     * @param nameOfQueue
     *            name of broker queue.
     * @param expectedSizeOfCollection
     *            expected size of collection works in queue.
     * @param marshaler
     *            the marshaler.
     */
    void receiveWorks(String nameOfQueue, int expectedSizeOfCollection, IMarshaler marshaler);
}
