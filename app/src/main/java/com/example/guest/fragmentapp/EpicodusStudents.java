package com.example.guest.fragmentapp;

import android.app.Application;

import com.example.guest.fragmentapp.model.Student;
import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by Guest on 12/9/15.
 */
public class EpicodusStudents extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(Student.class);
        Parse.initialize(this, this.getString(R.string.parse_application_id), this.getString(R.string.parse_client_key));

    }
}
