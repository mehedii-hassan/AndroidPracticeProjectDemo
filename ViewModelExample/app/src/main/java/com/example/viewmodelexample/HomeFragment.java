package com.example.viewmodelexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewmodelexample.databinding.FragmentHomeBinding;
import com.example.viewmodelexample.viewmodels.HomeViewModel;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //initialize dataBinding----------
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        //initialize viewModel-----------
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        //binding.tvName.setText(homeViewModel.getName());
        homeViewModel.getName().observe(getViewLifecycleOwner(), s -> {
            binding.tvName.setText(s);

        });
        binding.btnChange.setOnClickListener(view -> {
            final String name = binding.etNameInput.getText().toString();
            homeViewModel.setName(name);
            //binding.tvName.setText(homeViewModel.getName());

        });
        return binding.getRoot();

    }
}