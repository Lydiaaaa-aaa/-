package com.app.login.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Range;

import com.app.login.entity.Car_info;

import java.util.ArrayList;
import java.util.List;

public class CariDBHelper extends SQLiteOpenHelper {

    private static CariDBHelper sHelper;
    private static final String DBNAME = "car.db";
    private static final int VERSION = 1;


    public CariDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public synchronized static CariDBHelper getInstance(Context context){
        if(null==sHelper){
            sHelper = new CariDBHelper(context,DBNAME,null,VERSION);
        }
        return sHelper;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建car_table表
        db.execSQL("create table car_table(_id integer primary key autoincrement,"+
                "username text,"+
                "product_id integer,"+
                "product_img integer,"+
                "product_title text,"+
                "product_price integer,"+
                "product_count integer"+
                " )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //添加商品到购物车
    public int addCar(String username,int product_id,int product_img,String product_title,int product_price){

        //判断是否添加过商品，如果添加过，修改商品数量
        Car_info addCar = isAddCar(username, product_id);
        if(addCar==null){
            //获得SQLiteDatabase实例
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            //填充占位符
            values.put("username",username);
            values.put("product_id",product_id);
            values.put("product_img",product_img);
            values.put("product_title",product_title);
            values.put("product_price",product_price);
            values.put("product_count",1);
            String nullColumnHack = "values(null,?,?,?,?,?,?)";

            //执行
            int insert = (int)db.insert("car_table",nullColumnHack,values);
            db.close();
            return insert;
        }else {
            return updateProduct(addCar.getCar_id(),addCar);
        }


    }
    //更新购物车
    public int updateProduct(int car_id, Car_info car_info){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("product_count",car_info.getProduct_count()+1);

        //执行sql
        int update = db.update("car_table",values,"_id=?",new String[]{car_id+""});

        db.close();
        return update;
    }
    //商品数减
    public int SubtractUpdateProduct(int car_id, Car_info car_info){

        if(car_info.getProduct_count()>=2){
            SQLiteDatabase db = getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("product_count",car_info.getProduct_count()-1);

            //执行sql
            int update = db.update("car_table",values,"_id=?",new String[]{car_id+""});

            db.close();
            return update;
        }

        return 0;

    }


    //根据用户名和商品id判断有没有添加过商品到购物车
    @SuppressLint("Range")
    public Car_info isAddCar(String username,int product_id){
        SQLiteDatabase db = getWritableDatabase();
        Car_info car_info = null;
        String sql = "select username,_id,product_id,product_img,product_price,product_title,product_count from car_table where username=? and product_id=?";
        String[] selectionArgs = {username,product_id+""};
        Cursor cursor = db.rawQuery(sql,selectionArgs);
        if (cursor.moveToNext()){
            int car_id = cursor.getInt(cursor.getColumnIndex("_id"));
            int product_id2 = cursor.getInt(cursor.getColumnIndex("product_id"));
            int product_price = cursor.getInt(cursor.getColumnIndex("product_price"));
            String name = cursor.getString(cursor.getColumnIndex("username"));
            String product_title = cursor.getString(cursor.getColumnIndex("product_title"));
            int product_count = cursor.getInt(cursor.getColumnIndex("product_count"));
            int product_img = cursor.getInt(cursor.getColumnIndex("product_img"));

            car_info = new Car_info(car_id,name,product_id2,product_img,product_price,product_title,product_count);

        }
        cursor.close();
        db.close();
        return car_info;


    }

    //根据用户名查询购物车
    @SuppressLint("Range")
    public List<Car_info> quaryCarList(String username){
        SQLiteDatabase db = getReadableDatabase();
        List<Car_info> list = new ArrayList<>();
        String[] selectionArgs = {username};
        String sql = "select username,_id,product_id,product_img,product_price,product_title,product_count from car_table where username=?";

        Cursor cursor = db.rawQuery(sql,selectionArgs);
        while (cursor.moveToNext()){
            int car_id = cursor.getInt(cursor.getColumnIndex("_id"));
            int product_id2 = cursor.getInt(cursor.getColumnIndex("product_id"));
            int product_price = cursor.getInt(cursor.getColumnIndex("product_price"));
            String name = cursor.getString(cursor.getColumnIndex("username"));
            String product_title = cursor.getString(cursor.getColumnIndex("product_title"));
            int product_count = cursor.getInt(cursor.getColumnIndex("product_count"));
            int product_img = cursor.getInt(cursor.getColumnIndex("product_img"));

            list.add(new Car_info(car_id,name,product_id2,product_img,product_price,product_title,product_count));

        }
        cursor.close();
        db.close();
        return list;
    }

    //删除购物车商品
    public int delete(String car_id){
        SQLiteDatabase db = getReadableDatabase();

        int delete = db.delete("car_table","_id=?",new String[]{car_id});

        db.close();
        return delete;
    }


}

