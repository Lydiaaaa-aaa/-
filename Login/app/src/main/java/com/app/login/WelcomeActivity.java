package com.app.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity {
    private TextView tv_bottom;
    private CountDownTimer countDownTimer;
    private long time = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);
        tv_bottom = findViewById(R.id.tv_bottom);
        //启动倒计时
        startCountdown();
    }

    private void startCountdown(){
        countDownTimer = new CountDownTimer(time,1000) {
            @Override
            public void onTick(long l) {
                time = l;
                int sec = (int)(l/1000);
                tv_bottom.setText(sec+"s");
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
                finish();
            }
        }.start();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }

    }
}