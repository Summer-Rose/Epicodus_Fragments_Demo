package com.example.guest.fragmentapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.fragmentapp.R;
import com.example.guest.fragmentapp.model.Student;

import java.util.List;

/**
 * Created by Guest on 12/9/15.
 */
public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> mStudents;
    private Context mContext;

    public StudentAdapter(Context context, List<Student> students) {
        mContext = context;
        mStudents = students;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_list_item, viewGroup, false);
        StudentViewHolder viewHolder = new StudentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StudentViewHolder studentViewHodler, int i) {
        studentViewHodler.bindStudent(mStudents.get(i));
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        public TextView mNameTextView;
        public TextView mCourseTextView;

        public StudentViewHolder(View itemView) {
            super(itemView);

            mNameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            mCourseTextView = (TextView) itemView.findViewById(R.id.courseTextView);
        }

        public void bindStudent(Student student) {
            mNameTextView.setText(student.getName());
            mCourseTextView.setText(student.getCourse());
        }
    }
}
