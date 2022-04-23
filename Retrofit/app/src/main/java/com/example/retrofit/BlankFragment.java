package com.example.retrofit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.retrofit.models.PhotoModel;
import com.example.retrofit.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RetrofitService.getService().getAllPhotos()
                .enqueue(new Callback<List<PhotoModel>>() {
                    @Override
                    public void onResponse(Call<List<PhotoModel>> call, Response<List<PhotoModel>> response) {
                        if(response.code() == 200){
                            final List<PhotoModel> photoModels = response.body();
                            Toast.makeText(getActivity(), " "+photoModels.size(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<PhotoModel>> call, Throwable t) {

                    }
                });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
}