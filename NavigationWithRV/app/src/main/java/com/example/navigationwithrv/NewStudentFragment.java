package com.example.navigationwithrv;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.navigationwithrv.databinding.FragmentNewStudentBinding;
import com.example.navigationwithrv.models.Student;
import com.example.navigationwithrv.pickers.DatePickerDialogFragment;

import java.util.List;


public class NewStudentFragment extends Fragment {

    private FragmentNewStudentBinding binding;
    private String courseType = Student.SEIP;
    private List<String> courseList = Student.seipCourseList;
    private String courseName;


    public NewStudentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewStudentBinding.inflate(inflater, container, false);

        initAdapter();


        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                courseName = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        binding.courseTypeRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                final RadioButton radioButton = radioGroup.findViewById(i);
                courseType = radioButton.getText().toString().trim();

                switch (i) {
                    case R.id.rBtnPaid:
                        courseList = Student.paidCourseList;
                        break;
                    case R.id.rBtnSeip:
                        courseList = Student.seipCourseList;
                        break;
                }
                initAdapter();
            }

        });

        binding.btnSelectDate.setOnClickListener(view -> {
            new DatePickerDialogFragment().show(getChildFragmentManager(), null);
            getChildFragmentManager().setFragmentResultListener(
                    "result",
                    this, new FragmentResultListener() {
                        @Override
                        public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                            final String dateString = result.getString("date");
                            binding.btnSelectDate.setText(dateString);
                        }
                    }); 
        });


        binding.btnSelectTime.setOnClickListener(view -> {

        });

        binding.btnSubmit.setOnClickListener(view -> {
            final String name = binding.etStudentName.getText().toString().trim();
            final Student student = new Student(name, courseType, courseName);
            Student.studentList.add(student);
            Toast.makeText(getActivity(), "Successfully added " + Student.studentList.size(), Toast.LENGTH_SHORT).show();
            Navigation.findNavController(view).popBackStack();
        });
        return binding.getRoot();
    }

    private void initAdapter() {
        ArrayAdapter<String> courseListAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_dropdown_item_1line, courseList);
        binding.spinner.setAdapter(courseListAdapter);
    }


}