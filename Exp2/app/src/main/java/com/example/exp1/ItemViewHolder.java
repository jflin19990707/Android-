package com.example.exp1;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView number;
    private TextView hotValue;
    private int position;
    private List<ItemList> itemL;
    public ItemViewHolder(@NonNull final View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(itemView.getContext(),itemL.get(position).getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
        title = itemView.findViewById(R.id.tit);
        number = itemView.findViewById(R.id.number);
        hotValue = itemView.findViewById(R.id.hotValue);

    }
    public void bind(ItemList itemList,int position,List<ItemList> itemL){
        this.position = position;
        this.itemL = itemL;
        title.setText(itemList.getTitle());
        number.setText(itemList.getId()+".");
        hotValue.setText(itemList.getHotValue()+"");
        if(position>=3){
            number.setTextColor(Color.parseColor("#99ffffff"));
        }
        else{
            number.setTextColor(Color.parseColor("#e6face15"));
        }
    }
}
