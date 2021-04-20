package com.example.moviedatabaseapp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.security.AccessController.getContext;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<CustomModel> models;
    Context context;

    public CustomAdapter( Context context, List<CustomModel> models) {
        this.context = context;
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
        holder.movie_status.setText(String.valueOf(models.get(position).getStatus()));
        GradientDrawable magnitudeCircle = (GradientDrawable) holder.movie_img.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int Color = getColor(context);
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(Color);

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView movie_name,movie_genre,movie_year,movie_img,movie_status;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            movie_status = (TextView) itemView.findViewById(R.id.status);
            movie_name =(TextView) itemView.findViewById(R.id.txt_name);
            movie_genre = (TextView)itemView.findViewById(R.id.txt_genre);
            movie_year = (TextView)itemView.findViewById(R.id.txt_year);
            movie_img = (TextView) itemView.findViewById(R.id.imageView2);

        }
    }
    private int getColor(Context context) {

        int ColorResourceId;
        Random rn = new Random();
        int answer = rn.nextInt(6);
        switch (answer) {
            case 0:
                ColorResourceId = R.color.color_circle5;
                break;
            case 1:
                ColorResourceId = R.color.color_circle1;
                break;
            case 2:
                ColorResourceId = R.color.color_circle2;
                break;
            case 3:
                ColorResourceId = R.color.color_circle3;
                break;
            case 4:
                ColorResourceId = R.color.color_circle4;
                break;
            default:
                ColorResourceId = R.color.purple_200;
                break;
        }

        return ContextCompat.getColor(context,ColorResourceId);
    }
}
