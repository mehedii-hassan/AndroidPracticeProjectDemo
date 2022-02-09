package com.example.recyclerviewtutorialproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerviewtutorialproject.MyAdapter;
import com.example.recyclerviewtutorialproject.R;
import com.example.recyclerviewtutorialproject.models.UserData;
import com.example.recyclerviewtutorialproject.repository.UserListRepository;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private MyAdapter myAdapter;
    private List<UserData> userLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list_activity);
        ButterKnife.bind(this);

        userLists = new ArrayList<>();
        userLists = UserListRepository.getInstance().getUserList();
        setupRecyclerView();
    }


    private void setupRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        myAdapter = new MyAdapter(this, userLists);
        recyclerView.setAdapter(myAdapter);
    }

}