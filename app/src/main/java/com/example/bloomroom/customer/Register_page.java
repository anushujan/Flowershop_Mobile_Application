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
public class Register_page extends AppCompatActivity {
    EditText username,email,password,confirm_password;
    Button register;
    DBHelper DB;
    TextView text_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);

        text_login = findViewById(R.id.txt_login);
        username =findViewById(R.id.edt_reg_username);
        email =findViewById(R.id.edt_reg_email);
        password =findViewById(R.id.edt_reg_password);
        confirm_password =findViewById(R.id.edt_reg_confirm_password);
        register = findViewById(R.id.btn_register);
        DB = new DBHelper(this);

        //customer register code
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String mail = email.getText().toString();
                String pass = password.getText().toString();
                String cpass = confirm_password.getText().toString();

                if(user.equals("") || mail.equals("") ||pass.equals("") || cpass.equals(""))
                {
                    Toast.makeText(Register_page.this, "Fill all the fields first!", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(cpass)){
                       Boolean usercheckResult = DB.checkUsername(user);
                       if(usercheckResult==false){
                          boolean registerResult = DB.insertCustomer(user,mail,pass);
                          if(registerResult==true){
                              Toast.makeText(Register_page.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                              startActivity(new Intent(getApplicationContext(), Login_page.class));
                          } else{
                              Toast.makeText(Register_page.this, "Registration fail!", Toast.LENGTH_SHORT).show();
                          }
                       } else {
                           Toast.makeText(Register_page.this, "User already Exists.\n Please Login!", Toast.LENGTH_SHORT).show();
                       }
                    }else{
                        Toast.makeText(Register_page.this, "Password not Matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        text_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login_page.class));
            }
        });
    }
}