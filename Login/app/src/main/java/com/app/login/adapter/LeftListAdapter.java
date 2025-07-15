package com.app.login.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.login.R;

import java.util.ArrayList;
import java.util.List;

public class LeftListAdapter  extends RecyclerView.Adapter<LeftListAdapter.MyHolder> {

    private List<String> dateList = new ArrayList<>();

    private int currentIndex = 0;

    public LeftListAdapter(List<String> dateList) {
        this.dateList = dateList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.left_listitem, null);
        return new MyHolder(view);
    }

    @Override
    @SuppressLint("RecyclerView")
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        //绑定数据
        String name = dateList.get(position);
        holder.tv_name.setText(name);

        //分类的点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(leftListOnClickItemListener!=null){
                    leftListOnClickItemListener.itemOnClick(position);
                }
            }
        });

        if(currentIndex==position){
            holder.itemView.setBackgroundResource(R.drawable.type_selector_bg);
        }else{
            holder.itemView.setBackgroundResource(R.drawable.type_selector_normal_bg);

        }

    }

    @Override
    public int getItemCount() {
        return dateList.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        TextView tv_name;

        public MyHolder(@NonNull View itemView){
            super(itemView);
            tv_name = itemView.findViewById(R.id.name);
        }
    }

    private leftListOnClickItemListener leftListOnClickItemListener;

    public void setLeftListOnClickItemListener(LeftListAdapter.leftListOnClickItemListener leftListOnClickItemListener) {
        this.leftListOnClickItemListener = leftListOnClickItemListener;
    }

    public interface leftListOnClickItemListener{
        void itemOnClick(int p);
    }

    public void setCurrentIndex(int p){
        this.currentIndex = p;
        notifyDataSetChanged();

    }
}
