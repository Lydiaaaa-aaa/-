package com.app.login;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

public class UserDBHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "user.db";
    private static final int VERSION = 1;
    private static UserDBHelper sHelper;

    public UserDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version) {
        super(context, name, factory, version);
    }

    public synchronized static UserDBHelper getInstance(Context context){
        if(null==sHelper){
            sHelper = new UserDBHelper(context,DBNAME,null,VERSION);
        }
        return sHelper;
    }
    public void onCreate(SQLiteDatabase db) {
//创建数据表
        db.execSQL("create table user_table(user_id integer primary key autoincrement,"+
                "username text,"+
                "password text,"+
                "nickname text"+
                " )");
    }
    //升级数据库
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    //登录
    @SuppressLint("Range")
    public User_info login(String username){
        SQLiteDatabase db = getWritableDatabase();
        User_info user_info = null;
        String sql = "select user_id,username,password,nickname from user_table where username=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql,selectionArgs);
        if(cursor.moveToNext()){
            int user_id = cursor.getInt(cursor.getColumnIndex("user_id"));
            String name = cursor.getString(cursor.getColumnIndex("username"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String nickname = cursor.getString(cursor.getColumnIndex("nickname"));
            user_info = new User_info(user_id,name,password,nickname);
        }
        cursor.close();
        db.close();
        return user_info;

    }



    //注册
    public int register(String username,String password,String nickname){
        //获取SQL实例
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username",username);
        values.put("password",password);
        values.put("nickname",nickname);
        String nullColumnHack = "value(null,?,?,?)";

        int insert = (int)db.insert("user_table",nullColumnHack,values);
        db.close();
        return insert;
    }

    //修改密码
    public int updatePW(String username,String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("password",password);
        int update = db.update("user_table",values,"username=?",new String[]{username});
        db.close();
        return update;

    }


}
