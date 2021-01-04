package com.example.playingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String ephone,epassword,eemail,ename,erepassword;
    Animation top,down;
    ImageView imageView;
    TextView txt,txt1;
    LinearLayout linearLayout;
    TextInputLayout phone,password,email,name,rePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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
        password=findViewById(R.id.password);
        rePassword=findViewById(R.id.rePassword);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);

        rootNode=FirebaseDatabase.getInstance();
        reference=rootNode.getReference("user");

    }

    private boolean validateName(){
        String noWhiteSpace="\\A\\w{4,20}\\z";
        String val=name.getEditText().getText().toString();
        if (val.isEmpty()){
            name.setError("name can't be empty");
            return false;
        }else if(!val.matches(noWhiteSpace)){
            name.setError("invalid name");
            return false;
        } else{
            name.setError(null);
            return true;
        }
    }

    private boolean validatePassword(){
        String val=password.getEditText().getText().toString();
        String val1=rePassword.getEditText().getText().toString();
        if (!val.equals(val1)||val.isEmpty()||val1.isEmpty()){
            password.setError("password aren't same");
            rePassword.setError("password aren't same");
            return false;
        }else{
            password.setError(null);
            rePassword.setError(null);
            return true;
        }
    }

    private boolean validateEmail(){
        String regx="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String val=email.getEditText().getText().toString();
        if (val.isEmpty()){
            email.setError("email can't be empty");
            return false;
        }else if(!val.matches(regx)){
            email.setError("invalid email");
            return false;
        }else{
            email.setError(null);
            return true;
        }
    }

    private boolean validatePhone(){
        String val=phone.getEditText().getText().toString();
        if (val.isEmpty()){
            phone.setError("phone can't be empty");
            return false;
        }else{
            phone.setError(null);
            return true;
        }
    }

    public void register(View v){
        if(!validateName()||!validatePassword()||!validateEmail()){
            return;
        }
        epassword=password.getEditText().getText().toString();
        erepassword=rePassword.getEditText().getText().toString();
        ename=name.getEditText().getText().toString();
        ephone=phone.getEditText().getText().toString();
        eemail=email.getEditText().getText().toString();
        User user=new User(ename,eemail,ephone,epassword,erepassword);
        reference.child(ephone).setValue(user);
        Toast.makeText(this, "user "+user.toString(), Toast.LENGTH_SHORT).show();
    }

    public void haveAccount(View v){
        Intent intent=new Intent(this,login.class);
        startActivity(intent);
    }
}