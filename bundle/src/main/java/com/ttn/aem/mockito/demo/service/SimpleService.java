package com.ttn.aem.mockito.demo.service;

import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.ResourceResolver;

/**
 * Created by ttn on 31/5/17.
 */
public interface SimpleService {
    String PROP_NAME = "service-name";

    String helloWorld();

    void doWork(ResourceResolver resourceResolver) throws PersistenceException;
}