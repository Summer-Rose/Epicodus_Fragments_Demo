package com.example.guest.fragmentapp.ui;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.guest.fragmentapp.Fragments.StudentListFragment;
import com.example.guest.fragmentapp.R;
import com.example.guest.fragmentapp.adapters.StudentAdapter;
import com.example.guest.fragmentapp.model.Student;
import com.parse.FindCallback;
import com.parse.ParseException;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StudentsActivity extends FragmentActivity {

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private StudentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        ButterKnife.bind(this);

        Student.findAll(new FindCallback<Student>() {
            @Override
            public void done(List<Student> students, ParseException e) {

                mAdapter = new StudentAdapter(StudentsActivity.this, students);
                mRecyclerView.setAdapter(mAdapter);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(StudentsActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);

                mRecyclerView.setHasFixedSize(true);
            }
        });

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            StudentListFragment firstFragment = new StudentListFragment();

            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }
}
