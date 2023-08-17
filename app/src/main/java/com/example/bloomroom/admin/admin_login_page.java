package com.example.bloomroom.admin;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bloomroom.Choose_user_page;
import com.example.bloomroom.R;
import com.example.bloomroom.customer.customer_bloom_room;
public class admin_login_page extends AppCompatActivity {
    EditText edt_username,edt_password;
    Button btn_a_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_page);

        btn_a_login = findViewById(R.id.btn_login2);
        edt_username = findViewById(R.id.edt_log_username);
        edt_password = findViewById(R.id.edt_log_password);
        //admin login code
        btn_a_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edt_username.getText().toString();
                String password = edt_password.getText().toString();
                if(username.equals("")){
                    Toast.makeText(admin_login_page.this, "Please enter username", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(admin_login_page.this, "please enter password", Toast.LENGTH_SHORT).show();
                } else{
                    if(username.equals("admin") && password.equals("admin")){
                        startActivity(new Intent(getApplicationContext(), admin_bloom_room.class));
                        Toast.makeText(admin_login_page.this, "welcome "+username, Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(admin_login_page.this, "Invalid login", Toast.LENGTH_SHORT).show();
                    }}
            }});}}