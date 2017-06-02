package com.ttn.aem.mockito.demo.service.impl;

import com.ttn.aem.mockito.demo.service.impl.SimpleServiceImpl;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ttn on 31/5/17.
 */
public class SimpleServiceImplTest {
    @InjectMocks
    SimpleServiceImpl simpleService;
    @Rule
    public AemContext aemContext= new AemContext();
    @Mock
    ResourceResolver resolver;

    @Mock
    public PropertiesUtil propertiesUtil;
    Map<String,String> properties;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        aemContext.load().json("/json-import-samples/content.json", "/content/sample/sih");
        properties = new HashMap<String, String>();
        properties.put("world","Mars");

    }

    @Test
    public void testHelloWorld() throws Exception {
        String expectedHelloWorld = "Hello earth!";
        assertEquals(expectedHelloWorld, simpleService.helloWorld());
    }

    @Test
    public void testDoWork() throws Exception {
        when(resolver.getResource(anyString())).thenReturn(aemContext.resourceResolver().getResource("/content/sample/sih/jcr:content/linklist_2"));
        simpleService.doWork(resolver);
        verify(resolver).commit();
    }

   @Test
    public void testActivate() throws Exception {
        when(resolver.getResource(anyString())).thenReturn(aemContext.resourceResolver().getResource("/content/sample/sih/jcr:content/linklist_2"));
        simpleService.activate(properties);
       assertEquals("Hello Mars!", simpleService.helloWorld());
    }

}
