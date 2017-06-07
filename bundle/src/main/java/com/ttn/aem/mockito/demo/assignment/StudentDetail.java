package com.ttn.aem.mockito.demo.assignment;

import com.ttn.aem.mockito.demo.assignment.Student;

import java.util.List;

/**
 * Created by ttn on 7/6/17.
 */
public class StudentDetail {

    public String getStudentAddress(Student stu) {
        return stu.getName() + " , " + stu.getStreet() + " , " + stu.getCity();
    }

    public List<String> getSubjectList(Student stu) {
        return stu.getSubjects();
    }

    public List<String> addSubject(Student stu, String subject) {
        stu.getSubjects().add(subject);
        return stu.getSubjects();
    }
}
