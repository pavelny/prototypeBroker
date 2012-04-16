/**
 *
 */
package com.copyright.rup.works.broker.clients;

import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IBrokerService;
import com.copyright.rup.works.broker.impl.BrokerService;
import com.copyright.rup.works.broker.impl.JsonConsumer;
import com.copyright.rup.works.broker.impl.JsonProducer;
import com.copyright.rup.works.broker.marshaler.JaxbMarshaler;

/**
 * @author Andrei_Khadziukou
 *
 */
public class JaxbClient extends BaseClient {

    public JaxbClient() throws Exception {
        super();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            JaxbClient client = new JaxbClient();
            client.start(UtilVarialble.PRODUCER_QUEUE_JAXB);
            client.stop();
        } catch (Exception exc) {
            // TODO Add log
            exc.printStackTrace();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected IBrokerService createBrokerService() {
        BrokerService service = new BrokerService();
        service.setConsumer(new JsonConsumer(getConsumerTemplate()));
        service.setProducer(new JsonProducer(getProduceTemplate()));
        service.setMarshaler(new JaxbMarshaler());
        return service;
    }

}