package com.ttn.aem.mockito.demo;

import com.ttn.aem.mockito.demo.components.FinalClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

/**
 * Created by ttn on 30/5/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestFinalClass {

    @Test
    public final void mockFinalClassTest() {
        FinalClass instance = new FinalClass();

        FinalClass mock = Mockito.mock(FinalClass.class);
        when(mock.finalMethod()).thenReturn("something");

        assertEquals(mock.finalMethod(), instance.finalMethod());
    }


}
