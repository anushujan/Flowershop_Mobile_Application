package com.example.bloomroom.Adapter;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bloomroom.R;
import java.util.ArrayList;
public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.MyViewHolder> {
    private Context context;
    private ArrayList fid_id,fname_id,fcat_id,fprice_id;
     itemClickListener itemClickListener;
    public FlowerAdapter(Context context, ArrayList fid_id, ArrayList fname_id, ArrayList fcat_id, ArrayList fprice_id,
                        itemClickListener itemClickListener )
    {
        this.context = context;
        this.fid_id = fid_id;
        this.fname_id = fname_id;
        this.fcat_id = fcat_id;
        this.fprice_id = fprice_id;
        this.itemClickListener = itemClickListener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_flower,parent,false);
        return new MyViewHolder(v,itemClickListener);
    }
    //set details to cardview
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.fname_id.setText(String.valueOf(fname_id.get(position)));
        holder.fcat_id.setText(String.valueOf(fcat_id.get(position)));
        holder.fprice_id.setText(String.valueOf(fprice_id.get(position)));
    }
    @Override
    public int getItemCount() {return fname_id.size();}
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView fname_id,fcat_id,fprice_id;
        itemClickListener itemClickListener;
        CardView card_flower;
        ImageView btn_img_cart;
        public MyViewHolder(@NonNull View itemView,itemClickListener itemClickListener) {
            super(itemView);
            fname_id = itemView.findViewById(R.id.display_flower_name);
            fcat_id =itemView.findViewById(R.id.display_flower_category);
            fprice_id = itemView.findViewById(R.id.display_flower_price);
            card_flower = itemView.findViewById(R.id.cardflower);
            btn_img_cart =itemView.findViewById(R.id.imgcartt);
            this.itemClickListener =itemClickListener;
            btn_img_cart.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            itemClickListener.onItemClick(getAdapterPosition());
        }
    }
    //item click listener code
    public interface itemClickListener{
        void onItemClick(int position);
    }
}
