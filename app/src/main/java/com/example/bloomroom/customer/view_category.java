package com.example.bloomroom.customer;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bloomroom.Adapter.CategoryAdapter;
import com.example.bloomroom.DBHelper;
import com.example.bloomroom.R;

import java.util.ArrayList;
public class view_category extends AppCompatActivity {
    ImageView cancel;
    DBHelper DB;
    RecyclerView catrecyclerView;
    ArrayList<String> catname, catdes;
    CategoryAdapter catadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_category);

        DB = new DBHelper(this);
        catname = new ArrayList<>();
        catdes = new ArrayList<>();
        catrecyclerView = findViewById(R.id.cat_recyclerview);
        catadapter = new CategoryAdapter(this,catname,catdes);
        catrecyclerView.setAdapter(catadapter);
        catrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewCategory();

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
    //view category code
    private void viewCategory() {
        Cursor cursor = DB.getCategory();
        if(cursor.getCount()==0){
            Toast.makeText(view_category.this, "No categories available now", Toast.LENGTH_SHORT).show();
            return;
        } else{
            while (cursor.moveToNext()){
                catname.add(cursor.getString(0));
                catdes.add(cursor.getString(1));
            }
        }
    }
}