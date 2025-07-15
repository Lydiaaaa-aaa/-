package com.app.login;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.app.login.fragment.CarFragment;
import com.app.login.fragment.HomeFragment;
import com.app.login.fragment.MineFragment;
import com.app.login.fragment.OrderFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Shopping extends AppCompatActivity {

    private HomeFragment homeFragment;
    private CarFragment carFragment;
    private MineFragment mineFragment;
    private OrderFragment orderFragment;

    private BottomNavigationView mybottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shopping);

        //初始化控件
        mybottomNavigationView = findViewById(R.id.bottomNavigationView);

        //设置点击事件
        mybottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home){
                    selectedFragment(0);

                } else if(item.getItemId()==R.id.car){
                    selectedFragment(1);

                } else if(item.getItemId()==R.id.order){
                    selectedFragment(2);

                } else {
                    selectedFragment(3);

                }
                return true;
            }
        });

        //默认首页选择
        selectedFragment(0);

    }
    private void selectedFragment(int p){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);

        if(p==0){
            if(homeFragment==null){
                homeFragment = new HomeFragment();
                fragmentTransaction.add(R.id.content,homeFragment);
            }else{
                fragmentTransaction.show(homeFragment);
            }
        }else if(p==1){
            if(carFragment==null){
                carFragment = new CarFragment();
                fragmentTransaction.add(R.id.content,carFragment);
            }else{
                fragmentTransaction.show(carFragment);
                //刷新数据
                carFragment.loadDate();
            }
        } else if(p==2){
            if(orderFragment==null){
                orderFragment = new OrderFragment();
                fragmentTransaction.add(R.id.content,orderFragment);
            }else{
                fragmentTransaction.show(orderFragment);
                orderFragment.loadDate();
            }
        }else{
            if(mineFragment==null){
                mineFragment = new MineFragment();
                fragmentTransaction.add(R.id.content,mineFragment);
            }else{
                fragmentTransaction.show(mineFragment);
            }
        }

        fragmentTransaction.commit();
    }


    private void hideFragment(FragmentTransaction fragmentTransaction){
        if(homeFragment!=null){
            fragmentTransaction.hide(homeFragment);
        }
        if(carFragment!=null){
            fragmentTransaction.hide(carFragment);
        }
        if(orderFragment!=null){
            fragmentTransaction.hide(orderFragment);
        }
        if(mineFragment!=null){
            fragmentTransaction.hide(mineFragment);
        }
    }
}