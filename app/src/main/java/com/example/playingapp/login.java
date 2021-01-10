package com.example.playingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
    String userName,password,userPassword,userEmail,userPhone;
    DatabaseReference reference;
    FirebaseDatabase database;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        checkBox=findViewById(R.id.rememberCheckedBox);
        name=findViewById(R.id.username);
        pass=findViewById(R.id.userPass);


    }

    public void loginUser(View view){
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("user");
        userPhone=name.getEditText().getText().toString();
        password=pass.getEditText().getText().toString();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.child(userPhone).exists()){
                    User user=snapshot.child(userPhone).getValue(User.class);
                    if (password.equals(user.getPassword())){
                        Intent intent=new Intent(getApplicationContext(),userDashBoard.class);
                        //////////instead of passing it to user profile directly send it to dashboard
                        intent.putExtra("phone",userPhone);
                        intent.putExtra("name",user.getName());
                        intent.putExtra("email",user.getEmail());
                        intent.putExtra("password",user.getPassword());
                        startActivity(intent);
                    }else{
                        Toast.makeText(login.this, "password wrong", Toast.LENGTH_SHORT).show();
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

    public void checkRemember(View view) {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    SharedPreferences sharedPreferences=getSharedPreferences("checkBox",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("remember","true");
                    editor.apply();
                }else{
                    SharedPreferences sharedPreferences=getSharedPreferences("checkBox",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("remember","false");
                    editor.apply();
                }
            }
        });
    }
}