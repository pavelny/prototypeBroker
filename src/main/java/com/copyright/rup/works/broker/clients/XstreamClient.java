/**
 *
 */
package com.copyright.rup.works.broker.clients;

import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IBrokerService;
import com.copyright.rup.works.broker.impl.BrokerService;
import com.copyright.rup.works.broker.impl.JsonConsumer;
import com.copyright.rup.works.broker.impl.JsonProducer;
import com.copyright.rup.works.broker.marshaler.XStreamMarshaler;

/**
 * @author Andrei_Khadziukou
 *
 */
public class XstreamClient extends BaseClient {

    public XstreamClient() throws Exception {
        super();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            XstreamClient client = new XstreamClient();
            client.start(UtilVarialble.PRODUCER_QUEUE_XSTREM, UtilVarialble.CONSUMER_QUEUE_XSTREM);
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
        service.setMarshaler(new XStreamMarshaler());
        return service;
    }

}