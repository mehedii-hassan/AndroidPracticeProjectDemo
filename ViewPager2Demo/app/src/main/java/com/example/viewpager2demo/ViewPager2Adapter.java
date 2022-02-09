package com.example.viewpager2demo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.security.PrivateKey;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2Adapter.MyViewHolder> {

    private int[] images = {R.drawable.bird1, R.drawable.bird2, R.drawable.bird3, R.drawable.bird4, R.drawable.bird5};

    Context context;

    public ViewPager2Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewPager2Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.images_holder, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewPager2Adapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivId)
        AppCompatImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
