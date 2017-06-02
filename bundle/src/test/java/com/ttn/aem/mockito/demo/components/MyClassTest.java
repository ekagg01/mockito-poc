package com.ttn.aem.mockito.demo.components;

import com.ttn.aem.mockito.demo.components.MyClass;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ttn on 1/6/17.
 */
public class MyClassTest {

    MyClass classTest = new MyClass();
  /*  @BeforeClass
    public static void setupBeforeClass(){
        System.out.println("Start of test class");
    }

    @Before
    public void setup(){
        System.out.println("starttime :"+ System.currentTimeMillis());
    }*/

    @Test
    public void testMultiply(){
        assertEquals("10 x 5 must be 50", 50, classTest.multiply(10, 5));
        assertEquals("10 x 0 must be 0", 0, classTest.multiply(10, 0));
        assertEquals("10 x 0 must be 0", 0, classTest.multiply(10, 0));
        assertNotNull(classTest.multiply(10, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrown() {
        classTest.multiply(1000, 5);
    }

   /* @After
    public void tearDown(){
        System.out.println("endTime :"+ System.currentTimeMillis());
    }

    @AfterClass
    public static void tearDownAfterClass(){
        System.out.println("End of test class");
    }*/
}
