package com.copyright.rup.works.brocker;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.ConnectionFactory;

/**
 * Server to run broker.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 4/11/12
 *
 * @author Pavel_Yakovlev
 */
public final class Server {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

    public static void main(String... args) throws Exception {
        Broker broker = new Broker(UtilVarialble.BROKER_URL);
        broker.start();

        CamelContext context = new DefaultCamelContext();

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                UtilVarialble.BROKER_URL);
        context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        context.addRoutes(new BrokerRoute());

        context.start();
        LOGGER.info("Server is started!");

        Thread.sleep(UtilVarialble.BROKER_CAMEL_CONTEXT_SLEEP);
        context.stop();
        Thread.sleep(UtilVarialble.BROKER_SLEEP);
        broker.stop();
    }

    /**
     *
     */
    // TODO Add javadoc
    private Server() {
    }

}
