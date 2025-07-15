package com.app.login.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.login.ChangePasswordActivity;
import com.app.login.LoginActivity;
import com.app.login.R;
import com.app.login.User_info;


public class MineFragment extends Fragment {

    private View rootview;
    private TextView tv_username;
    private TextView tv_nickname;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_mine, container, false);

        //初始化
        tv_username = rootview.findViewById(R.id.tv_username);
        tv_nickname = rootview.findViewById(R.id.tv_nickname);

        //退出登录
        rootview.findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(getContext())
                        .setTitle("温馨提示")
                        .setMessage("是否退出登录？")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                //退出登录的逻辑
                                getActivity().finish();
                                Intent intent = new Intent(getActivity(), LoginActivity.class);
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();

            }
        });

        //修改密码点击事件
        rootview.findViewById(R.id.update_pw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChangePasswordActivity.class);
                startActivityForResult(intent, 1000);
            }

        });
        return rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //设置用户数据
        User_info userInfo = User_info.getUser_info();
        if(userInfo!=null){
            tv_nickname.setText(userInfo.getUsername());
            tv_nickname.setText(userInfo.getNickname());
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1000){
            getActivity().finish();
            Intent intent = new Intent(getActivity(),LoginActivity.class);
            startActivity(intent);
        }
    }
}