package com.example.bloomroom.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bloomroom.DBHelper;
import com.example.bloomroom.Adapter.FlowerAdapter;
import com.example.bloomroom.R;

import java.util.ArrayList;

public class admin_flowers extends AppCompatActivity implements FlowerAdapter.itemClickListener {

    ImageButton img_btn_add_flowers;
    ImageView cancel;
    DBHelper DB;
    RecyclerView flowrecyclerView;
    ArrayList<String> fid,fname,fcat,fprice;
    FlowerAdapter flowerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_flowers);

        DB = new DBHelper(this);
        fid = new ArrayList<>();
        fname = new ArrayList<>();
        fcat = new ArrayList<>();
        fprice = new ArrayList<>();

        flowrecyclerView = findViewById(R.id.orderrecyclerview);

        flowerAdapter =new FlowerAdapter(this,fid,fname,fcat,fprice,this);
        flowrecyclerView.setAdapter(flowerAdapter);
//        flowrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        flowrecyclerView.setLayoutManager(gridLayoutManager);
        viewFlowers();


        img_btn_add_flowers = findViewById(R.id.btn_add_flower);
        cancel =findViewById(R.id.img_cancels);

        //back button code
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), admin_bloom_room.class));
                finish();

            }
        });

        //image add button press go to flowers add page code
        img_btn_add_flowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), admin_manage_flower.class));
                finish();
            }
        });
    }

    private void viewFlowers() {
        Cursor cursorf = DB.getFlower();
        if (cursorf.getCount()==0){
            Toast.makeText(this, "No entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while (cursorf.moveToNext()){
                fname.add(cursorf.getString(1));
                fcat.add(cursorf.getString(2));
                fprice.add(cursorf.getString(3));

            }
        }
    }


    @Override
    public void onItemClick(int position) {
        Toast.makeText(admin_flowers.this, "Only for Customers "+"item:"+position, Toast.LENGTH_SHORT).show();



    }
}