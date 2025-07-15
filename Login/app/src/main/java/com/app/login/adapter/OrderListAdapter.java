package com.app.login.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.login.R;
import com.app.login.entity.Car_info;
import com.app.login.entity.Order_info;

import java.util.ArrayList;
import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyHoledr> {

    private List<Order_info> myOrder_info = new ArrayList<>();

    public void setListData(List<Order_info> list){
        this.myOrder_info = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHoledr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_item, null);
        return new MyHoledr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHoledr holder, int position) {
        //绑定数据
        Order_info orderInfo = myOrder_info.get(position);

        //设置数据
        holder.product_img.setImageResource(orderInfo.getProduct_img());
        holder.product_price.setText(orderInfo.getProduct_price()+"");
        holder.product_title.setText(orderInfo.getProduct_title());
        holder.product_count.setText("x"+orderInfo.getProduct_count()+"");

        //设置收货地址
        holder.address.setText("收货地址：【"+orderInfo.getMobile()+"】;电话："+orderInfo.getAddress());

        //长按删除
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(myonItemClickListener!=null){
                    myonItemClickListener.onItemClick(orderInfo,position);

                }
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return myOrder_info.size();
    }

    static class MyHoledr extends RecyclerView.ViewHolder{

        ImageView product_img;
        TextView product_price;
        TextView product_title;
        TextView product_count;
        TextView address;

        public MyHoledr(@NonNull View itemView){
            super(itemView);
            product_img = itemView.findViewById(R.id.product_img);
            product_price = itemView.findViewById(R.id.product_price);
            product_title = itemView.findViewById(R.id.product_title);
            product_count = itemView.findViewById(R.id.product_count);
            address = itemView.findViewById(R.id.address);
        }
    }

    private onItemClickListener myonItemClickListener;

    public void setMyonItemClickListener(onItemClickListener myonItemClickListener) {
        this.myonItemClickListener = myonItemClickListener;
    }

    //回调长按删除的接口
    public interface onItemClickListener{
        void onItemClick(Order_info orderInfo,int position);

    }
}
