package com.example.bloomroom.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bloomroom.DBHelper;
import com.example.bloomroom.R;

public class Login_page extends AppCompatActivity {
    EditText edt_username,edt_password;
    TextView text_register;
    Button login;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        text_register = findViewById(R.id.txt_login);
        login = findViewById(R.id.btn_login);
        edt_username =findViewById(R.id.edt_log_username);
        edt_password = findViewById(R.id.edt_log_password);
        DB = new DBHelper(this);

        text_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Register_page.class));

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String username = edt_username.getText().toString();
                String password = edt_password.getText().toString();

                if(username.equals("")) {
                    Toast.makeText(Login_page.this, "Please enter username", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(Login_page.this, "Please enter password", Toast.LENGTH_SHORT).show();
                }else{
                   boolean result =  DB.checkUsernamePassword(username,password);
                   if(result==true){
                       startActivity(new Intent(getApplicationContext(), customer_bloom_room.class));
                       Toast.makeText(Login_page.this, "Welcome "+username, Toast.LENGTH_SHORT).show();
                   }
                   else{
                       Toast.makeText(Login_page.this, "Username or password invalid!", Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });


    }
}