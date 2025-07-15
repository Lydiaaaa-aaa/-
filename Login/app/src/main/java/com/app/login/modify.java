package com.app.login;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class modify extends AppCompatActivity {
    //定义对象
    EditText edit_threeinputsno,edit_threesno,edit_threename,edit_threedep;
    Button btn_threequery,btn_threemodify,btn_threenext;
    MyDBOpenHelper mhelper;//定义一个数据库帮助类对象
    SQLiteDatabase db;//定义一个操作的数据库的类对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        //1 控件初始化
        initView();
        //2 查询按钮功能的实现
        btnQuery();
        //3 修改按钮功能的实现
        btnModify();
        //4 下一步按钮功能的实现
        btnNext();
    }
    //1 控件初始化
    private void initView() {
        edit_threeinputsno=findViewById(R.id.editText_threeinputsno);
        edit_threesno=findViewById(R.id.editText_threesno);
        edit_threename=findViewById(R.id.editText_threename);
        edit_threedep=findViewById(R.id.editText_threedep);
        btn_threequery=findViewById(R.id.button_threequery);
        btn_threemodify=findViewById(R.id.button_threemodify);
        btn_threenext=findViewById(R.id.button_threenext);
        mhelper=new MyDBOpenHelper(modify.this);//实例化数据库帮助类对象
        db= mhelper.getWritableDatabase();//获取数据库的读写权限
    }
    //2 查询按钮功能的实现
    private void btnQuery() {
        btn_threequery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //先查询显示，再修改。参数（String sql，String[ ] selectionArgs）
                Cursor cursor=db.rawQuery("select * from stu_info where sno=?",new String[]{edit_threeinputsno.getText().toString()});
                if(cursor.getCount()!=0){
                    Toast.makeText(modify.this,"查询成功",Toast.LENGTH_SHORT).show();
                    while(cursor.moveToNext()){
                        @SuppressLint("Range")
                        String mysno=cursor.getString(cursor.getColumnIndex("sno"));
                        @SuppressLint("Range")
                        String myname=cursor.getString(cursor.getColumnIndex("name"));
                        @SuppressLint("Range")
                        String mydep=cursor.getString(cursor.getColumnIndex("deparment"));
                        edit_threesno.setText(mysno);
                        edit_threename.setText(myname);
                        edit_threedep.setText(mydep);
                    }
                }else{
                    Toast.makeText(modify.this,"没有查询到该学号的学生",Toast.LENGTH_SHORT).show();
                    edit_threesno.setText("");
                    edit_threename.setText("");
                    edit_threedep.setText("");
                }
            }
        });
    }
    //3 修改按钮功能的实现---------代码
    private void btnModify() {
        btn_threemodify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //修改数据代码如何写呢？参数：（表名，ContentValues 对象，更新的条件，条件的参数）
                ContentValues values=new ContentValues();

                values.put("deparment",edit_threedep.getText().toString());
                db.update("stu_info",values,"sno=?",new String[]{edit_threesno.getText().toString()});
                Toast.makeText(modify.this,"修改成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
    //4 下一页按钮功能的实现------代码
    private void btnNext() {
        btn_threenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(modify.this,Delete.class);
                startActivity(intent);
                finish();
            }
        });
    }
}