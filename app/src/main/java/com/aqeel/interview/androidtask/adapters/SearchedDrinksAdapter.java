package com.aqeel.interview.androidtask.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.aqeel.interview.androidtask.R;
import com.aqeel.interview.androidtask.datamodels.Drink;
import com.aqeel.interview.androidtask.listeners.RecyclerItemClickListener;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class SearchedDrinksAdapter extends RecyclerView.Adapter<SearchedDrinksAdapter.DrinkViewHolder> {

    private ArrayList<Drink> dataList;
    private RecyclerItemClickListener recyclerItemClickListener;

    public SearchedDrinksAdapter(ArrayList<Drink> dataList , RecyclerItemClickListener recyclerItemClickListener) {
        this.dataList = dataList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }


    @Override
    public DrinkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.content_drink_item, parent, false);
        return new DrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DrinkViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.txtDrinkTitle.setText(dataList.get(position).getDrinkName());
        holder.txtDrinkDesp.setText(dataList.get(position).getInstructions());
        Glide.with(holder.itemView.getContext()).load(dataList.get(position).getDrinkThumb()).into(holder.imgDrinkThumb);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(dataList.get(position),position);
            }
        });
    }
    public void updateData(ArrayList<Drink> dataList)
    {
        if(dataList!=null)
        {
            this.dataList.clear();
            this.dataList.addAll(dataList);
            notifyDataSetChanged();
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class DrinkViewHolder extends RecyclerView.ViewHolder {

        TextView txtDrinkTitle, txtDrinkDesp;
        RoundedImageView imgDrinkThumb;

        DrinkViewHolder(View itemView) {
            super(itemView);
            txtDrinkTitle =  itemView.findViewById(R.id.txt_drink_title);
            txtDrinkDesp =  itemView.findViewById(R.id.txt_drink_desp);
            imgDrinkThumb =  itemView.findViewById(R.id.img_drink_thumb);

        }
    }
}