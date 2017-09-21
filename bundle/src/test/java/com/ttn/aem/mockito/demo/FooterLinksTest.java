package com.ttn.aem.mockito.demo;

import com.day.cq.wcm.api.Page;
import com.ttn.aem.mockito.demo.components.FooterLinks;
import com.ttn.aem.mockito.demo.components.Utility;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ttn on 31/5/17.
 */
public class FooterLinksTest {
    @Rule
    public AemContext aemContext= new AemContext();
    Resource resource = mock(Resource.class);
    private FooterLinks footerLinks = new FooterLinks(){
       @Override
        public Resource getResource() {
            return resource;
        };
    };



    @Before
    public void setUp(){
        aemContext.load().json("/json-import-samples/content.json", "/content/sample/sih");


    }


    @Test
    public void testActivateWithLinks() throws Exception{
        when(footerLinks.getResource().adaptTo(ValueMap.class)).thenReturn(aemContext.resourceResolver().getResource("/content/sample/sih/jcr:content/linklist_1").getValueMap());
        footerLinks.activate();
        assertNotNull(footerLinks.getLinksList());
    }
    @Test
    public void testActivateWithLink() throws Exception{
        when(footerLinks.getResource().adaptTo(ValueMap.class)).thenReturn(aemContext.resourceResolver().getResource("/content/sample/sih/jcr:content/linklist_2").getValueMap());
        footerLinks.activate();
        assertNotNull(footerLinks.getLinksList());
    }

}
