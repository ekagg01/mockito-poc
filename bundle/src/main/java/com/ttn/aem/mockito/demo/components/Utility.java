package com.ttn.aem.mockito.demo.components;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.ResourceResolver;

public class Utility {

    /**
     * This method returns pageTitle
     *
     * @param page
     * @return String pagetitle
     */
    public static String getPageTitle(Page page) {

        return StringUtils.isNotBlank(page.getNavigationTitle()) ? page.getNavigationTitle() :
                StringUtils.isNotBlank(page.getPageTitle()) ? page.getPageTitle() :
                        StringUtils.isNotBlank(page.getTitle()) ? page.getTitle() : page.getName();
    }

    /**
     * This method is use to check either its an external link or internal link
     *
     * @param url
     * @return boolean
     */
    public static boolean isExternalLink(String url) {
        if (StringUtils.isNotBlank(url) && (url.startsWith("http") || url.startsWith("https"))) {
            return true;
        }
        return false;
    }

    public static String addEllipsis(String string, int length) {
        if (null != string && string.length() > length) {
            string = string.substring(0, length) + "...";
        }
        return string;
    }

    public static String getPageTitle(ResourceResolver resourceResolver, String pagePath) {
        String title = "";

        if (StringUtils.isNotBlank(pagePath)) {
            Page page = resourceResolver.adaptTo(PageManager.class).getPage(pagePath);

		/*
		 * Check for a valid internal page when it might be appended with some parameters.
		 * In this case even a valid page would not resolve to a page via PageManager API.
		 * In this, we try to extract the page path (anything before ".html").
		 */
            if (page == null && StringUtils.startsWithIgnoreCase(pagePath, "/content/")) {
                pagePath = pagePath.split(".html")[0];
            }

            page = resourceResolver.adaptTo(PageManager.class).getPage(pagePath);

            if (page != null) {
                title = getPageTitle(page);
            } else {
                // As a fallback extract the page name to be returned as title
                title = pagePath.substring(pagePath.lastIndexOf("/") + 1, pagePath.length());
            }
        }

        return title;
    }
}