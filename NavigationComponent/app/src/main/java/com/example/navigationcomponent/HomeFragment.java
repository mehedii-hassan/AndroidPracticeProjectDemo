package com.example.navigationcomponent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationcomponent.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //initialize binding object
        binding = FragmentHomeBinding.inflate(inflater);


        binding.btnNext.setOnClickListener(view -> {
            String name = binding.etName.getText().toString();
            int age = Integer.parseInt(binding.etAge.getText().toString());
            String ob = new String("Hi, i am mehedi hassan.");


            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            bundle.putInt("age", age);

            //Navigation.findNavController(view).navigate(R.id.secondFragment, bundle);
            Navigation.findNavController(view).navigate(R.id.profileAction, bundle);
        });

        return binding.getRoot();

    }
}