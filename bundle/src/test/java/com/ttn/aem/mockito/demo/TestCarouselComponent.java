package com.ttn.aem.mockito.demo;

import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.google.common.collect.ImmutableMap;
import com.ttn.aem.mockito.demo.components.CarouselComponent;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ttn on 22/5/17.
 */


public class TestCarouselComponent {

    Resource resource = mock(Resource.class);
    @Rule
    public AemContext aemContext= new AemContext();

    SlingScriptHelper slingScriptHelper = mock(SlingScriptHelper.class);

    QueryBuilder qb= mock(QueryBuilder.class);
    CarouselComponent carouselComponent = new CarouselComponent(){
        @Override
        public Resource getResource() {
            return resource;
        };
        @Override
        public SlingScriptHelper getSlingScriptHelper() {
            return slingScriptHelper;
        };


    };

    @Before
    public void setUp() {

        // Building Sample data
        aemContext.create().resource("/content/sih/en/home-page/jcr:content/local_header/carousel_wrap/carouselParsys", ImmutableMap.<String, Object>builder()
                .put("sling:resourceType", "wcm/foundation/components/parsys")
                .build());
        aemContext.create().resource("/content/sih/en/home-page/jcr:content/local_header/carousel_wrap/carouselParsys/herobanner", ImmutableMap.<String, Object>builder()
                .put("sling:resourceType", "invest-india/components/content/herobanner")
                .build());
        aemContext.registerService(QueryBuilder.class);
        aemContext.create().resource("/content/sih/en/home-page/jcr:content/local_header/carousel_wrap/carouselParsys/herobanner_1057529355", ImmutableMap.<String, Object>builder()
                .put("sling:resourceType", "invest-india/components/content/herobanner")
                .build());
        when(carouselComponent.getSlingScriptHelper().getService(QueryBuilder.class)).thenReturn(qb);
       //Loading JSON

        /* aemContext.load().json("/json-import-samples/content.json", "/content/sample/sih"); */

       when(carouselComponent.getResource().getChild(Mockito.anyString())).thenReturn(aemContext.resourceResolver().getResource("/content/sih/en/home-page/jcr:content/local_header/carousel_wrap/carouselParsys"));
        //when(carouselComponent.getResource().getChild(Mockito.anyString())).thenReturn(aemContext.resourceResolver().getResource("/content/sample/sih/jcr:content/carousel/contentParsys"));

    }
    @Test
    public void testGetCarouselList() throws Exception{
        carouselComponent.activate();
        assertNotNull(carouselComponent.getCarouselList().size());
        assertEquals(carouselComponent.getCarouselList().size(),2);
    }

    @Test
    public void testGetHeroBannerPath() throws Exception{
        carouselComponent.activate();
        assertTrue(carouselComponent.getCarouselList().size()>0);
        assertNotNull(carouselComponent.getCarouselList().get(0).getHeroBannerPath());
       // assertEquals(carouselComponent.getCarouselList().get(0).getHeroBannerPath(),"/content/sample/sih/jcr:content/carousel/contentParsys/herobanner");
        assertEquals(carouselComponent.getCarouselList().get(0).getHeroBannerPath(),"/content/sih/en/home-page/jcr:content/local_header/carousel_wrap/carouselParsys/herobanner");
    }
}
