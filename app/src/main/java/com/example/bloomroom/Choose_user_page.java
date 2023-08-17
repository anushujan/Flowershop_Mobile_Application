package com.example.bloomroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.bloomroom.admin.admin_login_page;
import com.example.bloomroom.customer.register_or_login;

public class Choose_user_page extends AppCompatActivity {
    Button admin,customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseuserpage);

        admin= findViewById(R.id.btn_admin);
        customer = findViewById(R.id.btn_customer);
        //customer user selection code
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), register_or_login.class));
            }
        });

        //admin user selection code
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), admin_login_page.class));
            }
        });
    }
}