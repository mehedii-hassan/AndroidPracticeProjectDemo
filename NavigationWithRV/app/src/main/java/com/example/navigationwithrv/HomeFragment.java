package com.example.navigationwithrv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationwithrv.adapters.StudentAdapter;
import com.example.navigationwithrv.databinding.FragmentHomeBinding;
import com.example.navigationwithrv.models.Student;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private StudentAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater);

        adapter = new StudentAdapter(Student.studentList);
        final LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(RecyclerView.VERTICAL);

        binding.rvStudent.setLayoutManager(llm);
        binding.rvStudent.setAdapter(adapter);

        binding.fabNewCourse.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.newStudentAction);
        });
        return binding.getRoot();


    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.submitNewList(Student.studentList );

    }
}