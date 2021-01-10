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

public class mostItemAdapter extends RecyclerView.Adapter<mostItemAdapter.mostViewHolder> {
    ArrayList<feature_home_model> list = new ArrayList<>();

    public mostItemAdapter(ArrayList<feature_home_model> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public mostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new mostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewd, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull mostViewHolder holder, int position) {
        feature_home_model model=list.get(position);
        holder.txtview.setText(model.getText_name());
        holder.imageView.setImageResource(model.getImage());
        holder.des.setText(model.getText_des());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class mostViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView  txtview,des;
        public mostViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.mostViewed_image);
            txtview=itemView.findViewById(R.id.mostViewed_title);
            des=itemView.findViewById(R.id.most_viewed_desc);
        }
    }
}
