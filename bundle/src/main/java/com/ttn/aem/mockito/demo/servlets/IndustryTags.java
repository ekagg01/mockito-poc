package com.ttn.aem.mockito.demo.servlets;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This class is used for creating json of industry tags
 *
 * @version 1.0
 */
@SlingServlet(paths = "/bin/sih/tags/industry", methods = "GET")
public class IndustryTags extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(SlingHttpServletRequest request,
                         SlingHttpServletResponse response) throws ServletException,
            IOException {
        JSONArray tagJsonArray = new JSONArray();
        ResourceResolver resolver = request.getResourceResolver();
        TagManager tagMgr = resolver.adaptTo(TagManager.class);
        Tag tag = tagMgr.resolve("/etc/tags/geometrixx-outdoors/activity");

        if (null != tag) {
            Iterator<Tag> tagItr = tag.listChildren();

            while (tagItr.hasNext()) {
                Map<String, Object> propertiesMap = new HashMap<String, Object>();
                String industryName = tagItr.next().getTitle();
                propertiesMap.put("text", industryName);
                propertiesMap.put("value", industryName);
                JSONObject tagObject = new JSONObject(propertiesMap);
                tagJsonArray.put(tagObject);
            }
        }

        response.setContentType("application/json");
        response.getWriter().write(tagJsonArray.toString());
    }
}