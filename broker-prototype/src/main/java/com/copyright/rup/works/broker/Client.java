package com.copyright.rup.works.broker;

import com.copyright.rup.works.broker.clients.BaseClient;
import com.copyright.rup.works.broker.clients.GsonClient;
import com.copyright.rup.works.broker.clients.JacksonClient;
import com.copyright.rup.works.broker.clients.JaxbClient;
import com.copyright.rup.works.broker.clients.XstreamClient;

import org.apache.log4j.Logger;

/**
 * It is a class for running application from console.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 04/12/12
 *
 * @author Andrei_Khadziukou.
 *
 */
public final class Client {

    /**
     * The parameter for running {@link GsonClient}.
     */
    private static final String ARG_GSON = "gson";

    /**
     * The parameter for running {@link JacksonClient}.
     */
    private static final String ARG_JACKSON = "jackson";

    /**
     * The parameter for running {@link ThriftClient}.
     */
    private static final String ARG_THRIFT = "thrift";

    /**
     * The parameter for running {@link XstreamClient}.
     */
    private static final String ARG_XSTREAM = "xstream";

    /**
     * The logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Client.class);

    /**
     * The entry point to app.
     *
     * @param args
     *            The command line arguments
     * @throws Exception
     */
    public static void main(String[] args) {
        LOGGER.info("Client was started initialization....");
        BaseClient client = new JaxbClient();
        String queue = UtilVarialble.QUEUE_JAXB;
        if (args.length != 0) {
            switch (args[0].toLowerCase()) {
                case ARG_JACKSON:
                    client = new JacksonClient();
                    queue = UtilVarialble.QUEUE_JACKSON;
                    break;
                case ARG_GSON:
                    client = new GsonClient();
                    queue = UtilVarialble.QUEUE_GSON;
                    break;
                case ARG_XSTREAM:
                    client = new XstreamClient();
                    queue = UtilVarialble.QUEUE_XSTREM;
                    break;
/*                case ARG_THRIFT:
                    client = new ThriftClient();
                    queue = UtilVarialble.QUEUE_THRIFT;
                    break;
*/
                default:
                    break;
            }
        }
        LOGGER.info("Client was initialized! Client: " + client.getClass().getSimpleName()
                + ", queue: " + queue);
        LOGGER.info("Client was started....");
        client.start(queue);
        client.stop();
        LOGGER.info("Client was started....");
    }

    /**
     * The private constructor.
     */
    private Client() {
    }

}
