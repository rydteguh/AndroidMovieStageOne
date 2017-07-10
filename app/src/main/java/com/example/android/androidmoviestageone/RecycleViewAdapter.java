package com.example.android.androidmoviestageone;

/**
 * Created by rydteguh on 7/9/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewHolder> {

    private List<MovieObject> itemList;
    private Context context;

    public RecycleViewAdapter(Context context, List<MovieObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }


    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_view_list, null);
        RecycleViewHolder rcv = new RecycleViewHolder(layoutView, this.context);
        return rcv;

    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        Picasso.with(context).load(itemList.get(position).getPhoto()).into(holder.moviePhoto);
        holder.setId(itemList.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
