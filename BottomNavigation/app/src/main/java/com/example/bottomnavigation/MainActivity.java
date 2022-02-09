package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.flFragmentContainer);
        bottomNavigationView = findViewById(R.id.bnviewId);

       /* bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
             *//*   FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();*//*
                switch (item.getItemId()) {

                    *//*case R.id.miHome:
                        fragmentTransaction.replace(R.id.flFragmentContainer, new FirstFragment());
                        break;*//*
                    case R.id.miMessage:
                        replaceFragment(new SecondFragment());
                        break;
                    case R.id.miNotification:
                        replaceFragment(new ThirdFragment());
                        break;
                }
                return true;
                //return true;
            }
        });*/

    bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.miHome:
                        replaceFragment(new FirstFragment());
                        break;
                    case R.id.miMessage:
                        replaceFragment(new SecondFragment());
                        break;
                    case R.id.miNotification:
                        replaceFragment(new ThirdFragment());
                        break;
                }
                return true;
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragmentContainer, fragment);
        fragmentTransaction.commit();
    }
}