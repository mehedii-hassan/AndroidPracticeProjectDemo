package com.example.recyclerviewtutorialproject.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerviewtutorialproject.MyAdapter;
import com.example.recyclerviewtutorialproject.R;
import com.example.recyclerviewtutorialproject.models.UserData;
import com.example.recyclerviewtutorialproject.repository.UserListRepository;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class UserActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.editTextName)
    EditText editTextName;

    @BindView(R.id.editTextAge)
    EditText editTextAge;

    @BindView(R.id.editTextPhone)
    EditText editTextPhone;

    private String name;
    private int age;
    private int phone;
    private UserListRepository userListRepository;
    private AlertDialog.Builder alertDialogBuilder;
    private AlertDialog alertDialog;


    @OnClick(R.id.btnSubmit)
    public void onButtonClick(){
       //setAlertDialog();

        name = editTextName.getText().toString().trim();
        age = Integer.parseInt(editTextAge.getText().toString().trim());
        phone = Integer.parseInt(editTextPhone.getText().toString().trim());

        userListRepository = new UserListRepository();
        userListRepository.setUserData(new UserData(name, age,phone));
        Toast.makeText(this, ""+userListRepository.getUserList().size(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(UserActivity.this, UserListActivity.class));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);
        ButterKnife.bind(this);

    }

    private void setAlertDialog() {
        alertDialogBuilder = new AlertDialog.Builder(UserActivity.this);

        //for setting title----------
        alertDialogBuilder.setTitle("Alert title");

        //for setting message----------
        alertDialogBuilder.setMessage("Do you want to submit ?");

        //for setting icon--------
        alertDialogBuilder.setIcon(R.drawable.questionmark);

        //set positive button--------
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        //set negative button----------
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        //set neutral button----------
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        //create alert dialog------------
        alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}