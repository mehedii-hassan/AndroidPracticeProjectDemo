package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofit.models.PhotoModel;
import com.example.retrofit.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitService.getService().getAllPhotos()
                .enqueue(new Callback<List<PhotoModel>>() {
                    @Override
                    public void onResponse(Call<List<PhotoModel>> call, Response<List<PhotoModel>> response) {
                        if(response.code() == 200){
                            final List<PhotoModel> photoModels = response.body();
                            Toast.makeText( MainActivity.this, " "+photoModels.size(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<PhotoModel>> call, Throwable t) {
                        Toast.makeText( MainActivity.this, " "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();


                    }
                });
    }
}