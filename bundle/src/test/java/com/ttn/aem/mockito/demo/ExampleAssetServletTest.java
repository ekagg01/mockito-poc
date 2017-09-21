package com.ttn.aem.mockito.demo;

import com.ttn.aem.mockito.demo.servlets.ExampleAssetServlet;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by ttn on 31/5/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleAssetServletTest {
    @Rule
    public AemContext context = new AemContext();

    @InjectMocks
   ExampleAssetServlet exampleAssetServlet;

    private final static String ASSETS_SAMPLE = "/images/404-img.jpg";
    private static final String DAM_ROOT = "/content/dam";
    private Resource resource;

    @Mock
    private MockSlingHttpServletRequest request;

    @Mock
    private MockSlingHttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        context.load().json("/json-import-samples/dam.json", "/content/dam/sample");
        resource = context.resourceResolver().getResource("/content/dam/sample/portraits/scott_reynolds.jpg");
        request.setMethod(HttpConstants.METHOD_GET);
        when(request.getResource()).thenReturn(resource);
        response = new MockSlingHttpServletResponse();
    }

    @Test
    public void testDoGet() throws Exception {
        exampleAssetServlet.doGet(request, response);
        assertEquals("application/json", response.getContentType());
    }
}