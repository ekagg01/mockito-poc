package com.ttn.aem.mockito.demo;

import com.ttn.aem.mockito.demo.servlets.ExampleServlet;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.commons.io.Charsets;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * Created by ttn on 31/5/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleServletTest {

    @Mock
    public PrintWriter writer;
    ExampleServlet exampleServlet;

    @Rule
    public AemContext aemContext = new AemContext();

    @Before
    public void setUp() {
        exampleServlet = new ExampleServlet();
        aemContext.response().setCharacterEncoding("UTF-8");
    }
    @Test
    public void TestDoPost() throws IOException{
        aemContext.request().setQueryString("firstName=ekta&lastName=aggarwal&address=test address");
        exampleServlet.doPost(aemContext.request(),aemContext.response());
        assertEquals(aemContext.response().getContentType(),"application/json;charset=UTF-8");
        assertEquals(aemContext.response().getOutputAsString(),"{\"firstname\":\"ekta\",\"lastname\":\"aggarwal\",\"address\":\"test address\"}");
        }

    @Test
    public void TestDoPostWithNull() throws IOException{
        exampleServlet.doPost(aemContext.request(),aemContext.response());
        assertNull(aemContext.response().getContentType());
        assertEquals(aemContext.response().getOutputAsString(),"");
    }
    }
