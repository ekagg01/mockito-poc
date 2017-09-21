package com.ttn.aem.mockito.demo.components.primarynavigation;

import org.apache.jackrabbit.api.JackrabbitSession;
import org.apache.jackrabbit.api.security.user.User;
import org.apache.jackrabbit.api.security.user.UserManager;
import org.apache.jackrabbit.commons.JcrUtils;

import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

/**
 * Created by ttn on 19/6/17.
 */
public class Test {

    public static void main(String[] args) {

        try{
            Repository repository = JcrUtils.getRepository("http://localhost:4502/crx/server");
            Session session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()), "crx.default");

            JackrabbitSession js = (JackrabbitSession) session;
            final UserManager userManager = js.getUserManager();
            final User user = userManager.createUser("userName", "ekta");
            session.save();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {

        }

    }
}