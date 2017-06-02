package com.ttn.aem.mockito.demo.Model;

/**
 * Links class is a POJO class,contains the getters
 * and setters of MultiField Component
 * version 1.0
 */
public class MultiFieldLinks {

    private String linkTitle;
    private String linkUrl;
    private String target;
    private String icon;
    private String cssClass;

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
