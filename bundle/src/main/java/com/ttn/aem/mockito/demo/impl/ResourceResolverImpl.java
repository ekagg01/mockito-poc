package com.ttn.aem.mockito.demo.impl;

import com.ttn.aem.mockito.demo.service.ResourceResolverService;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

@Component(immediate = true, name = "Admin resource resolver")
@Service
public class ResourceResolverImpl implements ResourceResolverService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Reference
    private ResourceResolverFactory resourceFactory;

    public ResourceResolver getSystemResourceResolver() {
        ResourceResolver resourceResolver = null;
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put(ResourceResolverFactory.SUBSERVICE, "writeService");
            resourceResolver = resourceFactory.getServiceResourceResolver(paramMap);
        } catch (LoginException e) {
            log.error("Login Exception : " + e);
        }
        return resourceResolver;
    }

    public ResourceResolver fetchPostsResourceResolver() {
        ResourceResolver resourceResolver = null;
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put(ResourceResolverFactory.SUBSERVICE, "trendingPostsService");
            resourceResolver = resourceFactory.getServiceResourceResolver(paramMap);
        } catch (LoginException e) {
            log.error("Login Exception : " + e);
        }
        return resourceResolver;
    }
}


