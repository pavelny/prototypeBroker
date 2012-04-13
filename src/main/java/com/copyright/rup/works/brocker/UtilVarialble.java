/**
 *
 */
package com.copyright.rup.works.brocker;

/**
 * @author Andrei_Khadziukou
 *
 */
// TODO Add javadoc to type, variable and file
public abstract class UtilVarialble {

    /**
     *
     */
    public static final int BROKER_CAMEL_CONTEXT_SLEEP = 5 * 60 * 10000;

    /**
     * URL to local activeMq server
     */
    public static final String BROKER_CLIENT_URL = "tcp://localhost:61616";

    /**
     *
     */
    public static final int BROKER_SLEEP = 1000;

    /**
     *
     */
    public static final String BROKER_TMP_DATA_DIRECTORY = "./target";

    /**
     *
     */
    public static final String BROKER_URL = "tcp://localhost:61616";

    /**
     * This variable is used for generating
     */
    public static final int CHUNK_SIZE = 200;

    /**
     *
     */
    public static final String CONSUMER_QUEUE_GSON = "activemq:queue:storagegson";

    /**
     *
     */
    public static final String CONSUMER_QUEUE_JACKSON = "activemq:queue:storagejackson";

    /**
     *
     */
    public static final String CONSUMER_QUEUE_JAXB = "activemq:queue:storagejaxb";

    /**
     *
     */
    public static final String CONSUMER_QUEUE_THRIFT = "activemq:queue:storagethrift";

    /**
     *
     */
    public static final String CONSUMER_QUEUE_XSTREM = "activemq:queue:storagexstream";

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
    public static final String PRODUCER_QUEUE_GSON = "activemq:queue:worksgson";

    /**
     *
     */
    public static final String PRODUCER_QUEUE_JACKSON = "activemq:queue:worksjackson";

    /**
     *
     */
    public static final String PRODUCER_QUEUE_JAXB = "activemq:queue:worksjaxb";

    /**
     *
     */
    public static final String PRODUCER_QUEUE_THRIFT = "activemq:queue:worksthrift";

    /**
     *
     */
    public static final String PRODUCER_QUEUE_XSTREM = "activemq:queue:worksxstream";

    /**
     *
     */
    public static final int WORKS_COLLECTION_SIZE = 1000000;
}
