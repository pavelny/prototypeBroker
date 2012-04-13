/**
 *
 */
package com.copyright.rup.works.brocker.api;

import java.util.List;

import com.copyright.rup.works.domain.api.IWork;

/**
 *
 *
 * @author Andrei_Khadziukou
 *
 */
// TODO correct javadoc for interface and file
public interface IBrokerService {

    /**
     * @param works
     * @param queueName
     */
    // TODO Add javadoc
    void send(List<IWork> works, String queueName);

    /**
     *
     * @param queueName
     *
     * @return
     */
    // TODO Add javadoc
    List<IWork> recive(String queueName);

}
