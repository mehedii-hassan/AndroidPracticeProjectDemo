package com.example.roomexample.ui;


import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.roomexample.R;
import com.example.roomexample.adapters.EmployeeAdapter;
import com.example.roomexample.callback.EmployeeDeleteListener;
import com.example.roomexample.callback.EmployeeEditListener;
import com.example.roomexample.databinding.HomeFragmentBinding;
import com.example.roomexample.entities.Employee;
import com.example.roomexample.viewmodels.HomeViewModel;

public class HomeFragment extends Fragment implements EmployeeEditListener, EmployeeDeleteListener {

    private HomeFragmentBinding binding;
    private HomeViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = HomeFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding.fabNewEmployee.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_homeFragment_to_newEmployeeFragment));

        final EmployeeAdapter employeeAdapter = new EmployeeAdapter(this);
        binding.employeeRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.employeeRV.setAdapter(employeeAdapter);

        mViewModel.getAllEmployees().observe(getViewLifecycleOwner(), employees -> {
            employeeAdapter.submitNewList(employees);
            Toast.makeText(getActivity(), "numberOfEmployes " + employees.size(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onDeleteListener(Employee employee) {
        Toast.makeText(getActivity(), employee.getName(), Toast.LENGTH_SHORT).show();
        showAlertDialog(employee);
    }

    private void showAlertDialog(Employee employee) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Delete " + employee.getName() + " ?");
        builder.setMessage("Are you sure to delete this employee");
        builder.setIcon(R.drawable.ic_baseline_delete_24);
        builder.setPositiveButton("Yes", (dialogInterface, i) -> {
            mViewModel.deleteEmployee(employee);
        });
        builder.setNegativeButton("No", null);
        final AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onEditEmployee(Employee employee) {
         HomeFragmentDirections.ActionHomeFragmentToNewEmployeeFragment action =
                  HomeFragmentDirections.actionHomeFragmentToNewEmployeeFragment();
        action.setEmployee(employee);
        Navigation.findNavController(getActivity(),R.id.navHostFragment).navigate(action);

    }
}