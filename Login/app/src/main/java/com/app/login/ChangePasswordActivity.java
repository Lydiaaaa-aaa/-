package com.app.login;

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

public class ChangePasswordActivity extends AppCompatActivity {
    private EditText et_new_pw;
    private EditText et_confirm_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        //初始化控件
        et_new_pw = findViewById(R.id.et_new_pw);
        et_confirm_pw = findViewById(R.id.et_confirm_pw);

        //修改密码的点击事件
        findViewById(R.id.btn_update_pw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String new_pw = et_new_pw.getText().toString();
                String confirm_pw = et_confirm_pw.getText().toString();

                if(TextUtils.isEmpty(new_pw)||TextUtils.isEmpty(confirm_pw)){
                    Toast.makeText(ChangePasswordActivity.this, "请填写新的密码并确认", Toast.LENGTH_SHORT).show();
                }else if(!new_pw.equals(confirm_pw)){
                    Toast.makeText(ChangePasswordActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                }else {

                    User_info userInfo = User_info.getUser_info();
                    if(userInfo!=null){
                        int row = UserDBHelper.getInstance(ChangePasswordActivity.this).updatePW(userInfo.getUsername(), new_pw);
                        if(row>0){
                            Toast.makeText(ChangePasswordActivity.this, "密码修改成功,请重新登录", Toast.LENGTH_SHORT).show();

                            //回传的时候用startActivityForResult，打开一个新页面，销毁当前页面
                            setResult(1000);
                            finish();
                        }else {
                            Toast.makeText(ChangePasswordActivity.this, "密码修改失败", Toast.LENGTH_SHORT).show();

                        }
                    }

                }

            }
        });

        //返回的点击事件
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}