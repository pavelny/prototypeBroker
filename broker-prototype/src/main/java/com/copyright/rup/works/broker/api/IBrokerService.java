package com.copyright.rup.works.broker.api;

import com.copyright.rup.works.domain.api.IWork;

import java.util.List;

/**
 * It provides functionality for sending and receiving messages into and from broker queue.
 *
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/13/12
 *
 * @author Andrei_Khadziukou.
 *
 */
// TODO create separate interface consuming and producing
public interface IBrokerService {

    /**
     * It receives message from broker queue and converts them into list of {@link IWork} objects.
     *
     * @param queueName the name of queue.
     *
     * @return list of {@link IWork}.
     */
    List<IWork> receive(String queueName);

    /**
     * It converts list of { objects to message and sends them into broker queue.
     *
     * @param works list of {@link IWork} instances.
     * @param queueName The name of broker queue.
     */
    void send(List<IWork> works, String queueName);

}
