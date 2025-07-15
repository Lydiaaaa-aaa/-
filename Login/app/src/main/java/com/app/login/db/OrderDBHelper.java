package com.app.login.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.app.login.UserDBHelper;
import com.app.login.entity.Car_info;
import com.app.login.entity.Order_info;

import java.util.ArrayList;
import java.util.List;

public class OrderDBHelper extends SQLiteOpenHelper {

    private static OrderDBHelper sHelper;
    private static final String DBNAME = "order.db";
    private static final int VERSION = 1;

    public OrderDBHelper(@NonNull Context context,@NonNull String name, @NonNull SQLiteDatabase.CursorFactory factory, @NonNull int version) {
        super(context, name, factory, version);
    }

    public synchronized static OrderDBHelper getInstance(Context context){
        if(sHelper==null){
            sHelper = new OrderDBHelper(context,DBNAME,null,VERSION);
        }
        return sHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建car_table表
        db.execSQL("create table order_table(order_id integer primary key autoincrement,"+
                "username text,"+
                "product_img integer,"+
                "product_title text,"+
                "product_price integer,"+
                "product_count integer,"+
                "address text,"+
                "mobile text"+
                " )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //批量插入数据
    public void insertAll(List<Car_info> list, String address, String moblie){

        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            for (int i = 0; i < list.size(); i++) {
                ContentValues values = new ContentValues();
                values.put("username", list.get(i).getUsername());
                values.put("product_img", list.get(i).getProduct_img());
                values.put("product_title", list.get(i).getProduct_title());
                values.put("product_price", list.get(i).getProduct_price());
                values.put("product_count", list.get(i).getProduct_count());
                values.put("address", address);
                values.put("mobile", moblie);
                db.insert("order_table", null, values);
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }

            db.close();

    }

    @SuppressLint("Range")
    public List<Order_info> quaryOrderList(String username){
        SQLiteDatabase db = getReadableDatabase();
        List<Order_info> list = new ArrayList<>();
        String sql = "select order_id,username,product_img,product_title,product_price,product_count,address,mobile from order_table where username=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql,selectionArgs);
        while (cursor.moveToNext()){
            int order_id = cursor.getInt(cursor.getColumnIndex("order_id"));
            String name = cursor.getString(cursor.getColumnIndex("username"));
            int product_img = cursor.getInt(cursor.getColumnIndex("product_img"));
            String product_title = cursor.getString(cursor.getColumnIndex("product_title"));
            int product_price = cursor.getInt(cursor.getColumnIndex("product_price"));
            int product_count = cursor.getInt(cursor.getColumnIndex("product_count"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            String mobile = cursor.getString(cursor.getColumnIndex("mobile"));
            list.add(new Order_info(order_id,name,product_img,product_price,product_title,product_count,mobile,address));

        }
        cursor.close();
        db.close();
        return list;
    }

    public int delete(String order_id){
        SQLiteDatabase db = getReadableDatabase();

        int delete = db.delete("order_table","order_id=?",new String[]{order_id});

        db.close();
        return delete;
    }

}
