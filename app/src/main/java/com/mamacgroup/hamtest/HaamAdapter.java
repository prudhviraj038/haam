package com.mamacgroup.hamtest;

/**
 * Created by mac on 2/14/18.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mamacgroup.hamtest.HaamMerge.CategoryActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HaamAdapter extends RecyclerView.Adapter<HaamAdapter.MyViewHolder> {

    private List<String> moviesList;
    private List<String> moviesList_names;
    private List<String> moviesList_images;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView title, year, genre;
        public TextView ch_title;


        public MyViewHolder(View view) {
            super(view);
            title = (ImageView) view.findViewById(R.id.haam_image);
            ch_title = (TextView) view.findViewById(R.id.haam_adap_text);

                    }
    }


    public HaamAdapter( Context context,List<String> moviesList,List<String> moviesList_images,List<String> moviesList_names) {

        this.moviesList = moviesList;
        this.moviesList_names = moviesList_names;
        this.moviesList_images = moviesList_images;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.haam_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        // Movie movie = moviesList.get(position);
        //holder.title.setText(movie.getTitle());
        //holder.genre.setText(movie.getGenre());
        //holder.year.setText(movie.getYear());

        //Picasso.with(context).load(moviesList_images.get(position)).into(holder.title);

        holder.ch_title.setText(moviesList_names.get(position));
        holder.title.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent( context,CategoryActivity.class);
        intent.putExtra("feed_id", "0");
        intent.putExtra("login_check","1");
        context.startActivity(intent);
    }
});
          }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
