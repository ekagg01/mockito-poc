package com.ttn.aem.mockito.demo;


import com.day.cq.wcm.api.PageManager;
import com.ttn.aem.mockito.demo.components.Utility;
import io.wcm.testing.mock.aem.junit.AemContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.ResourceResolver;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by ttn on 5/5/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestUtility {

    @Rule
    public AemContext ctx = new AemContext();
    @Mock
    private ResourceResolver resolver;
    @Mock
    private PageManager pageManager;

    Utility utility=new Utility();


    @Before
    public void setUp() throws Exception{

        ctx.pageManager().
                create("/", "content", "/apps/my/templates/home", "");
        ctx.pageManager().
                create("/content", "welcome", "/apps/my/templates/hello", "Welcome");

    }

    @Test
    public void testGetPageTitle() throws Exception{
        utility.getPageTitle(ctx.pageManager().getPage("/content"));
        assertNotNull(utility.getPageTitle(ctx.pageManager().getPage("/content")));
        assertEquals("content", utility.getPageTitle(ctx.pageManager().getPage("/content")));

    }

}
