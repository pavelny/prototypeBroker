package com.copyright.rup.works.broker;


/**
 * Util class for common variable.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 04/14/12
 *
 * @author Andrei_Khadziukou
 *
 */
public abstract class UtilVarialble {

    /**
     * Broker context sleep
     */
    public static final int BROKER_CAMEL_CONTEXT_SLEEP = 5 * 60 * 10000;

    /**
     * URL to local activeMq server
     */
    public static final String BROKER_CLIENT_URL = "tcp://epbyvitw0013:61616?jms.useAsyncSend=true" +
            "&wireFormat.maxInactivityDurationInitalDelay=20000";

    /**
     * Broker sleep
     */
    public static final int BROKER_SLEEP = 1000;

    /**
     *
     */
    public static final String BROKER_TMP_DATA_DIRECTORY2 = "./target";

    /**
     * The count of message
     */
    public static final int WORKS_COLLECTION_SIZE = 1000000;

    /**
     * This variable is used for generating
     */
    public static final int CHUNK_SIZE = 1000;

    /**
     * The queue name for gson
     */
    public static final String QUEUE_GSON = "jms:queue:storagegson";

    /**
     * The queue name for jackson
     */
    public static final String QUEUE_JACKSON = "jms:queue:storagejackson";

    /**
     * The queue name for jaxb
     */
    public static final String QUEUE_JAXB = "jms:queue:storagejaxb";

    /**
     * The queue name for thrift
     */
    public static final String QUEUE_THRIFT = "jms:queue:storagethrift";

    /**
     * the queue name for xstream
     */
    public static final String QUEUE_XSTREM = "jms:queue:storagexstream";

    /**
     * The header for message
     */
    public static final String MESSAGE_HEADER = "work_message";

    /**
     * The variable for message
     */
    public static final String MESSAGE_VARIABLE = "inJson";


    /**
     * The context compament name
     */
    public static final String CONTEXT_COMPANENT_NAME = "jms";
}
