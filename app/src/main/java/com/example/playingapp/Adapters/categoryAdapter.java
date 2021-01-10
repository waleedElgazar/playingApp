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

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.categoryViewHolder> {
    ArrayList<feature_home_model> list = new ArrayList<>();

    public categoryAdapter(ArrayList<feature_home_model> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new categoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull categoryViewHolder holder, int position) {
        feature_home_model category=list.get(position);
        holder.title.setText(category.getText_name());
        holder.imge.setImageResource(category.getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class categoryViewHolder extends RecyclerView.ViewHolder {
        ImageView imge;
        TextView title;
        public categoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imge=itemView.findViewById(R.id.category_image);
            title=itemView.findViewById(R.id.category_txt);
        }
    }
}
