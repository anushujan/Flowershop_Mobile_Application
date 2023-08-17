package com.example.bloomroom.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bloomroom.DBHelper;
import com.example.bloomroom.R;
public class admin_manage_flower extends AppCompatActivity {
    EditText edt_name,edt_id,edt_price,edt_category;
    ImageView cancel,insert,update,delete;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manage_flower);

        DB = new DBHelper(this);
        edt_id = findViewById(R.id.edt_add_id);
        edt_name = findViewById(R.id.edt_add_flower);
        edt_category = findViewById(R.id.edt_add_category);
        edt_price = findViewById(R.id.edt_add_price);
        insert = findViewById(R.id.img_add);
        update = findViewById(R.id.img_update);
        delete = findViewById(R.id.img_delete);
        cancel = findViewById(R.id.img_cancel);

        //button cancel it's go to admin category page
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), admin_flowers.class));
            }
        });
        //add flower data
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fidTXT = edt_id.getText().toString();
                String fnameTXT = edt_name.getText().toString();
                String fcatTXT = edt_category.getText().toString();
                String fpriceTXT = edt_price.getText().toString();
                if (fidTXT.isEmpty() && fnameTXT.isEmpty() && fcatTXT.isEmpty() && fpriceTXT.isEmpty()) {
                    Toast.makeText(admin_manage_flower.this, "Empty flowers please input", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkinsertFlower = DB.insertFlower(fidTXT, fnameTXT, fcatTXT, fpriceTXT);
                    if (checkinsertFlower == true) {
                        Toast.makeText(admin_manage_flower.this, "New Flower added", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), admin_flowers.class));
                    } else {
                        Toast.makeText(admin_manage_flower.this, "New flower not added!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        //update flower data code
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fidTXT = edt_id.getText().toString();
                String fnameTXT = edt_name.getText().toString();
                String fcatTXT = edt_category.getText().toString();
                String fpriceTXT = edt_price.getText().toString();
                if (fidTXT.isEmpty() && fnameTXT.isEmpty() && fcatTXT.isEmpty() && fpriceTXT.isEmpty()) {
                    Toast.makeText(admin_manage_flower.this, "Empty flowers please input", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkupdateFlower = DB.updateFlower(fidTXT, fnameTXT, fcatTXT, fpriceTXT);
                    if (checkupdateFlower == true) {
                        Toast.makeText(admin_manage_flower.this, "Flower updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(admin_manage_flower.this, "Flower not updated!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        //delete flower data code
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fidTXT = edt_id.getText().toString();
                if (fidTXT.isEmpty()) {
                    Toast.makeText(admin_manage_flower.this, "Empty flowers please input", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkdeletedFlower = DB.deleteFlower(fidTXT);
                    if (checkdeletedFlower == true) {
                        Toast.makeText(admin_manage_flower.this, "Flower deleted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(admin_manage_flower.this, "Flower not deleted!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}