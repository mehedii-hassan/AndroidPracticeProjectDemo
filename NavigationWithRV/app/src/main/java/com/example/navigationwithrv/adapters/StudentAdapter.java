package com.example.navigationwithrv.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationwithrv.databinding.StudentRowBinding;
import com.example.navigationwithrv.models.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{

    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final StudentRowBinding binding = StudentRowBinding
                .inflate(LayoutInflater.from(parent.getContext())
                        ,parent,false);
        return new StudentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        final Student student = studentList.get(position);
        holder.bind(student);

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public  void submitNewList(List<Student> studentList){
        this.studentList  =studentList;
        notifyDataSetChanged();
    }


    class StudentViewHolder extends RecyclerView.ViewHolder {
        StudentRowBinding binding;
        public StudentViewHolder(StudentRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public  void bind(Student student){
            binding.tvStudentName.setText(student.getName());
            binding.tvCourseType.setText(student.getCourseType());
            binding.tvCourseName.setText(student.getCourseName());
        }
    }
}
