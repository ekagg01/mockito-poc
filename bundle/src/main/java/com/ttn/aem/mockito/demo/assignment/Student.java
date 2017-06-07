package com.ttn.aem.mockito.demo.assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ttn on 7/6/17.
 */
public class Student {

    public String name;
    public String street;
    public String city;
    public List<String> subjects = new ArrayList<String>();

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public List<String> getSubjects() {
        return subjects;
    }
}
