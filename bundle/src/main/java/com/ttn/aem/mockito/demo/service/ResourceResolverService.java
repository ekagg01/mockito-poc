package com.ttn.aem.mockito.demo.service;

import org.apache.sling.api.resource.ResourceResolver;

/**
 * This interface has functions declared to get resource resolver of a particular service.
 */
public interface ResourceResolverService {
    /**
     * This method will fetch resource resolver of Newsfeed.
     * User associated with this resolver is 'adminSystemUser'
     * @return ResourceResolver
     */
    ResourceResolver getSystemResourceResolver();

    /**
     * This method will fetch resource resolver of trending posts.
     * User associated with this resolver is 'trendingPostsService'
     * @return ResourceResolver
     */
    ResourceResolver fetchPostsResourceResolver();
}


