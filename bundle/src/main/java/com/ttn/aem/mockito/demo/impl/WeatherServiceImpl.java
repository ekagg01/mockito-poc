package com.ttn.aem.mockito.demo.impl;

import java.io.IOException;
import java.util.Map;

import com.ttn.aem.mockito.demo.service.WeatherService;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang.StringUtils;
/**
 * Weather service implementation. Connects to the provided end point using apache http client to
 * fetch the feed.
 *
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    private static final Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);
  /*  @Activate
    public void activate(Map<String, String> config) {
        log.info("Weather Service - ACTIVATED");
    }*/
    public String getWeatherFeed(String apiEndPoint) throws IOException {
        // Sanity check the arguments.
        if (StringUtils.isBlank(apiEndPoint)) {
            return StringUtils.EMPTY;
        }
        String temprature = "38 C" ;
            return temprature;
        }
    }
