package com.ttn.aem.mockito.demo.Model;

import java.util.List;

/**
 * Created by Jatin on 18/2/17.
 */
public class Blog {

    private String title;

    private String description;

    private String authorName;

    private String publishedDate;

    private String imageRef;

    private String pagePath;

    private String mobilePath;

    private List<String> blogContent;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageRef() {
        return imageRef;
    }

    public void setImageRef(String imageRef) {
        this.imageRef = imageRef;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getMobilePath() {
        return mobilePath;
    }

    public void setMobilePath(String mobilePath) {
        this.mobilePath = mobilePath;
    }

    public List<String> getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(List<String> blogContent) {
        this.blogContent = blogContent;
    }
}
