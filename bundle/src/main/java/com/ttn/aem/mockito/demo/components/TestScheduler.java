package com.ttn.aem.mockito.demo.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Property;

@Component
@Service(value = Runnable.class)
@Property( name = "scheduler.period", longValue = 20)
public class TestScheduler implements Runnable {

    /**
     * Default log.
     */
    long count =0;
    public void run() {
        System.out.println("Executing a cron job (job#1) through the whiteboard pattern"+count+1);
    }
//
}