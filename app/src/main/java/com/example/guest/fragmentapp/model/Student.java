package com.example.guest.fragmentapp.model;

import com.parse.FindCallback;
import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by Guest on 12/9/15.
 */
@ParseClassName("Student")
public class Student extends ParseObject{
    public Student() {};

    public Student(String firstName, String lastName, String course, String bio) {
        put("first_name", firstName);
        put("last_name", lastName);
        put("course", course);
        put("bio", bio);
    }

    public static void findAll(FindCallback<Student> callback) {
        ParseQuery<Student> query = ParseQuery.getQuery(Student.class);
        query.addAscendingOrder("first_name");
        query.findInBackground(callback);
    }

    public String getFirstName() {
        return getString("first_name");
    }

    public void setFirstName(String name) {
        put("first_name", name);
    }

    public String getLastName() {
        return getString("last_name");
    }

    public void setLastName(String name) {
        put("last_name", name);
    }

    public String getCourse() {
        return getString("course");
    }

    public void setCourse(String course) {
        put("course", course);
    }

    public String getBio() {
        return getString("bio");
    }

    public void setBio(String bio) {
        put("bio", bio);
    }
}
