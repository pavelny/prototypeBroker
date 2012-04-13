/**
 *
 */
package com.copyright.rup.works.broker.api;

import com.copyright.rup.works.domain.api.IWork;

import java.util.List;

/**
 *
 *
 * @author Andrei_Khadziukou
 *
 */
// TODO correct javadoc for interface and file
public interface IBrokerService {

    /**
     *
     * @param queueName
     *
     * @return
     */
    // TODO Add javadoc
    List<IWork> receive(String queueName);

    /**
     * @param works
     * @param queueName
     */
    // TODO Add javadoc
    void send(List<IWork> works, String queueName);

}
