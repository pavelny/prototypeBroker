/**
 *
 */
package com.copyright.rup.works.broker.clients;

import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IBrokerService;
import com.copyright.rup.works.broker.impl.BrokerService;
import com.copyright.rup.works.broker.impl.ThriftConsumer;
import com.copyright.rup.works.broker.impl.ThriftProducer;

/**
 * @author Andrei_Khadziukou
 *
 */
public class ThriftClient extends BaseClient {

    public ThriftClient() throws Exception {
        super();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            ThriftClient client = new ThriftClient();
            client.start(UtilVarialble.PRODUCER_QUEUE_THRIFT, UtilVarialble.CONSUMER_QUEUE_THRIFT);
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
        service.setConsumer(new ThriftConsumer(getConsumerTemplate()));
        service.setProducer(new ThriftProducer(getProduceTemplate()));
        service.setMarshaler(null);
        return service;
    }

}