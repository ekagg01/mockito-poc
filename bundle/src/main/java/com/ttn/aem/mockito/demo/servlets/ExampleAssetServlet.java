package com.ttn.aem.mockito.demo.servlets;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.commons.util.AssetReferenceSearch;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import java.io.IOException;
import java.util.Map;

/**
 * Created by ttn on 31/5/17.
 */


@SlingServlet(resourceTypes="cq/Page", selectors="references", extensions="json", methods="GET")
public class ExampleAssetServlet extends SlingSafeMethodsServlet {

    private static final String DAM_ROOT = "/content/dam";

    private static Logger LOG = LoggerFactory.getLogger(ExampleAssetServlet.class);

    @Override
    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        try {
            JSONObject jsonOut = new JSONObject();
            Node jcrNode = request.getResource().adaptTo(Node.class);

            if (jcrNode == null) {
                response.getOutputStream().print(new JSONObject().toString());
                return;
            }

            // let's use the specialized assetReferenceSearch, which does all the work for us

            AssetReferenceSearch search = new AssetReferenceSearch
                    (jcrNode, DAM_ROOT, request.getResourceResolver());
            Map<String,Asset> result = search.search();


            for (String key: result.keySet()) {
                Asset asset = result.get(key);
                JSONObject assetDetails = new JSONObject();
                assetDetails.put("path", asset.getPath());
                assetDetails.put("mimetype", asset.getMimeType());

                jsonOut.put(asset.getName(), assetDetails);
            }
            response.getOutputStream().print(jsonOut.toString(2));
        }  catch (JSONException e) {
            // print empty JSON
            LOG.error ("Cannot serialize JSON",e);
            response.getOutputStream().print(new JSONObject().toString());
        }
    } // doGet

}