package com.ttn.aem.mockito.demo.service;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

import org.osgi.service.component.ComponentContext;

/**
 * Created by vikas on 15/3/17.
 */

@SuppressWarnings("deprecation")
@Component(immediate = true, metatype = true)
@Service(AdminConsoleConfigService.class)
public class AdminConsoleConfigService {

    private String adminEndPointUrl;
    private String adminApiContext;
    private String createUserFormUrl;
    private String forumDetailPage;

    @Property(description = "API End point")
    public static final String END_POINT = "api.endPoint";

    @Property(description = "API Context")
    public static final String API_CONTEXT = "api.context";

    @Property(description = "Form path for user creation")
    public  static final String CREATE_USER_FORM = "form.createUser";

    @Property(description = "Forum details Page path")
    public static final String FORUM_DETAIL_PAGE = "forum.details";

    @Activate
    public void activate(ComponentContext context) throws Exception {
        adminEndPointUrl = context.getProperties().get(END_POINT) != null ? context.getProperties().get(END_POINT).toString() : "";
        adminApiContext = context.getProperties().get(API_CONTEXT) != null ? context.getProperties().get(API_CONTEXT).toString() : "";
        createUserFormUrl = context.getProperties().get(CREATE_USER_FORM) != null ? context.getProperties().get(CREATE_USER_FORM).toString() : "";
        forumDetailPage = context.getProperties().get(FORUM_DETAIL_PAGE) != null ? context.getProperties().get(FORUM_DETAIL_PAGE).toString() : "";
    }

    public String getAdminEndPointUrl() {
        return adminEndPointUrl;
    }

    public String getAdminApiContext() {
        return adminApiContext;
    }

    public String getCreateUserFormUrl() {
        return createUserFormUrl;
    }

    public String getForumDetailPage() {
        return forumDetailPage;
    }

}




