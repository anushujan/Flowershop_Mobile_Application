package com.example.bloomroom.customer;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bloomroom.Adapter.FlowerAdapter;
import com.example.bloomroom.DBHelper;
import com.example.bloomroom.R;

import java.util.ArrayList;
public class view_flowers extends AppCompatActivity implements FlowerAdapter.itemClickListener{
    ImageView cancel;
    DBHelper DB;
    RecyclerView flowrecyclerView;
    ArrayList<String> fid,fname,fcat,fprice;
    FlowerAdapter flowerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flowers);

        DB = new DBHelper(this);
        fid = new ArrayList<>();
        fname = new ArrayList<>();
        fcat = new ArrayList<>();
        fprice = new ArrayList<>();
        flowrecyclerView = findViewById(R.id.orderrecyclerview);
        flowerAdapter =new FlowerAdapter(this,fid,fname,fcat,fprice,this);
        flowrecyclerView.setAdapter(flowerAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        flowrecyclerView.setLayoutManager(gridLayoutManager);
        viewFlowers();

        cancel =findViewById(R.id.img_cancels);
        //back button code
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), customer_bloom_room.class));
                finish();
            }
        });
    }
    private void viewFlowers() {
        Cursor cursorf = DB.getFlower();
        if (cursorf.getCount()==0){
            Toast.makeText(this, "No entry Exists", Toast.LENGTH_SHORT).show();
            return;
        } else{
            while (cursorf.moveToNext()){
                fname.add(cursorf.getString(1));
                fcat.add(cursorf.getString(2));
                fprice.add(cursorf.getString(3));
            }
        }
    }
    @Override
    public void onItemClick(int position) {
        Toast.makeText(view_flowers.this, "flower "+position, Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(view_flowers.this, Flowerpage.class);
        intent.putExtra("name",fname.get(position));
        intent.putExtra("cat",fcat.get(position));
        intent.putExtra("price",fprice.get(position));
        startActivity(intent);
    }
}