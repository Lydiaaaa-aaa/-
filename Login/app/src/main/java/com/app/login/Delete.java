package com.app.login;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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

public class Delete extends AppCompatActivity {
    //定义对象
    EditText edit_foursno;
    Button btn_fourdelete;
    MyDBOpenHelper mhelper;//定义一个数据库帮助类对象
    SQLiteDatabase db;//定义一个操作的数据库的类对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        //1 控件初始化
        initView();
        //2 删除按钮功能的实现
        btnDelete();
    }
    //1 控件初始化
    private void initView() {
        edit_foursno=findViewById(R.id.editText_foursno);
        btn_fourdelete=findViewById(R.id.button_fourdelete);
        mhelper=new MyDBOpenHelper(Delete.this);//实例化数据库帮助类对象
        db=mhelper.getWritableDatabase();//获取数据库的读写权限
    }
    //2 删除按钮功能的实现
    private void btnDelete() {
        btn_fourdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //怎么样删除呢？参数：（表名，删除的条件，条件的参数）
                db.delete("stu_info","sno=?",new String[]{edit_foursno.getText().toString()});
                Toast.makeText(Delete.this,"删除成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}