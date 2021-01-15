package com.example.playingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class forget_password extends AppCompatActivity {

    TextInputLayout userPhone;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password2);
        userPhone=findViewById(R.id.userPhone);
    }

    public void makeSelection(View view) {
        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference reference=database.getReference("user");
        phone=userPhone.getEditText().getText().toString();
        Intent intent=new Intent(getApplicationContext(),makeCelection.class);
        intent.putExtra("phone",phone);
        startActivity(intent);
    }
}