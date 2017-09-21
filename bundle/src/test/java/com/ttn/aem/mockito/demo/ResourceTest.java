package com.ttn.aem.mockito.demo;

import com.ttn.aem.mockito.demo.impl.ResourceResolverImpl;
import com.ttn.aem.mockito.demo.service.ResourceResolverService;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.apache.sling.testing.mock.sling.junit.SlingContext;
import org.apache.sling.testing.resourceresolver.MockResourceResolverFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by ttn on 18/9/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ResourceTest {

    @Rule
 	public SlingContext aemContext = new SlingContext(ResourceResolverType.RESOURCERESOLVER_MOCK);

   @Mock
    ResourceResolverFactory factory = new MockResourceResolverFactory();

    @Test
    public void testActivate() throws Exception{
        aemContext.registerService(factory);
        ResourceResolverService resolverService = aemContext.registerInjectActivateService(new ResourceResolverImpl());
        resolverService.getSystemResourceResolver();

    }
}
