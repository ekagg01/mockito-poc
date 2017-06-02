package com.ttn.aem.mockito.demo.components;

import com.adobe.cq.sightly.WCMUse;
import com.ttn.aem.mockito.demo.Model.HeroBannerModel;
import org.apache.sling.api.resource.Resource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by pooja on 13/2/17.
 */
public class CarouselComponent extends WCMUse {

    final String CAROUSEL_RESOURCE_TYPE = "invest-india/components/content/herobanner";

    private List<HeroBannerModel> carouselList = new ArrayList<HeroBannerModel>();

    @Override
    public void activate() throws Exception {
        Resource parsysResource = getResource().getChild("carouselParsys");

        if (parsysResource != null) {
            Iterator<Resource> parsysChildResources = parsysResource.listChildren();

            while (parsysChildResources.hasNext()) {
                Resource carouselResource = parsysChildResources.next();

                if (carouselResource.isResourceType(CAROUSEL_RESOURCE_TYPE)) {
                    carouselList.add(new HeroBannerModel(carouselResource));
                }
            }
        }
    }

    public List<HeroBannerModel> getCarouselList() {
        return carouselList;
    }
}
