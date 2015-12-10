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

    public Student(String name, String course, String bio) {
        put("name", name);
        put("course", course);
        put("bio", bio);
    }

    public static void findAll(FindCallback<Student> callback) {
        ParseQuery<Student> query = ParseQuery.getQuery(Student.class);
        query.findInBackground(callback);
    }

    public String getName() {
        return getString("name");
    }

    public void setName(String name) {
        put("name", name);
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
