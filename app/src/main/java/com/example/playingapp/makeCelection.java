package com.example.playingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class makeCelection extends AppCompatActivity {

    private static final String TAG = "this";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_celection);
    }

    public void sendByPhoneNumber(View view) {
        String phone=getIntent().getStringExtra("phone");
        Log.d(TAG, "sendByPhoneNumber: "+phone);
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+2" + phone,
                60,
                TimeUnit.SECONDS,
                makeCelection.this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(makeCelection.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(@NonNull String verification, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        Intent intent=new Intent(getApplicationContext(),verify_opt.class);
                        intent.putExtra("verification",verification);
                        startActivity(intent);
                    }
                }
        );
    }
}