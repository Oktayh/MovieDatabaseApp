package com.example.moviedatabaseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<CustomModel> models;

    public CustomAdapter(List<CustomModel> models) {

        this.models = models;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.list_item,parent,false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.movie_name.setText(models.get(position).getName());
        holder.movie_genre.setText(models.get(position).getGenra());
        holder.movie_year.setText(String.valueOf(models.get(position).getYear()));

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView movie_name,movie_genre,movie_year;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            movie_name =(TextView) itemView.findViewById(R.id.txt_name);
            movie_genre = (TextView)itemView.findViewById(R.id.txt_genre);
            movie_year = (TextView)itemView.findViewById(R.id.txt_year);

        }
    }
}
