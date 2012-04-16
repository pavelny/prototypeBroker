/**
 *
 */
package com.copyright.rup.works.broker;


// TODO Add javadoc to type, variable and file
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
    public static final String BROKER_CLIENT_URL = "tcp://localhost:61616?jms.useAsyncSend=true";

    /**
     * Broker sleep
     */
    public static final int BROKER_SLEEP = 1000;

    /**
     *
     */
    public static final String BROKER_TMP_DATA_DIRECTORY = "./target";

    /**
     * This variable is used for generating
     */
    public static final int CHUNK_SIZE = 10;

    /**
     * The queue name for gson
     */
    public static final String CONSUMER_QUEUE_GSON = "jms:queue:storagegson";

    /**
     * The queue name for jackson
     */
    public static final String CONSUMER_QUEUE_JACKSON = "jms:queue:storagejackson";

    /**
     *
     */
    public static final String CONSUMER_QUEUE_JAXB = "jms:queue:storagejaxb";

    /**
     *
     */
    public static final String CONSUMER_QUEUE_THRIFT = "jms:queue:storagethrift";

    /**
     *
     */
    public static final String CONSUMER_QUEUE_XSTREM = "jms:queue:storagexstream";

    /**
     *
     */
    public static final String MESSAGE_HEADER = "work_message";

    /**
     *
     */
    public static final String MESSAGE_VARIABLE = "inJson";

    /**
     *
     */
    public static final String PRODUCER_QUEUE_GSON = "jms:queue:worksgson";

    /**
     *
     */
    public static final String PRODUCER_QUEUE_JACKSON = "jms:queue:worksjackson";

    /**
     *
     */
    public static final String PRODUCER_QUEUE_JAXB = "jms:queue:worksjaxb";

    /**
     *
     */
    public static final String PRODUCER_QUEUE_THRIFT = "jms:queue:worksthrift";

    /**
     *
     */
    public static final String PRODUCER_QUEUE_XSTREM = "jms:queue:worksxstream";

    /**
     *
     */
    public static final int WORKS_COLLECTION_SIZE = 100;

    /**
     *
     */
    public static final String CONTEXT_COMPANENT_NAME = "jms";
}
