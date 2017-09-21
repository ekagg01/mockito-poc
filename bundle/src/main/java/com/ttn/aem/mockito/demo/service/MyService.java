package com.ttn.aem.mockito.demo.service;

import com.ttn.aem.mockito.demo.Model.Blog;
import org.apache.sling.api.resource.ResourceResolver;

import javax.jcr.RepositoryException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
     * Created by Jatin on 18/2/17.
     */
    public interface MyService {

        List<Blog> getBlogList(Map predicateMap, ResourceResolver resourceResolver) throws RepositoryException, ParseException;
    }
