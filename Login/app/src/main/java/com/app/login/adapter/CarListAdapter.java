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

import java.util.ArrayList;
import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.MyHolder> {

    private List<Car_info> myCar_infoList = new ArrayList<>();

    public void setMyCar_infoList(List<Car_info> list){
        this.myCar_infoList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_item, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        //绑定数据
        Car_info car_info = myCar_infoList.get(position);
        holder.product_img.setImageResource(car_info.getProduct_img());
        holder.product_price.setText(car_info.getProduct_price()+"");
        holder.product_title.setText(car_info.getProduct_title());
        holder.product_count.setText(car_info.getProduct_count()+"");

        //设置点击事件
        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myonItemClickListener !=null){
                    myonItemClickListener.onAddClick(car_info,position);
                }


            }
        });

        holder.btn_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myonItemClickListener !=null){
                    myonItemClickListener.onSubtractClick(car_info,position);
                }

            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(myonItemClickListener !=null){
                    myonItemClickListener.deleteOnClick(car_info,position);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return myCar_infoList.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        ImageView product_img;
        TextView product_price;
        TextView product_title;
        TextView product_count;
        TextView btn_add;
        TextView btn_subtract;

        public MyHolder(@NonNull View itemView){
            super(itemView);
            product_img = itemView.findViewById(R.id.product_img);
            product_price = itemView.findViewById(R.id.product_price);
            product_title = itemView.findViewById(R.id.product_title);
            product_count = itemView.findViewById(R.id.product_count);
            btn_add = itemView.findViewById(R.id.btn_add);
            btn_subtract = itemView.findViewById(R.id.btn_subtract);

        }
    }


    private onItemClickListener myonItemClickListener;

    public void setMyonItemClickListener(onItemClickListener myonItemClickListener) {
        this.myonItemClickListener = myonItemClickListener;
    }

    public interface onItemClickListener{
        void onAddClick(Car_info car_info,int position);
        void onSubtractClick(Car_info car_info,int position);
        void deleteOnClick(Car_info car_info,int position);

    }
}
