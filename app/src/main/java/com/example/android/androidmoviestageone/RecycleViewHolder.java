package com.example.android.androidmoviestageone;

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

    public RecycleViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        movieName = (TextView)itemView.findViewById(R.id.country_name);
        moviePhoto = (ImageView)itemView.findViewById(R.id.country_photo);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }

}
