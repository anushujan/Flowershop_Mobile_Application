package com.example.bloomroom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    // this is our database creation code
    public DBHelper( Context context) {
        super(context, "bloomroomshop.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        //to create categories table
        DB.execSQL("CREATE TABLE categories(category_name TEXT PRIMARY KEY,category_description TEXT)");
        //to create flower table
        DB.execSQL("CREATE TABLE flower(flower_id TEXT PRIMARY KEY,flower_name TEXT,flower_category TEXT,flower_price TEXT)");
        //to create orders table
        DB.execSQL("CREATE TABLE orderdetail(order_name TEXT,order_category TEXT,order_price TEXT,customer_address TEXT)");
        //to create customer table
        DB.execSQL("CREATE TABLE customerdetail(username TEXT PRIMARY KEY,email TEXT,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS categories");
        DB.execSQL("DROP TABLE IF EXISTS flower");
        DB.execSQL("DROP TABLE IF EXISTS orderdetail");
        DB.execSQL("DROP TABLE IF EXISTS customerdetail");
    }
    //customer start from here
    //insert customer data sqlite
    public boolean insertCustomer(String username,String email,String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);

        long result = DB.insert("customerdetail",null,cv);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    //checkUsername code
    public boolean checkUsername(String username){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM customerdetail WHERE username=?",new String[]{username});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

    //check username and password code
    public boolean checkUsernamePassword(String username,String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM customerdetail WHERE username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }

    //category start from here
    //inset category data sqlite
    public boolean insertCategory(String category_name,String category_description){
        SQLiteDatabase DB =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("category_name",category_name);
        contentValues.put("category_description",category_description);

        long result = DB.insert("categories",null,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }
    //get category for view
    public Cursor getCategory(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM categories",null);
        return cursor;
    }
    //update category data sqlite
    public  boolean updateCategory(String category_name,String category_description){
        SQLiteDatabase DB =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("category_description",category_description);
        Cursor cursor = DB.rawQuery("SELECT * FROM categories WHERE category_name = ?",new String[]{category_name});
        if(cursor.getCount()>0)
        {
            long result = DB.update("categories", contentValues, "category_name=?", new String[]{category_name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }
    //delete category data sqlite
    public  boolean deleteCategory(String category_name){
        SQLiteDatabase DB =this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM categories WHERE category_name = ?",new String[]{category_name});
        if(cursor.getCount()>0)
        {
            long result = DB.delete("categories", "category_name=?", new String[]{category_name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }
    //flower data star from here
    //inset flower data sqlite
    public  boolean insertFlower(String flower_id,String flower_name,String flower_category,String flower_price){
        SQLiteDatabase DB =this.getWritableDatabase();
        ContentValues contentValuesf = new ContentValues();
        contentValuesf.put("flower_id",flower_id);
        contentValuesf.put("flower_name",flower_name);
        contentValuesf.put("flower_category",flower_category);
        contentValuesf.put("flower_price",flower_price);
        long result = DB.insert("flower",null,contentValuesf);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }

    }
    //get flower for view
    public Cursor getFlower(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursorf = DB.rawQuery("SELECT * FROM flower",null);
        return cursorf;

    }

    //update flower data sqlite
    public  boolean updateFlower(String flower_id,String flower_name,String flower_category,String flower_price){
        SQLiteDatabase DB =this.getWritableDatabase();
        ContentValues contentValuesf = new ContentValues();
        contentValuesf.put("flower_name",flower_name);
        contentValuesf.put("flower_category",flower_category);
        contentValuesf.put("flower_price",flower_price);
        Cursor cursor = DB.rawQuery("SELECT * FROM flower WHERE flower_id = ?",new String[]{flower_id});
        if(cursor.getCount()>0)
        {
            long result = DB.update("flower", contentValuesf, "flower_id=?", new String[]{flower_id});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }
   //delete flower data sqlite
    public  boolean deleteFlower(String flower_id){
        SQLiteDatabase DB =this.getWritableDatabase();
        Cursor cursorf = DB.rawQuery("SELECT * FROM flower WHERE flower_id= ?",new String[]{flower_id});
        if(cursorf.getCount()>0)
        {
            long result = DB.delete("flower", "flower_id=?", new String[]{flower_id});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }
    //order data start here
    //insert orders data sqlite
    public  boolean insertOrder(String order_name,String order_category,String order_price,String customer_address){
        SQLiteDatabase DB =this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("order_name",order_name);
        cv.put("order_category",order_category);
        cv.put("order_price",order_price);
        cv.put("customer_address",customer_address);

        long result = DB.insert("orderdetail",null,cv);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    //get order for view
    public Cursor getOrder(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cr = DB.rawQuery("SELECT * FROM orderdetail",null);
        return cr;

    }

}



