package com.ttn.aem.mockito.demo;

import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.google.common.collect.ImmutableMap;
import com.ttn.aem.mockito.demo.servlets.IndustryTags;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.commons.json.JSONObject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by ttn on 26/5/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestIndustryTags {

    IndustryTags industryTags = new IndustryTags();

    @Rule
    public AemContext aemContext = new AemContext();
    @Mock
    public TagManager tagManager;

    @Mock
    public ResourceResolver resolver;

    Map<String, Object> propertiesMap = new HashMap<String, Object>();
    @Mock
    PrintWriter printWriter;

    Tag tag = mock(Tag.class);
    Tag tag1 = mock(Tag.class);
    Tag tag2 = mock(Tag.class);


    @Test
    public void testDoGet() throws Exception {
        SlingHttpServletRequest req = mock(SlingHttpServletRequest.class);
        SlingHttpServletResponse resp = mock(SlingHttpServletResponse.class);
        when(req.getResourceResolver()).thenReturn(resolver);
        when(resolver.adaptTo(TagManager.class)).thenReturn(tagManager);
        when(resolver.adaptTo(TagManager.class).resolve(anyString())).thenReturn(tag);
        Iterator<Tag> iterator = Mockito.mock(Iterator.class);
        when(tag.listChildren()).thenReturn(iterator);
        when(iterator.hasNext()).thenReturn(true, true, false);
        when(iterator.next()).thenReturn(tag1).thenReturn(tag2);
        when(tag1.getTitle()).thenReturn("Test");
        when(tag2.getTitle()).thenReturn("Test2");
        propertiesMap.put("text",tag1.getTitle());
        propertiesMap.put("value",tag1.getTitle());
        when(resp.getWriter()).thenReturn(printWriter);
        industryTags.doGet(req, resp);
        assertEquals(propertiesMap.size(),2);
        assertEquals(tag1.getTitle(), "Test");
        assertEquals(tag2.getTitle(), "Test2");
        assertNotNull(tag1.getTitle());
        assertNotNull(tag2.getTitle());
    }
}
