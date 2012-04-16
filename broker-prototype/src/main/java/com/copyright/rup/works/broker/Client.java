package com.copyright.rup.works.broker;

import com.copyright.rup.works.broker.clients.BaseClient;
import com.copyright.rup.works.broker.clients.GsonClient;
import com.copyright.rup.works.broker.clients.JacksonClient;
import com.copyright.rup.works.broker.clients.JaxbClient;
import com.copyright.rup.works.broker.clients.ThriftClient;
import com.copyright.rup.works.broker.clients.XstreamClient;

// TODO Add javadoc
public final class Client {

    private static final String JACKSON = "jackson";
    private static final String GSON = "gson";
    private static final String XSTREAM = "xstream";
    private static final String THRIFT = "thrift";

    public static void main(String args[]) throws Exception {
        BaseClient client = new JaxbClient();
        String queue = UtilVarialble.PRODUCER_QUEUE_JAXB;
        if (args.length != 0) {
            switch (args[0].toLowerCase()) {
                case JACKSON :
                    client = new JacksonClient();
                    queue = UtilVarialble.PRODUCER_QUEUE_JACKSON;
                    break;
                case GSON:
                    client = new GsonClient();
                    queue = UtilVarialble.PRODUCER_QUEUE_GSON;
                    break;
                case XSTREAM:
                    client = new XstreamClient();
                    queue = UtilVarialble.PRODUCER_QUEUE_XSTREM;
                    break;
                case THRIFT:
                    client = new ThriftClient();
                    queue = UtilVarialble.PRODUCER_QUEUE_THRIFT;
                    break;
                default:
                    break;
            }
        }
        client.start(queue);
        client.stop();
    }

}
