package com.example.bloomroom.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloomroom.R;

import java.util.ArrayList;
//adpter extend for viewholder
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    public Context context;
    public ArrayList catname_id,catdes_id;
    public CategoryAdapter(Context context, ArrayList catname_id, ArrayList catdes_id) {
        this.context = context;
        this.catname_id = catname_id;
        this.catdes_id = catdes_id;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_category_,parent,false);
        return new CategoryAdapter.MyViewHolder(v);
    }
    //set details to card view
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.catname_id.setText(String.valueOf(catname_id.get(position)));
        holder.catdes_id.setText(String.valueOf(catdes_id.get(position)));
    }
    //code for details get to cardview
    @Override
    public int getItemCount() {
        return catname_id.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView catname_id,catdes_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //recycle view content hold
            catname_id = itemView.findViewById(R.id.display_flower_name);
            catdes_id = itemView.findViewById(R.id.display_cat_description);
        }
    }
}
