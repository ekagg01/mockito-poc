/*
package com.ttn.aem.mockito.demo;

import com.ttn.aem.mockito.demo.impl.WeatherPrintingComponent;
import com.ttn.aem.mockito.demo.impl.WeatherServiceImpl;
import com.ttn.aem.mockito.demo.service.WeatherService;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.apache.sling.testing.mock.sling.junit.SlingContext;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

*/
/**
 * Created by ttn on 6/6/17.
 *//*

@RunWith(MockitoJUnitRunner.class)
public class WeatherTest {

    @Rule
    public SlingContext aemContext = new SlingContext(ResourceResolverType.RESOURCERESOLVER_MOCK);


    Map _config;

    @Mock
    WeatherService weatherService = new WeatherServiceImpl();


    @Before
    public void setUp(){
        _config = new HashMap<Object, Object>();
        _config.put("test1", "test1");
        _config.put("test2", "test3");

    }
    @Test
    public void activateTest() throws Exception{
        aemContext.registerService(weatherService);
        WeatherPrintingComponent weatherPrintingComponent = aemContext.registerInjectActivateService(new WeatherPrintingComponent(),_config);

        assertEquals(weatherPrintingComponent.getCurrentWeather(),"38 Chello");
        //when(weatherService.getWeatherFeed(anyString())).thenReturn("test");
        //comp.activate(_config);
        //assertEquals(comp.getCurrentWeather(),"testhello");
    }
}*/
