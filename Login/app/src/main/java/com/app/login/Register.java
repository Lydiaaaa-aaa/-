package com.app.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;
    //保存用户名和密码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register2);
        //初始化控件
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);



        findViewById(R.id.back_dl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //返回登录页面
               finish();
            }
        });

        //点击注册
        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
                    Toast.makeText(Register.this, "请输入用户名并且输入密码", Toast.LENGTH_SHORT).show();
                else {
                    int row = UserDBHelper.getInstance(Register.this).register(username, password, "这个人很懒，什么也没有留下。。。");
                    if(row>0){
                        Toast.makeText(Register.this, "注册成功，请登录", Toast.LENGTH_SHORT).show();
                        finish();
                    }


                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}