package com.example.retrofit.network;

import com.example.retrofit.models.PhotoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoServiceApi {
    @GET("photos")
    Call<List<PhotoModel>> getAllPhotos();
}
