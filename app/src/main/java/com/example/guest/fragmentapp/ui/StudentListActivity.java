package com.example.guest.fragmentapp.ui;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import com.example.guest.fragmentapp.R;
import com.example.guest.fragmentapp.adapters.StudentListAdapter;
import com.example.guest.fragmentapp.adapters.StudentPagerAdapter;
import com.example.guest.fragmentapp.model.Student;
import com.parse.FindCallback;
import com.parse.ParseException;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StudentListActivity extends FragmentActivity {

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private StudentListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        ButterKnife.bind(this);

        Student.findAll(new FindCallback<Student>() {
            @Override
            public void done(List<Student> students, ParseException e) {

                mAdapter = new StudentListAdapter(StudentListActivity.this, students);
                mRecyclerView.setAdapter(mAdapter);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(StudentListActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);

                mRecyclerView.setHasFixedSize(true);
            }
        });
    }
}
