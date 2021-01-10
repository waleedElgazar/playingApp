package com.example.playingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.playingapp.Adapters.categoryAdapter;
import com.example.playingapp.Adapters.featureAdapter;
import com.example.playingapp.Adapters.feature_home_model;
import com.example.playingapp.Adapters.mostItemAdapter;

import java.util.ArrayList;

public class userDashBoard extends AppCompatActivity {

    RecyclerView feature_RecyclerView,mostItemRecycler,categoryRecycler;
    RecyclerView.Adapter  adapter,mostAdapter,categoryAdapter;
    ArrayList<feature_home_model>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dash_board);
        feature_RecyclerView=findViewById(R.id.feature_recycler);
        mostItemRecycler=findViewById(R.id.mostItem_recycler);
        categoryRecycler=findViewById(R.id.categoryRecycler);
        list=new ArrayList<>();
        feelData();
        featureRecylerView();
        mostRecylerView();
        categoryReclyerView();
    }
    public void feelData(){
        list.add(new feature_home_model(R.drawable.screen,"phone","1"));
        list.add(new feature_home_model(R.drawable.screen,"books","books dsfsdf"));
        list.add(new feature_home_model(R.drawable.screen,"resturants","phones dsfsdf"));
        list.add(new feature_home_model(R.drawable.screen,"cards","phones dsfsdf"));

    }

    private void featureRecylerView() {
        feature_RecyclerView.setHasFixedSize(true);
        feature_RecyclerView.setLayoutManager(
                new LinearLayoutManager(this,
                        LinearLayoutManager.HORIZONTAL,false));
        adapter=new featureAdapter(list);
        feature_RecyclerView.setAdapter(adapter);

    }

    public void mostRecylerView(){
        mostItemRecycler.setHasFixedSize(true);
        mostItemRecycler.setLayoutManager(
                new LinearLayoutManager(this,
                        LinearLayoutManager.HORIZONTAL,false)
        );
        mostAdapter=new mostItemAdapter(list);
        mostItemRecycler.setAdapter(mostAdapter);

    }
    public void categoryReclyerView(){
        categoryRecycler.setHasFixedSize(true);
        categoryRecycler.setLayoutManager(
                new LinearLayoutManager(this,
                        LinearLayoutManager.HORIZONTAL,false)
        );
        categoryAdapter=new categoryAdapter(list);
        categoryRecycler.setAdapter(categoryAdapter);
    }
    public void goProfile(View view) {
        /////////////////// here get intent from login with name and password and return it to userprofile
        Intent intent=new Intent(this,userProfile.class);
        startActivity(intent);
    }
}