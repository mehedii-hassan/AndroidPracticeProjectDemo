package com.example.recyclerviewtutorialproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewtutorialproject.models.UserData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    //private List<ChatList> userChatList;
    private List<UserData> userLists;

    public MyAdapter(Context context, List<UserData> userLists) {
        this.context = context;
        this.userLists = userLists;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //  View view = LayoutInflater.from(context).inflate(R.layout.row_item_design,parent,false);
        //  return new MyViewHolder(view);
        View view = LayoutInflater.from(context).inflate(R.layout.row_item_user, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        /*ChatList chatList = userChatList.get(position);
        holder.imageView.setImageResource(chatList.getImageView());
        holder.textView1.setText(chatList.getTextView1());
        holder.textView2.setText(chatList.getTextView2());
        holder.textView2.setText(chatList.getTextView3());
        holder.textView2.setText(chatList.getTextView4());*/

        UserData userData = userLists.get(position);
        holder.txtViewName.setText(userData.getName());
        holder.txtViewAge.setText(userData.getAge());
        holder.txtViewPhone.setText(userData.getPhone());


    }

    @Override
    public int getItemCount() {
        return userLists.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {


       /* @BindView(R.id.imageView)
        ImageView imageView;

        @BindView(R.id.textView1)
        TextView textView1;
        @BindView(R.id.textView2)
        TextView textView2;

        @BindView(R.id.textView3)
        TextView textView3;
        @BindView(R.id.textView4)
        TextView textView4;*/

        @BindView(R.id.txtViewName)
        TextView txtViewName;

        @BindView(R.id.txtViewAge)
        TextView txtViewAge;

        @BindView(R.id.txtViewPhone)
        TextView txtViewPhone;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
