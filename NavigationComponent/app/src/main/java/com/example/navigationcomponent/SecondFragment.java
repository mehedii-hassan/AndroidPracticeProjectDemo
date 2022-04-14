package com.example.navigationcomponent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class SecondFragment extends Fragment {



    public SecondFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        String name = bundle.getString("name");
        int age = bundle.getInt("age");
        Toast.makeText(getContext(), " "+name+" "+age, Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_second, container, false);
    }
}