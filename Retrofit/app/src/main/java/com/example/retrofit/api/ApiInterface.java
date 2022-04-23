package com.example.retrofit.api;

import com.example.retrofit.models.PhotoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("feeds/flowers.json")
    Call<List<PhotoModel>> getFlowerList();
}
