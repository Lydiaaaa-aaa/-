package com.app.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBOpenHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "student.db";
    private static final int VERSION = 1;

    public MyDBOpenHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//创建数据表
        db.execSQL("create table stu_info(id INTEGER primary key autoincrement,sno varchar(10),name varchar(10),sex varchar(4),professional varchar(10),deparment varchar(20) )");
    }
//升级数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
