package com.example.guest.fragmentapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.fragmentapp.R;
import com.example.guest.fragmentapp.model.Student;
import com.example.guest.fragmentapp.ui.StudentBioActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 12/9/15.
 */
public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder> {

    private List<Student> mStudents;
    private Context mContext;

    public StudentListAdapter(Context context, List<Student> students) {
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

    public class StudentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.nameTextView) TextView mNameTextView;
        @Bind(R.id.courseTextView) TextView mCourseTextView;

        public StudentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            mContext = itemView.getContext();
        }

        public void bindStudent(Student student) {
            mNameTextView.setText(student.getFirstName() + " " + student.getLastName());
            mCourseTextView.setText(student.getCourse());
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, StudentBioActivity.class);
            intent.putExtra("position", Integer.toString(itemPosition));
            mContext.startActivity(intent);
        }
    }
}
