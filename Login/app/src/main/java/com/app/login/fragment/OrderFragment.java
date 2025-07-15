package com.app.login.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.login.R;
import com.app.login.User_info;
import com.app.login.adapter.OrderListAdapter;
import com.app.login.db.CariDBHelper;
import com.app.login.db.OrderDBHelper;
import com.app.login.entity.Order_info;

import java.util.List;

public class OrderFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;

    private OrderListAdapter myOrderListAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_order,container,false);

        //初始化控件
        recyclerView = rootView.findViewById(R.id.recyclerView);


        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //初始化myOrderListAdapter
        myOrderListAdapter = new OrderListAdapter();

        //设置OrderListAdapter
        recyclerView.setAdapter(myOrderListAdapter);

        //recyclerView点击事件
        myOrderListAdapter.setMyonItemClickListener(new OrderListAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Order_info orderInfo, int position) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("提示")
                        .setMessage("您是否确认要将该商品从订单中移除")
                        .setPositiveButton("狠心移除", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int row = OrderDBHelper.getInstance(getActivity()).delete(orderInfo.getOrder_id() + "");
                                if(row>0){
                                    Toast.makeText(getActivity(), "移除成功", Toast.LENGTH_SHORT).show();
                                    loadDate();
                                }
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

        //获取数据
        loadDate();

    }
    public void loadDate(){
        User_info user_info = User_info.getUser_info();


        if(user_info!=null){
            //获取数据
            List<Order_info> orderInfos = OrderDBHelper.getInstance(getActivity()).quaryOrderList(user_info.getUsername());
            myOrderListAdapter.setListData(orderInfos);

        }


    }

}