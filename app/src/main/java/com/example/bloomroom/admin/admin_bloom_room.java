package com.example.bloomroom.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bloomroom.R;
import com.example.bloomroom.customer.customer_bloom_room;

public class admin_bloom_room extends AppCompatActivity {
    TextView nav_category,nav_flowers,nav_orders;
    ImageView btnlogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_bloom_room);

        nav_category = findViewById(R.id.txt_btn_category);
        nav_flowers = findViewById(R.id.txt_btn_flowers);
        nav_orders = findViewById(R.id.txt_btn_orders);
        btnlogout = findViewById(R.id.img_logout);

        //go to admin category addable page
        nav_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), admin_category.class));
            }
        });
        //go to admin flower addable page
        nav_flowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), admin_flowers.class));
            }
        });
        //go to admin orders view page
        nav_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), admin_orders.class));
            }
        });
        //logout code
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), admin_login_page.class));
                Toast.makeText(admin_bloom_room.this, "bloom room logout", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}