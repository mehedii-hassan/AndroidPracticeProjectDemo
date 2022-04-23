package com.example.retrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit retrofit;
    public static String BASE_URL = "https://services.hanselandpetal.com/";

    public static Retrofit getApiClient (){
        if(retrofit == null){
             retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit;
        }

        return retrofit;
    }
}
