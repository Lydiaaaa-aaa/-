package com.app.login;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class MainActivity extends AppCompatActivity {
    //定义对象
    private EditText edit_onesno, edit_onename, edit_onesex, edit_onepro, edit_onedep;
    private Button btn_oneadd, btn_oneclear, btn_onenext;
    private MyDBOpenHelper mhelper;//定义数据库帮助类对象
    private SQLiteDatabase db;//定义一个可以操作的数据库对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1 绑定控件
        initView();
        //2 添加按钮功能的实现
        btnAdd();
        //3 清除和下一页按钮的功能
        btnClearNext();
    }

    //绑定控件
    private void initView() {
        edit_onesno = findViewById(R.id.editText_onesno);
        edit_onename = findViewById(R.id.editText_onename);
        edit_onesex = findViewById(R.id.editText_onesex);
        edit_onepro = findViewById(R.id.editText_onepro);
        edit_onedep = findViewById(R.id.editText_onedep);
        btn_oneadd = findViewById(R.id.button_oneadd);
        btn_oneclear = findViewById(R.id.button_oneclear);
        btn_onenext = findViewById(R.id.button_onenext);
        mhelper = new MyDBOpenHelper(MainActivity.this);//实例化数据库帮助类
        db = mhelper.getWritableDatabase();//创建数据库，获取数据库的读写权限
    }

    //2 添加按钮功能的实现
    private void btnAdd() {
        btn_oneadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //定义一个对象，构建一行数据
                ContentValues values = new ContentValues();//用 value 表示一行
                values.put("sno", edit_onesno.getText().toString());//把输入的学号放到 sno 列
                values.put("name", edit_onename.getText().toString());//把输入的姓名放到 name 列
                values.put("sex", edit_onesex.getText().toString());//把输入的性别放到 sex 列

                values.put("professional", edit_onepro.getText().toString());//把输入的专业放到 professional 列

                values.put("deparment", edit_onedep.getText().toString());//把输入的系部放到 department 列
                //将这一行数据存放到数据库的数据表中。参数：（表名，某些为空的列自动赋值 null，ContentValue 对象）
                db.insert("stu_info", null, values);
                Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //3 清除和下一页按钮的功能
    private void btnClearNext() {
        //清除按钮的功能
        btn_oneclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_onesno.setText("");
                edit_onename.setText("");
                edit_onesex.setText("");
                edit_onepro.setText("");
                edit_onedep.setText("");
            }
        });
        //下一页按钮的功能
        btn_onenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}