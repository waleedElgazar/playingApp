package com.example.playingapp.Adapters;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playingapp.R;

import java.util.ArrayList;
import java.util.List;

public class featureAdapter extends RecyclerView.Adapter<featureAdapter.featureViewHolder> {
    ArrayList<feature_home_model> list = new ArrayList<>();

    public featureAdapter(ArrayList<feature_home_model> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public featureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.feature_cardview,parent,false);
        featureViewHolder featureViewHolder=new featureViewHolder(view);
        return  featureViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull featureViewHolder holder, int position) {
        feature_home_model feature_home_model=list.get(position);
        holder.imageView.setImageResource(feature_home_model.getImage());
        holder.txt_name.setText(feature_home_model.getText_name());
        holder.txt_desc.setText(feature_home_model.getText_des());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class featureViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txt_name,txt_desc;
        public featureViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.feature_image);
            txt_name=itemView.findViewById(R.id.feature_title);
            txt_desc=itemView.findViewById(R.id.feature_desc);
        }
    }
}
