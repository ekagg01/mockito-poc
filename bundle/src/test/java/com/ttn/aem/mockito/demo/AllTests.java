package com.ttn.aem.mockito.demo;

import com.ttn.aem.mockito.demo.components.MyClassTest;
import com.ttn.aem.mockito.demo.components.CarouselComponentTest;
import com.ttn.aem.mockito.demo.components.FinalClassTest;
import com.ttn.aem.mockito.demo.components.UtilityTest;
import com.ttn.aem.mockito.demo.service.AdminConsoleConfigService;
import com.ttn.aem.mockito.demo.service.impl.AdminConsoleConfigServiceTest;
import com.ttn.aem.mockito.demo.service.impl.SimpleServiceImplTest;
import com.ttn.aem.mockito.demo.servlets.ExampleServletTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by ttn on 1/6/17.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        FinalClassTest.class,
        CarouselComponentTest.class,
        MyClassTest.class,
        UtilityTest.class,
        SimpleServiceImplTest.class,
        AdminConsoleConfigServiceTest.class,
        ExampleServletTest.class

})

public class AllTests {

}