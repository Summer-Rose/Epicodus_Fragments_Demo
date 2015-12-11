package com.example.guest.fragmentapp.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guest.fragmentapp.R;
import com.example.guest.fragmentapp.adapters.StudentPagerAdapter;
import com.example.guest.fragmentapp.model.Student;
import com.parse.FindCallback;
import com.parse.ParseException;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StudentBioActivity extends AppCompatActivity {
    @Bind(R.id.vpPager) ViewPager mViewPager;
    StudentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_bio);
        ButterKnife.bind(this);

        Student.findAll(new FindCallback<Student>() {
            @Override
            public void done(List<Student> students, ParseException e) {

                int startingPosition = Integer.parseInt(getIntent().getExtras().getString("position"));
                adapterViewPager = new StudentPagerAdapter(getSupportFragmentManager(), students);
                mViewPager.setAdapter(adapterViewPager);
                mViewPager.setCurrentItem(startingPosition);
            }
        });
    }
}
