package com.example.guest.fragmentapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.guest.fragmentapp.R;
import com.example.guest.fragmentapp.model.Student;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.nameEditText) EditText mNameEditText;
    @Bind(R.id.courseEditText) EditText mCourseEditText;
    @Bind(R.id.bioEditText) EditText mBioEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        findViewById(R.id.addStudentButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameEditText.getText().toString();
                String course = mCourseEditText.getText().toString();
                String bio = mBioEditText.getText().toString();
                Student newStudent = new Student(name, course, bio);
                newStudent.saveInBackground();
                Intent intent = new Intent(MainActivity.this, StudentListActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.viewAllButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudentListActivity.class);
                startActivity(intent);
            }
        });
    }
}
