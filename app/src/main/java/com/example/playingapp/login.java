package com.example.playingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    private static final String TAG = "login";
    Animation top,down;
    ImageView imageView;
    TextView txt,txt1;
    LinearLayout linearLayout;
    TextInputLayout name,pass;
    String userName,password;
    DatabaseReference reference;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        top= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        down= AnimationUtils.loadAnimation(this,R.anim.down_anim);
        imageView=findViewById(R.id.logo_img);
        txt=findViewById(R.id.welcome);
        txt1=findViewById(R.id.signTxt);
        linearLayout=findViewById(R.id.linLayout);
        imageView.setAnimation(top);
        txt.setAnimation(top);
        txt1.setAnimation(top);
        linearLayout.setAnimation(down);

        name=findViewById(R.id.username);
        pass=findViewById(R.id.userPass);


    }

    public void loginUser(View view){
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("user");
        userName=name.getEditText().getText().toString();
        password=pass.getEditText().getText().toString();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.child(userName).exists()){
                    User user=snapshot.child(userName).getValue(User.class);
                    if (password.equals(user.getPassword())){
                        Intent intent=new Intent(getApplicationContext(),userProfile.class);
                        intent.putExtra("phone",userName);
                        startActivity(intent);
                    }else{
                        Toast.makeText(login.this, "password wrond", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(login.this, "user not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void register(View view){
        Intent intent=new Intent(this,register.class);
        startActivity(intent);
    }
}