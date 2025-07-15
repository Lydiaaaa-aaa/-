package com.app.login.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.login.ProductDetailsActivity;
import com.app.login.R;
import com.app.login.adapter.LeftListAdapter;
import com.app.login.adapter.RightListAdapter;
import com.app.login.entity.DataService;
import com.app.login.entity.Product_info;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private View rootView;
    private RecyclerView leftRecyclerView;

    private RecyclerView rightRecyclerView;
    private LeftListAdapter myLeftListAdapter;

    private RightListAdapter myRightListAdapter;
    private List<String> leftDataList= new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home,container,false);

        //初始化控件
        leftRecyclerView = rootView.findViewById(R.id.leftRecyclerView);
        rightRecyclerView = rootView.findViewById(R.id.rightRecyclerView);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        leftDataList.add("服饰");
        leftDataList.add("食品饮料");
        leftDataList.add("家居用品");
        leftDataList.add("电子产品");
        leftDataList.add("图书");

        myLeftListAdapter = new LeftListAdapter(leftDataList);
        leftRecyclerView.setAdapter(myLeftListAdapter);

        myRightListAdapter = new RightListAdapter();
        rightRecyclerView.setAdapter(myRightListAdapter);

        //rightRecyclerView点击事件
        myRightListAdapter.setOnItemClickListener(new RightListAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Product_info product_info, int p) {
                //跳转
                Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
                //intent 传参时实体要实现Serializable
                intent.putExtra("product_info",product_info);
                startActivity(intent);
            }
        });

        myRightListAdapter.setListData(DataService.getListData(0));

        //leftRecyclerView的点击事件
        myLeftListAdapter.setLeftListOnClickItemListener(new LeftListAdapter.leftListOnClickItemListener() {
            @Override
            public void itemOnClick(int p) {
                myLeftListAdapter.setCurrentIndex(p);
                //点左边切换右边对应数据
                myRightListAdapter.setListData(DataService.getListData(p));
            }
        });

    }
}