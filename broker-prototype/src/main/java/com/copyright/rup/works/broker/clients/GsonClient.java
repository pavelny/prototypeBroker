/**
 *
 */
package com.copyright.rup.works.broker.clients;

import com.copyright.rup.works.broker.Generator;
import com.copyright.rup.works.broker.UtilVarialble;
import com.copyright.rup.works.broker.api.IBrokerService;
import com.copyright.rup.works.broker.impl.BrokerService;
import com.copyright.rup.works.broker.impl.JsonConsumer;
import com.copyright.rup.works.broker.impl.JsonProducer;
import com.copyright.rup.works.broker.marshaler.GsonMarshaler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Andrei_Khadziukou
 *
 */
public class GsonClient extends BaseClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(Generator.class);
    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            GsonClient client = new GsonClient();
            client.start(UtilVarialble.PRODUCER_QUEUE_GSON);
            client.stop();
        } catch (Exception exc) {
            LOGGER.info("Exception: " + exc.getMessage());
        }

    }

    public GsonClient() throws Exception {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected IBrokerService createBrokerService() {
        BrokerService service = new BrokerService();
        service.setConsumer(new JsonConsumer(getConsumerTemplate()));
        service.setProducer(new JsonProducer(getProduceTemplate()));
        service.setMarshaler(new GsonMarshaler());
        return service;
    }

}
