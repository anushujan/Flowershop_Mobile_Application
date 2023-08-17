package com.example.bloomroom.admin;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bloomroom.DBHelper;
import com.example.bloomroom.R;
public class admin_manage_category extends AppCompatActivity {
    EditText edt_name,edt_description;
    ImageView cancel, delete,update,add;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manage_category);

        edt_name = findViewById(R.id.category_id);
        edt_description = findViewById(R.id.edt_add_description);
        add=findViewById(R.id.img_add);
        cancel = findViewById(R.id.img_cancel);
        delete = findViewById(R.id.img_delete);
        update = findViewById(R.id.img_update);
        DB = new DBHelper(this);
        //button cancel it's go to admin category page
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), admin_category.class));
                finish();
            }
        });
        //add category press button code
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String nameTXT = edt_name.getText().toString();
                String desTXT = edt_description.getText().toString();
                if (nameTXT.isEmpty() && desTXT.isEmpty()) {
                    Toast.makeText(admin_manage_category.this, "Empty categories please input", Toast.LENGTH_SHORT).show();
                } else {

                    Boolean checkaddCategory = DB.insertCategory(nameTXT, desTXT);
                    if (checkaddCategory == true) {
                        Toast.makeText(admin_manage_category.this, "New Category Inserted successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), admin_category.class));
                    } else {
                        Toast.makeText(admin_manage_category.this, "New Category Inserted fail!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        //update category press button code
        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String nameTXT = edt_name.getText().toString();
                String desTXT = edt_description.getText().toString();
                if (nameTXT.isEmpty() && desTXT.isEmpty()) {
                    Toast.makeText(admin_manage_category.this, "Empty categories please input", Toast.LENGTH_SHORT).show();
                } else {

                    Boolean checkupdateCategory = DB.updateCategory(nameTXT, desTXT);
                    if (checkupdateCategory == true) {
                        Toast.makeText(admin_manage_category.this, "Category updated successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(admin_manage_category.this, "Category updated fail!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        //delete category press button code
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String nameTXT = edt_name.getText().toString();
                if (nameTXT.isEmpty()) {
                    Toast.makeText(admin_manage_category.this, "Empty categories please input", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkdeleteCategory = DB.deleteCategory(nameTXT);
                    if (checkdeleteCategory == true) {
                        Toast.makeText(admin_manage_category.this, "Category deleted successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(admin_manage_category.this, "Category not deleted!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}


