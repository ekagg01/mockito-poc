package com.ttn.aem.mockito.demo.service.impl;


import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.ttn.aem.mockito.demo.Model.Blog;
import com.ttn.aem.mockito.demo.components.Utility;
import com.ttn.aem.mockito.demo.service.MyService;
import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.text.ParseException;
import java.util.*;

/**
 * Created by Jatin on 18/2/17.
 */
@SuppressWarnings("deprecation")
@Component(immediate = true, enabled = true)
@Service(MyService.class)
public class MyServiceImpl implements MyService {

    private static final String BLOG_COMPONENT = "blogcomponent";


    @Reference
    private QueryBuilder queryBuilder;
    public void setQueryBuilder(QueryBuilder queryBuilder) {
        this.queryBuilder = queryBuilder;
    }

    public List<Blog> getBlogList(Map predicateMap, ResourceResolver resourceResolver) throws RepositoryException, ParseException {
        List<Blog> blogList = new ArrayList<Blog>();
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        Query searchQuery = queryBuilder.createQuery(PredicateGroup.create(predicateMap), resourceResolver.adaptTo(Session.class));
        SearchResult results = searchQuery.getResult();
        Iterator<Node> nodes = results.getNodes();
        if (nodes != null) {
            while (nodes.hasNext()) {
                Node node = nodes.next();
                Page blogPage = pageManager.getPage(node.getPath());
                Blog blog = adaptToBlog(blogPage, resourceResolver);
                if (blog != null) {
                    blogList.add(blog);
                }
            }
        }
        return blogList;
    }

    private Blog adaptToBlog(Page blogPage, ResourceResolver resourceResolver) throws ParseException {
        Resource contentResource = blogPage.getContentResource();
        Resource blogResource = contentResource.getChild(BLOG_COMPONENT);
        if (blogResource != null) {
            ValueMap valueMap = blogResource.getValueMap();
            Blog blog = new Blog();
            blog.setPagePath(blogPage.getPath() + ".html");
            blog.setMobilePath(blogPage.getPath() + ".detail.json");
            blog.setTitle(valueMap.get("blogTitle", Utility.addEllipsis(blogPage.getTitle(), 40)));

            String des = valueMap.get("blogdescription", StringUtils.EMPTY);

            blog.setDescription(Utility.addEllipsis(des, 80));

            blog.setAuthorName(valueMap.get("authorName", StringUtils.EMPTY));
            return blog;
        }
        return null;
    }

}
