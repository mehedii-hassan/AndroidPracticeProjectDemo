package com.example.recyclerviewtutorialproject.repository;

import com.example.recyclerviewtutorialproject.models.UserData;

import java.util.ArrayList;
import java.util.List;

public class UserListRepository {

    private static UserListRepository userListRepository;

    public static  UserListRepository getInstance(){
        if(userListRepository == null){
            userListRepository = new UserListRepository();
        }

        return userListRepository;
    }

    private List<UserData> userLists = new ArrayList<>();

    public List<UserData> getUserList(){
        return userLists;
    }

    public void setUserData(UserData userData){
        userLists.add(userData);
    }
}
