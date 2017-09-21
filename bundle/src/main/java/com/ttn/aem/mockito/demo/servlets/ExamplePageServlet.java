package com.ttn.aem.mockito.demo.servlets;

import com.day.cq.wcm.api.Page;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.Iterator;

/**
 * Created by ttn on 31/5/17.
 */
@SlingServlet(paths = "/bin/myPageServlet", methods = "POST", metatype = true)
public class ExamplePageServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet {
    private static final long serialVersionUID = 2598426539166789515L;

    @Override
    public void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {

        try {
            String pagePath = request.getParameter("pagePath");
            Resource pageResource = request.getResourceResolver().getResource(pagePath);
            JSONArray array = new JSONArray();
            if (null != pageResource) {
                Page page = pageResource.adaptTo(Page.class);
                if (null != page) {
                    if (page.listChildren() != null) {
                        Iterator<Page> childPages = page.listChildren();

                        while (childPages.hasNext()) {
                            JSONObject obj = new JSONObject();
                            obj.put("PageTitle", childPages.next().getTitle());
                            array.put(obj);
                        }
                    }
                }
            }
            if (array.length() > 0) {
                response.setContentType("application/json");
                response.getWriter().write(array.toString());
            }
        } catch (Exception e) {
            response.getWriter().write("Exception Occured");
        }
    }
}