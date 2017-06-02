package com.ttn.aem.mockito.demo.components;


import com.ttn.aem.mockito.demo.components.Utility;
import io.wcm.testing.mock.aem.junit.AemContext;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by ttn on 5/5/17.
 */
public class UtilityTest {

    @Rule
    public AemContext ctx = new AemContext();

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
        assertEquals("content", utility.getPageTitle(ctx.pageManager().getPage("/content")));

    }

    @Test
    public void testIsExternalLink(){
        assertEquals(utility.isExternalLink("http://www.facebook.com"),true);
        assertEquals(utility.isExternalLink("https://www.facebook.com"),true);
        assertEquals(utility.isExternalLink(""),false);
        assertNotEquals(utility.isExternalLink(null),true);
        assertEquals(utility.isExternalLink("qa.intelligrape.net/content/sih/en/test-home-page01.html"),false);
    }

    @Test
    public void testAddEllipsis(){
        assertEquals(utility.addEllipsis("Note that you must use @RunWith(MockitoJUnitRunner.class)", 2),"No...");
        assertNotNull(utility.addEllipsis("ghjk ghjk ghj",30));
        assertEquals(utility.addEllipsis("",0),"");
        assertNull(utility.addEllipsis(null,10));
    }

}
