package com.example.android.androidmoviestageone;

/**
 * Created by rydteguh on 7/9/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewHolder> {

    private List<ItemObject> itemList;
    private Context context;

    public RecycleViewAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }


    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        holder.countryName.setText(itemList.get(position).getName());
        holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
