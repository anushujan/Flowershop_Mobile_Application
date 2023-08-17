package com.example.bloomroom.customer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.bloomroom.DBHelper;
import com.example.bloomroom.R;
public class Flowerpage extends AppCompatActivity {
    TextView txt_name, txt_cat, txt_price;
    EditText edt_address;
    ImageView btn_cart, btn_cancel;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowerpage);

        txt_name = findViewById(R.id.txtname);
        txt_cat = findViewById(R.id.txtcat);
        txt_price = findViewById(R.id.txtprice);
        edt_address = findViewById(R.id.cus_address);
        btn_cart = findViewById(R.id.img_cart);
        btn_cancel = findViewById(R.id.img_cancels);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        String cats = intent.getExtras().getString("cat");
        String price = intent.getExtras().getString("price");

        txt_name.setText(name);
        txt_cat.setText(cats);
        txt_price.setText(price);

        DB = new DBHelper(this);
        //back button code
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), view_flowers.class));
            }
        });
        //add order to card and orders
        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ontxt = txt_name.getText().toString();
                String octxt = txt_cat.getText().toString();
                String optxt = txt_price.getText().toString();
                String addresstxt = edt_address.getText().toString();
                if(addresstxt.isEmpty()){
                    Toast.makeText(Flowerpage.this, "please enter address", Toast.LENGTH_SHORT).show();
                }else{

                Boolean checkaddOrder = DB.insertOrder(ontxt,octxt,optxt,addresstxt);
                if(checkaddOrder==true){
                    Toast.makeText(Flowerpage.this, "order added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Flowerpage.this, "order added fail", Toast.LENGTH_SHORT).show();
                }}
            }
        });
    }
}