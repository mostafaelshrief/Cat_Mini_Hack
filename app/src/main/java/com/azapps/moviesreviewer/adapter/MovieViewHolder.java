package com.azapps.moviesreviewer.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.azapps.moviesreviewer.R;


class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView movieImageView;
    TextView titleTV, releaseDateTV, ratingTv;
    CardView cardView;
    ImageView ratingBar;
    OnMovieClickListener listener;

    public MovieViewHolder(@NonNull final View itemView, OnMovieClickListener onMovieClickListener) {
        super(itemView);
        movieImageView = itemView.findViewById(R.id.movie_img_id);
        titleTV = itemView.findViewById(R.id.movie_title);
        releaseDateTV = itemView.findViewById(R.id.release_date);
        ratingTv = itemView.findViewById(R.id.rating_number);
        cardView = itemView.findViewById(R.id.container_root);
        ratingBar=itemView.findViewById(R.id.rating);

        itemView.setOnClickListener(this);
        listener = onMovieClickListener;
    }

    @Override
    public void onClick(View v) {
        listener.onMovieClick(getAdapterPosition());
    }
}
