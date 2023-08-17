package com.example.bloomroom.admin;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bloomroom.Adapter.OrderAdapter;
import com.example.bloomroom.Choose_user_page;
import com.example.bloomroom.DBHelper;
import com.example.bloomroom.R;

import java.util.ArrayList;
public class admin_orders extends AppCompatActivity {
    RecyclerView orecycleview;
    ArrayList <String> oname,ocat,oprice,cadd;
    DBHelper DB;
    OrderAdapter orderAdapter;
    ImageView cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_orders);

        DB = new DBHelper(this);
        oname = new ArrayList<>();
        ocat = new ArrayList<>();
        oprice = new ArrayList<>();
        cadd = new ArrayList<>();
        cancel = findViewById(R.id.img_cancels);
        //recycle view show code
        orecycleview =findViewById(R.id.order_recycle);
        orderAdapter = new OrderAdapter(this,oname,ocat,oprice,cadd);
        orecycleview.setAdapter(orderAdapter);
        orecycleview.setLayoutManager(new LinearLayoutManager(this));
        viewOrder();
        //cancel button code
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), admin_bloom_room.class));
                finish();
            }
        });
    }
    //view orders code
    private void viewOrder() {
        Cursor cr = DB.getOrder();
        if(cr.getCount()==0){
            Toast.makeText(admin_orders.this, "No Orders found", Toast.LENGTH_SHORT).show();
            return;}
        else{
            while(cr.moveToNext()){
                oname.add(cr.getString(0));
                ocat.add(cr.getString(1));
                oprice.add(cr.getString(2));
                cadd.add(cr.getString(3));
            }
        }
    }
}