package com.ttn.aem.mockito.demo.service.impl;

import com.ttn.aem.mockito.demo.service.WeatherService;
import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * Weather service implementation. Connects to the provided end point using apache http client to
 * fetch the feed.
 *
 */
@Component(label = "Compute Patterns - Weather Service.",
        description = "Connects to the weather apis and fetches weather details.")

@Service
public class WeatherServiceImpl implements WeatherService {
    private static final Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);
    public String getWeatherFeed(String apiEndPoint) throws IOException {
        // Sanity check the arguments.
        if (StringUtils.isBlank(apiEndPoint)) {
            return StringUtils.EMPTY;
        }else {
            String temprature = "38 C";
            return temprature;
        }
        }
    }
