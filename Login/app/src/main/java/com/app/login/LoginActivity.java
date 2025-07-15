package com.app.login;

import static com.app.login.R.id.et_username;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;
    private CheckBox checkbox;
    private boolean is_login;

    private SharedPreferences mySharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        //初始化控件
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        checkbox = findViewById(R.id.checkbox);


        //获取mySharedPreferences
        mySharedPreferences = getSharedPreferences("user",MODE_PRIVATE);

        //是否勾选了记住密码
        is_login = mySharedPreferences.getBoolean("is_login", false);
        if(is_login){
            String username = mySharedPreferences.getString("username",null);
            String password = mySharedPreferences.getString("password",null);
            et_username.setText(username);
            et_password.setText(password);
            checkbox.setChecked(true);
        }


        //注册事件
        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到注册页面
                Intent intent=new Intent(LoginActivity.this,Register.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.b_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
                    Toast.makeText(LoginActivity.this, "请输入用户名并且输入密码", Toast.LENGTH_SHORT).show();
                else{
                    User_info login = UserDBHelper.getInstance(LoginActivity.this).login(username);
                    if(login!=null){
                        if(username.equals(login.getUsername())&&password.equals(login.getPassword())){
                            SharedPreferences.Editor editor = mySharedPreferences.edit();
                            editor.putBoolean("is_login",is_login);
                            editor.putString("username",username);
                            editor.putString("password",password);
                            editor.commit();

                            //保存用户名和密码
                            User_info.setUser_info(login);

                            //登录成功
                            Intent intent = new Intent(LoginActivity.this, Shopping.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "密码错误，请输入正确密码", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "账号未注册", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //checkbox的点击事件
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                is_login = b;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}