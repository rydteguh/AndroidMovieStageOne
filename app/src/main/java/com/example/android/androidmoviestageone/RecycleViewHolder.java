package com.example.android.androidmoviestageone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



/**
 * Created by rydteguh on 7/9/2017.
 */

public class RecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView movieName;
    public ImageView moviePhoto;
    public Context context;

    public RecycleViewHolder(View itemView, Context context) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.context = context;
        //movieName = (TextView)itemView.findViewById(R.id.movie_name);
        moviePhoto = (ImageView)itemView.findViewById(R.id.movie_photo);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
        Intent to_detail = new Intent(context,MovieDetail.class);
        context.startActivity(to_detail);
    }

}
