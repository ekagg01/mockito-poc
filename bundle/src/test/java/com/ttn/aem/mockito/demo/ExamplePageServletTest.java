package com.ttn.aem.mockito.demo;

import com.ttn.aem.mockito.demo.servlets.ExamplePageServlet;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.sling.api.resource.Resource;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by ttn on 1/6/17.
 */
public class ExamplePageServletTest {

    ExamplePageServlet pageServlet = new ExamplePageServlet();

    @Rule
    public AemContext aemContext = new AemContext();

    @Before
    public void setUp(){
        aemContext.load().json("/json-import-samples/content.json", "/content/sample/sih");
        aemContext.request().setQueryString("pagePath=/content/sample/sih");
        aemContext.response().setCharacterEncoding("UTF-8");
    }

    @Test
    public void testDoPost()throws IOException{
        pageServlet.doPost(aemContext.request(),aemContext.response());
        assertEquals(aemContext.response().getContentType(),"application/json;charset=UTF-8");
        assertEquals(aemContext.response().getOutputAsString(),"[{\"PageTitle\":\"Blog List\"},{\"PageTitle\":\"Toolbar\"}]");
    }



}
