package com.app.login.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.login.R;
import com.app.login.User_info;
import com.app.login.adapter.CarListAdapter;
import com.app.login.db.CariDBHelper;
import com.app.login.db.OrderDBHelper;
import com.app.login.entity.Car_info;

import java.util.List;

public class CarFragment extends Fragment {

    private View rootView;

    private RecyclerView recyclerView;

    private CarListAdapter carListAdapter;

    private TextView total;
    private Button btn_total;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_car, container, false);

        //初始化控件
        recyclerView = rootView.findViewById(R.id.recyclerView);
        total = rootView.findViewById(R.id.total);
        btn_total = rootView.findViewById(R.id.btn_total);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //初始化carListAdapter
        carListAdapter = new CarListAdapter();

        //设置适配器
        recyclerView.setAdapter(carListAdapter);

        //recyclerView点击事件
        carListAdapter.setMyonItemClickListener(new CarListAdapter.onItemClickListener() {
            @Override
            public void onAddClick(Car_info car_info, int position) {
                //加
                CariDBHelper.getInstance(getActivity()).updateProduct(car_info.getCar_id(),car_info);
                loadDate();
            }

            @Override
            public void onSubtractClick(Car_info car_info, int position) {
                //减
                CariDBHelper.getInstance(getActivity()).SubtractUpdateProduct(car_info.getCar_id(),car_info);
                loadDate();

            }

            @Override
            public void deleteOnClick(Car_info car_info, int position) {

                new AlertDialog.Builder(getActivity())
                        .setTitle("提示")
                        .setMessage("您是否确认要将该商品从购物车移除")
                        .setPositiveButton("狠心移除", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                CariDBHelper.getInstance(getActivity()).delete(car_info.getCar_id()+"");

                                loadDate();
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

        //结算的点击事件
        btn_total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //将购物车数据批量生成订单
                User_info user_info = User_info.getUser_info();
                if(user_info!=null){
                    List<Car_info> carList = CariDBHelper.getInstance(getActivity()).quaryCarList(user_info.getUsername());
                    if (carList.size() == 0) {
                        Toast.makeText(getActivity(), "当前购物车中没有商品！！！", Toast.LENGTH_SHORT).show();

                    }else {
                        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.pay_layout, null);

                        EditText et_mobile = view1.findViewById(R.id.et_mobile);
                        EditText et_address = view1.findViewById(R.id.et_address);
                        TextView tv_total = view1.findViewById(R.id.tv_total);

                        //设置总价
                        tv_total.setText(total.getText().toString());

                        new AlertDialog.Builder(getActivity())
                                .setTitle("支付提示")
                                .setView(view1)
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int which) {

                                    }
                                })
                                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int which) {
                                        String mobile = et_mobile.getText().toString();
                                        String address = et_address.getText().toString();
                                        if(TextUtils.isEmpty(address)||TextUtils.isEmpty(mobile)){
                                            Toast.makeText(getActivity(), "请完善信息", Toast.LENGTH_SHORT).show();
                                        }else {
                                            //生成订单
                                            OrderDBHelper.getInstance(getActivity()).insertAll(carList,address,mobile);
                                            //清空购物车
                                            for(int i=0;i<carList.size();i++){
                                                CariDBHelper.getInstance(getActivity()).delete(carList.get(i).getCar_id()+"");
                                            }
                                            loadDate();

                                            Toast.makeText(getActivity(), "支付成功", Toast.LENGTH_SHORT).show();

                                        }

                                    }
                                })
                                .show();



                    }
                }


            }
        });

        loadDate();


    }

    public void setTotal(List<Car_info> list){
        int dexCount = 0;
        for(int i=0;i< list.size();i++){
            int price = list.get(i).getProduct_price()*list.get(i).getProduct_count();
            dexCount = dexCount+price;
        }

        //设置数据
        total.setText(dexCount+".00");


    }

    public void loadDate(){

        User_info user_info = User_info.getUser_info();
        //获取数据

        if(user_info!=null){
            List<Car_info> carList = CariDBHelper.getInstance(getActivity()).quaryCarList(user_info.getUsername());
            //设置数据
            carListAdapter.setMyCar_infoList(carList);
            //计算总价
            setTotal(carList);


        }

    }
}