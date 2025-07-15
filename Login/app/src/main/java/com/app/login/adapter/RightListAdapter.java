package com.app.login.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.login.R;
import com.app.login.entity.Product_info;

import java.util.ArrayList;
import java.util.List;

public class RightListAdapter extends RecyclerView.Adapter<RightListAdapter.MyHolder> {

      private List<Product_info> myProduct_info = new ArrayList<>();

    public void setListData(List<Product_info> list){
        this.myProduct_info = list;
        //刷新
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //加载布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.right_list_item, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        //绑定数据
        Product_info product_info = myProduct_info.get(position);

        holder.product_img.setImageResource(product_info.getProduct_image());
        holder.product_title.setText(product_info.getProduct_title());
        holder.product_details.setText(product_info.getProduct_details());
        holder.product_price.setText(product_info.getProduct_price()+"");

        //点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener!=null)
                    onItemClickListener.onItemClick(product_info,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myProduct_info.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder{
       ImageView product_img;
       TextView product_title;
       TextView product_details;
       TextView product_price;
        public MyHolder(@NonNull View itemView){
            super(itemView);
            product_img = itemView.findViewById(R.id.product_img);
            product_title = itemView.findViewById(R.id.product_title);
            product_price = itemView.findViewById(R.id.product_price);
            product_details = itemView.findViewById(R.id.product_details);

        }
    }

    private onItemClickListener onItemClickListener;

    public void setOnItemClickListener(RightListAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface onItemClickListener{
        void onItemClick(Product_info product_info,int p);
    }
}
