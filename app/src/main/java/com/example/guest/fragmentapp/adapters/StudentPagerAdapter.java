package com.example.guest.fragmentapp.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.guest.fragmentapp.Fragments.StudentBioFragment;
import com.example.guest.fragmentapp.model.Student;

import java.util.List;

/**
 * Created by Guest on 12/10/15.
 */
public class StudentPagerAdapter extends FragmentStatePagerAdapter {

    private List<Student> mStudents;
    private int mStartingPosition;

    public StudentPagerAdapter(FragmentManager fm, List<Student> students, int startingPosition) {
        super(fm);
        mStudents = students;
        mStartingPosition = startingPosition;
    }

    @Override
    public Fragment getItem(int i) {
        return StudentBioFragment.newInstance(mStudents.get(i));
    }

    @Override
    public int getCount() {
        return mStudents.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mStudents.get(position).getName();
    }
}
