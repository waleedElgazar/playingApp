package com.example.playingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class userProfile extends AppCompatActivity {

    TextInputLayout name,password,email,phonee;
    FirebaseDatabase database;
    DatabaseReference reference;
    String dbName,dbPassword,dbEmail,dbPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_profile);
        name=findViewById(R.id.userName);
        password=findViewById(R.id.userPassword);
        email=findViewById(R.id.userEmail);
        phonee=findViewById(R.id.userPhone);
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("user");
        showUserData();

    }

    public void showUserData(){
        Intent intent=getIntent();
        dbEmail=intent.getStringExtra("email");
        dbName=intent.getStringExtra("name");
        dbPassword=intent.getStringExtra("password");
        dbPhone=intent.getStringExtra("phone");
        name.getEditText().setText(dbName);
        email.getEditText().setText(dbEmail);
        password.getEditText().setText(dbPassword);
        phonee.getEditText().setText(dbPhone);
    }

    public void update(View v){
        if(nameChanged()||passwordChanged()||emailChanged()||phoneChanged()){
            Toast.makeText(this, "data changed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "data hadn't been changed", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean phoneChanged() {
        if(!dbPhone.equals(phonee.getEditText().getText().toString())){
            phonee.setError("phone number can't be changed until now");
        }
        return false;
    }

    private boolean nameChanged() {
        if(!dbName.equals(name.getEditText().getText().toString())){
            reference.child(dbPhone).child("name").setValue(name.getEditText().getText().toString());
            return true;
        }
        return false;
    }

    private boolean passwordChanged() {
        if(!dbPassword.equals(password.getEditText().getText().toString())){
            reference.child(dbPhone).child("password").setValue(password.getEditText().getText().toString());
            return true;
        }
        return false;
    }

    private boolean emailChanged() {
        if(!dbEmail.equals(email.getEditText().getText().toString())){
            reference.child(dbPhone).child("email").setValue(email.getEditText().getText().toString());
            return true;
        }
        return false;
    }
}