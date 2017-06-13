package com.ttn.aem.mockito.demo.servlets;


import com.ttn.aem.mockito.demo.components.WeatherPrintingComponent;
import com.ttn.aem.mockito.demo.service.WeatherService;
import com.ttn.aem.mockito.demo.service.impl.WeatherServiceImpl;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by ttn on 6/6/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class WeatherTest {

    @Rule
    public AemContext aemContext = new AemContext();

    @Test
    public void activateTest() throws Exception{
        aemContext.registerService(WeatherService.class , new WeatherServiceImpl());
        WeatherPrintingComponent weatherPrintingComponent = aemContext.registerInjectActivateService(new WeatherPrintingComponent());
        assertEquals(weatherPrintingComponent.getCurrentWeather(),"38 Chello");
    }
}
