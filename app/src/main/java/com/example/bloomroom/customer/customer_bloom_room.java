package com.example.bloomroom.customer;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bloomroom.R;
import com.example.bloomroom.admin.admin_category;
import com.example.bloomroom.admin.admin_flowers;
import com.example.bloomroom.admin.admin_login_page;
import com.example.bloomroom.admin.admin_orders;
public class customer_bloom_room extends AppCompatActivity {
    TextView nav_category,nav_flowers;
    ImageView btnlogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_bloom_room);

        nav_category = findViewById(R.id.txt_btn_category);
        nav_flowers = findViewById(R.id.txt_btn_flowers);
        btnlogout = findViewById(R.id.img_cus_logout);
        //go to customer category view page
        nav_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), view_category.class));
            }
        });
        nav_flowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), view_flowers.class));
            }
        });
        //logout code
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login_page.class));
                Toast.makeText(customer_bloom_room.this, "bloom room logout", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}