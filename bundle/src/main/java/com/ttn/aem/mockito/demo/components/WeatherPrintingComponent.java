package com.ttn.aem.mockito.demo.components;

import com.ttn.aem.mockito.demo.service.WeatherService;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

@Component(
        label = "Compute Patterns - Weather details printing osgi component.",
        description = "Sample OSGi component that uses thread and a OSGi service to print weather details in log."
        )
public class WeatherPrintingComponent {
    private static final Logger log = LoggerFactory.getLogger(WeatherPrintingComponent.class);

    /* Yahoo weather api end point */
    private static final String weatherApiEndpoint =
            "http://weather.yahooapis.com/forecastrss?p=80020&u=f";

    @Reference
    WeatherService weatherService;

    @Activate
    public void activate(Map<String, String> config) {
        log.info("Weather printing component - activiated");
        try {
            log.info(weatherService.getWeatherFeed(weatherApiEndpoint)+"hello");
        } catch (IOException e) {
            log.error("Unable to get weather details.", e);
        }
    }

    public String getCurrentWeather() throws IOException{
        return weatherService.getWeatherFeed(weatherApiEndpoint)+"hello";
    }
}