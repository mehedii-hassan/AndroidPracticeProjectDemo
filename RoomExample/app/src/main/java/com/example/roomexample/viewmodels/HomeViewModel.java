package com.example.roomexample.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomexample.entities.Employee;
import com.example.roomexample.repository.EmployeeLocalRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {
    private EmployeeLocalRepository localRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        localRepository=new EmployeeLocalRepository(application);
    }
    public void addEmployee(Employee employee){
        localRepository.addEmployee(employee);
    }

    public void updateEmployee(Employee employee){
        localRepository.updateEmployee(employee);
    }
    public void deleteEmployee(Employee employee){
        localRepository.deleteEmployee(employee);
    }
    public LiveData<List<Employee>> getAllEmployees(){
        return localRepository.getEmployees();
    }
}