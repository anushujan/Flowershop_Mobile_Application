package com.example.bloomroom.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.bloomroom.Adapter.CategoryAdapter;
import com.example.bloomroom.DBHelper;
import com.example.bloomroom.R;

import java.util.ArrayList;
public class admin_category extends AppCompatActivity {
    ImageButton img_btn_add_category;
    ImageView cancel;
    DBHelper DB;
    RecyclerView catrecyclerView;
    ArrayList<String> catname, catdes;
    CategoryAdapter catadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_admin_catagory);

             DB = new DBHelper(this);
             catname = new ArrayList<>();
             catdes = new ArrayList<>();
             catrecyclerView = findViewById(R.id.cat_recyclerview);
             catadapter = new CategoryAdapter(this,catname,catdes);
             catrecyclerView.setAdapter(catadapter);
             catrecyclerView.setLayoutManager(new LinearLayoutManager(this));
             viewCategory();
             img_btn_add_category = findViewById(R.id.btn_add_category);
             cancel =findViewById(R.id.img_cancels);
            //back button code
              cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), admin_bloom_room.class));
                    finish();
                }
            });
            //image add button press go to category add page code
            img_btn_add_category.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), admin_manage_category.class));
                    finish();
                }
            });
    }
    //view category code
    private void viewCategory() {
        Cursor cursor = DB.getCategory();
        if(cursor.getCount()==0){
            Toast.makeText(admin_category.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while (cursor.moveToNext()){
                catname.add(cursor.getString(0));
                catdes.add(cursor.getString(1));
            }
        }
    }
}