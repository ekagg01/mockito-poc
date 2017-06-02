package com.ttn.aem.mockito.demo.Model;

import org.apache.sling.api.resource.Resource;

/**
 * This model class represents individual hero banner component path.
 */
public class HeroBannerModel {

    //resource path
    private String heroBannerPath;


    public HeroBannerModel(Resource resource) {
        heroBannerPath = resource.getPath();
    }

    public String getHeroBannerPath() {
        return heroBannerPath;
    }
}
