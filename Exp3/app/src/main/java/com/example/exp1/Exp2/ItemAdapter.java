package com.example.exp1.Exp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exp1.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ItemViewHolder(view);
    }
    private List<ItemList> itemL;
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder)holder).bind(itemL.get(position),position,itemL);
    }

    @Override
    public int getItemCount() {
        return itemL.size();
    }
    public void setList(List<ItemList>list){
        itemL= list;
    }

}
