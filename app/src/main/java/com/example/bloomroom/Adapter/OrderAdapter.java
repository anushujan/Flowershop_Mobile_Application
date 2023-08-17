package com.example.bloomroom.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloomroom.R;

import java.util.ArrayList;
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {
    private Context context;
    private ArrayList oname_id,ocat_id,oprice_id,caddress_id;
    public OrderAdapter(Context context, ArrayList oname_id, ArrayList ocat_id, ArrayList oprice_id, ArrayList caddress_id) {
        this.context = context;
        this.oname_id = oname_id;
        this.ocat_id = ocat_id;
        this.oprice_id = oprice_id;
        this.caddress_id = caddress_id;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_order,parent,false);
        return new MyViewHolder(v);
    }
//order data set to order card view
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.oname_id.setText(String.valueOf(oname_id.get(position)));
        holder.ocat_id.setText(String.valueOf(ocat_id.get(position)));
        holder.oprice_id.setText(String.valueOf(oprice_id.get(position)));
        holder.caddress_id.setText(String.valueOf(caddress_id.get(position)));
    }
    @Override
    public int getItemCount() {
        return oname_id.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView oname_id,ocat_id,oprice_id,caddress_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            oname_id = itemView.findViewById(R.id.displayOrder_name);
            ocat_id = itemView.findViewById(R.id.displayOrder_category);
            oprice_id = itemView.findViewById(R.id.displayOrder_price);
            caddress_id = itemView.findViewById(R.id.displayOrder_address);
        }
    }
}
