package com.test.movie_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.test.movie_app.R;
import com.test.movie_app.model.Movie;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<Movie> movieList;

    public RecyclerViewAdapter(Context context, ArrayList<Movie> dataList){
        this.context = context;
        this.movieList = dataList;
    }


    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.movie_row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Movie movie  = movieList.get(position);
        String title = movie.getMovie_title();
        int attendance = movie.getMovie_attendance();
        String genre = movie.getMovie_genre();
        String year = movie.getMovie_year();

        holder.card_title.setText(title);
        holder.card_year.setText(year);
        holder.card_genre.setText(genre);
        holder.card_attendance.setText(""+attendance);


    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView card_title;
        public TextView card_genre;
        public TextView card_attendance;
        public TextView card_year;

        public ViewHolder(@Nullable View itemView){
            super(itemView);

            card_attendance = itemView.findViewById(R.id.card_attendance);
            card_genre = itemView.findViewById(R.id.card_genre);
            card_title = itemView.findViewById(R.id.card_title);
            card_year = itemView.findViewById(R.id.card_year);


        }
    }
}