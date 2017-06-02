package com.ttn.aem.mockito.demo.components;

import com.adobe.cq.sightly.WCMUse;
import com.ttn.aem.mockito.demo.Model.MultiFieldLinks;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a WCMUSePojo class, used for creating Footer component
 *
 * @version 1.0
 */
public class FooterLinks extends WCMUse {

    private List<MultiFieldLinks> linksList;
    private static final Logger LOG = LoggerFactory
            .getLogger(FooterLinks.class);

    /**
     * This is the default method of WCMUsePojo class
     *
     * @throws Exception
     */
    @Override
    public void activate() throws Exception {
        ValueMap footerMap = getResource().adaptTo(ValueMap.class);
        if (footerMap.containsKey(ApplicationConstants.LINKS)) {
            createLinksList(footerMap);
        }
    }

    /**
     * Creates a list of Multifield Links for URl and Name from links property
     *
     * @param footerMap
     * @return
     */
    private void createLinksList(ValueMap footerMap) {
        try {

            String[] linksPropertyValue;
            linksList = new ArrayList<MultiFieldLinks>();
            Object footerLinks = footerMap.get(ApplicationConstants.LINKS);

            if (footerLinks instanceof String[]) {
                linksPropertyValue = (String[]) footerLinks;
            } else {
                linksPropertyValue = new String[1];
                linksPropertyValue[0] = footerLinks.toString();
            }

            for (int i = 0; i < linksPropertyValue.length; i++) {

                MultiFieldLinks mfLinks = new MultiFieldLinks();
                JSONObject linkObj = new JSONObject(linksPropertyValue[i]);
                String linkUrl = linkObj
                        .getString(ApplicationConstants.MFLINKURL);
                if (Utility.isExternalLink(linkUrl)) {
                    mfLinks.setTarget(ApplicationConstants.TARGET);
                    mfLinks.setLinkUrl(linkUrl);
                } else {
                    mfLinks.setLinkUrl(linkUrl + ApplicationConstants.HTML);
                }

                    mfLinks.setLinkTitle(linkObj
                            .getString(ApplicationConstants.MFLINKTITLE));

                linksList.add(mfLinks);
            }

        } catch (JSONException e) {
            LOG.warn(
                    "JSONException while accessing the JSONObject of multifield",
                    e);
        }
    }

    /**
     * This method returns the list of url and corresponding labels for Footer.
     *
     * @return he list of url and corresponding labels
     */
    public List<MultiFieldLinks> getLinksList() {
        return linksList;
    }

}