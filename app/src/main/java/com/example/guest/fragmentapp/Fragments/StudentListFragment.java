package com.example.guest.fragmentapp.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.fragmentapp.R;
import com.example.guest.fragmentapp.adapters.StudentAdapter;
import com.example.guest.fragmentapp.model.Student;
import com.parse.FindCallback;
import com.parse.ParseException;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StudentListFragment extends Fragment {

//    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
//    private StudentAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //ButterKnife.bind(this, container);

//        Student.findAll(new FindCallback<Student>() {
//            @Override
//            public void done(List<Student> students, ParseException e) {
//
//                mAdapter = new StudentAdapter(getActivity(), students);
//                mRecyclerView.setAdapter(mAdapter);
//
//                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//                mRecyclerView.setLayoutManager(layoutManager);
//
//                mRecyclerView.setHasFixedSize(true);
//            }
//        });
        return inflater.inflate(R.layout.fragment_student_list, container, false);
    }
}
