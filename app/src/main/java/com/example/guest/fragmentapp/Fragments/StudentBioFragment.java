package com.example.guest.fragmentapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.fragmentapp.R;
import com.example.guest.fragmentapp.model.Student;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StudentBioFragment extends Fragment {

    @Bind(R.id.studentNameTextView) TextView nameLabel;
    @Bind(R.id.courseTextView) TextView courseLabel;
    @Bind(R.id.bioTextView) TextView bioLabel;

    private String name;
    private String course;
    private String bio;

    public static StudentBioFragment newInstance(Student student) {
        StudentBioFragment studentBioFragment = new StudentBioFragment();
        Bundle args = new Bundle();
        args.putString("course", student.getCourse());
        args.putString("name", student.getFirstName() + " "+ student.getLastName());
        args.putString("bio", student.getBio());
        studentBioFragment.setArguments(args);
        return studentBioFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString("name");
        course = getArguments().getString("course");
        bio = getArguments().getString("bio");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_bio, container, false);
        ButterKnife.bind(this, view);
        nameLabel.setText(name);
        courseLabel.setText(course);
        bioLabel.setText(bio);
        return view;
    }


}
