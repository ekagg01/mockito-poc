/*
package com.ttn.aem.mockito.demo.components;

import com.ttn.aem.mockito.demo.assignment.Student;
import com.ttn.aem.mockito.demo.assignment.StudentDetail;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

*/
/**
 * Created by ttn on 7/6/17.
 *//*

public class StudentDetailTest {

    Student stu = mock(Student.class);

    StudentDetail studentDetail = new StudentDetail();

    @Test
    public void getStudentAddressTest(){
        when(stu.getName()).thenReturn("Ekta Aggarwal");
        when(stu.getStreet()).thenReturn("Sec 127");
        when(stu.getCity()).thenReturn("Noida");
        assertNotNull(studentDetail.getStudentAddress(stu));
        assertEquals(studentDetail.getStudentAddress(stu),"Ekta Aggarwal , Sec 127 , Noida");
    }

    @Test
    public void getStudentSubjectListTest(){

        List<String> expectedArray = new ArrayList<String>();
        expectedArray.add("Maths");
        expectedArray.add("Physics");
        expectedArray.add("Chemistry");

        List<String> subjects = new ArrayList<String>();
        subjects.add("Maths");
        subjects.add("Physics");
        assertEquals(studentDetail.getSubjectList(stu).size(),0);
        when(stu.getSubjects()).thenReturn(subjects);
        assertEquals(studentDetail.addSubject(stu,"Chemistry"),expectedArray);
        assertEquals(stu.getSubjects().size(),3);
    }
}
*/
