package com.app.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_2 extends AppCompatActivity {
    //定义对象
    EditText edit_twosno;
    Button btn_twoquery,btn_twonext;
    TextView txt_tworesult;
    MyDBOpenHelper mhelper;//定义一个数据库帮助类对象
    SQLiteDatabase db;//定义一个操作的数据库的类对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //1 控件初始化
        initView();
        //2 查询按钮功能的实现
        btnQuery();
        //3 下一页按钮功能的实现
        btnNext();
    }
    //1 控件初始化
    private void initView() {
        edit_twosno=findViewById(R.id.editText_twosno);
        btn_twoquery=findViewById(R.id.button_twoquery);
        txt_tworesult=findViewById(R.id.textView_tworesult);
        btn_twonext=findViewById(R.id.button_twonext);
        mhelper=new MyDBOpenHelper(activity_2.this);//实例化数据库帮助类对象
        db=mhelper.getWritableDatabase();//获取数据库的读写权限
    }
    //2 查询按钮功能的实现
    private void btnQuery() {
        btn_twoquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开始查询 参数：（实现查询的 sql 语句，条件参数）
                Cursor cursor =db.rawQuery("select * from stu_info where sno=?",new String[]{edit_twosno.getText().toString()});
                if(cursor.getCount()!=0){//判断结果集中是否有数据，有：查询成功；无：查询失败
                    Toast.makeText(activity_2.this,"查询成功",Toast.LENGTH_SHORT).show();
                    //循环遍历结果集，取出数据，显示出来
                    while (cursor.moveToNext()){
                        @SuppressLint("Range")
                        String mysno=cursor.getString(cursor.getColumnIndex("sno"));
                        @SuppressLint("Range")
                        String myname=cursor.getString(cursor.getColumnIndex("name"));
                        @SuppressLint("Range")
                        String mysex=cursor.getString(cursor.getColumnIndex("sex"));
                        @SuppressLint("Range")
                        String mypro=cursor.getString(cursor.getColumnIndex("professional"));
                        @SuppressLint("Range")
                        String mydep=cursor.getString(cursor.getColumnIndex("deparment"));

                        txt_tworesult.setText("学号："+mysno+"\n"+"姓名："+myname+"\n"+"性别："+mysex+"\n"+"班级："+mypro+"\n"+"学院："+mydep);
                    }
                }else{
                    Toast.makeText(activity_2.this,"没有查询到该学号的学生",Toast.LENGTH_SHORT).show();
                    txt_tworesult.setText("");
                }
            }
        });
    }
    //3 下一页按钮功能的实现
    private void btnNext() {
        btn_twonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity_2.this,modify.class);
                startActivity(intent);
                finish();
            }
        });
    }
}