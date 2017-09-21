package com.ttn.aem.mockito.demo;

import com.ttn.aem.mockito.demo.service.AdminConsoleConfigService;
import io.wcm.testing.mock.aem.junit.AemContext;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.osgi.service.component.ComponentContext;

import java.util.Dictionary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by ttn on 24/5/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestAdminConsoleConfigService {


    @Mock
    ComponentContext componentContext;

    @Mock
    Dictionary<String, Object> dictionary;

    AdminConsoleConfigService adm= new AdminConsoleConfigService();
    @Test
    public void testActivate() throws Exception{
        when(componentContext.getProperties()).thenReturn(dictionary);
        when(componentContext.getProperties().get("api.endPoint")).thenReturn(new String("bnmnn"));
        adm.activate(componentContext);
        assertNotNull(adm.getAdminApiContext());
        assertEquals(adm.getAdminEndPointUrl(),"bnmnn");
        assertNotNull(adm.getAdminEndPointUrl());
        assertNotNull(adm.getCreateUserFormUrl());
        assertNotNull(adm.getForumDetailPage());
    }
}
