package com.example.playingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class userProfile extends AppCompatActivity {

    TextInputEditText edtName,edtPassword,edtEmail,edtPhone;
    TextInputLayout name,password,email,phonee;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        name=findViewById(R.id.userName);
        password=findViewById(R.id.userPassword);
        email=findViewById(R.id.userEmail);
        phonee=findViewById(R.id.userPhone);
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("user");
        String phone=getIntent().getStringExtra("phone");
        edtName=findViewById(R.id.usrname);
        edtEmail=findViewById(R.id.usrEmail);
        edtPhone=findViewById(R.id.usrPhone);
        edtPassword=findViewById(R.id.usrPassword);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user=snapshot.child(phone).getValue(User.class);
                edtName.setText(user.getName());
                edtEmail.setText(user.getEmail());
                edtPassword.setText(user.getPassword());
                edtPhone.setText(user.getPhone());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}