package com.copyright.rup.works.brocker;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class WorksProcessor implements Processor {

    public WorksProcessor() {
    }

    public void process(Exchange exchange) throws Exception {

//        String work_message = (String) exchange.getIn().getBody();
//        System.out.println(work_message);
        exchange.getOut();
    }

}
