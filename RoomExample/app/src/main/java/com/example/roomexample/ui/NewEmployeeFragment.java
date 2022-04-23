package com.example.roomexample.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.roomexample.R;
import com.example.roomexample.databinding.FragmentNewEmployeeBinding;
import com.example.roomexample.db.EmployeeDatabase;
import com.example.roomexample.entities.Employee;
import com.example.roomexample.viewmodels.HomeViewModel;


public class NewEmployeeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentNewEmployeeBinding binding;
    private int id = 0;

    public NewEmployeeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //initialize homeViewModel ---------------
        homeViewModel = new ViewModelProvider(requireActivity())
                .get(HomeViewModel.class);
        //initialize dataBinding-------------------
        binding = FragmentNewEmployeeBinding.inflate(inflater, container, false);

        //receive safeArgs
        final Employee employee = NewEmployeeFragmentArgs
                .fromBundle(getArguments())
                .getEmployee();

        if (employee != null) {
            id = employee.getId();
            binding.etEmployeeName.setText(employee.getName());
            binding.etSalary.setText(String.valueOf(employee.getSalary()));
            binding.btnSave.setText("UPDATE");
        }
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnSave.setOnClickListener(v -> {
            final String name = binding.etEmployeeName.getText().toString().trim();
            final double salary = Double.parseDouble(binding.etSalary.getText().toString().trim());
            if (id > 0) {
                //update employee-----------
                final Employee emp = new Employee(id, name, salary);
                homeViewModel.updateEmployee(emp);
            } else {
                //addNew employee---------------
                final Employee employee = new Employee(name, salary);
                //EmployeeDatabase.getDb(getActivity()).getEmployeeDao().insertEmployee(employee);
                homeViewModel.addEmployee(employee);
            }
            Toast.makeText(getActivity(), "Successfully inserted", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(view).popBackStack();

        });
    }
}