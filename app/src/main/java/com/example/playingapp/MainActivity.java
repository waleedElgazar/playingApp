package com.example.playingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Animation top,down;

    TextView txt;
    ImageView img;

    private static int SPLASH_SCREEN=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        top= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        down= AnimationUtils.loadAnimation(this,R.anim.down_anim);

        txt=findViewById(R.id.txt);
        img=findViewById(R.id.img);


        img.setAnimation(top);
        txt.setAnimation(down);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }

}/*
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    EditText phone,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password=findViewById(R.id.loginPassword);
        phone=findViewById(R.id.loginPhone);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("user");
    }

    public void register(View v){
        Intent intent=new Intent(MainActivity.this,register.class);
        startActivity(intent);
    }

    public void login(View v){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.child(phone.getText().toString()).exists()){
                    User user=snapshot.child(phone.getText().toString()).getValue(User.class);
                    if (user.getPassword().equals(password.getText().toString())){
                        Toast.makeText(MainActivity.this, "login", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "password wrond", Toast.LENGTH_SHORT).show();
                    }
                }else{

                    Toast.makeText(MainActivity.this, "user not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}*/