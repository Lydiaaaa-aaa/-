package com.app.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.app.login.db.CariDBHelper;
import com.app.login.entity.Product_info;

public class ProductDetailsActivity extends AppCompatActivity {

    private ImageView product_img;
    private TextView product_title;
    private TextView product_details;
    private TextView product_price;

    private Product_info product_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        //获取传递的数据
        product_info = (Product_info) getIntent().getSerializableExtra("product_info");

        findViewById(R.id.toolbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        //初始化控件
        product_img = findViewById(R.id.product_img);
        product_title = findViewById(R.id.product_title);
        product_details = findViewById(R.id.product_details);
        product_price = findViewById(R.id.product_price);


        //设置数据
        if(product_info!=null){
            product_img.setImageResource(product_info.getProduct_image());
            product_title.setText(product_info.getProduct_title());
            product_details.setText(product_info.getProduct_details());
            product_price.setText(product_info.getProduct_price()+"");

        }



        //加入购物车
        findViewById(R.id.addCar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new AlertDialog.Builder(ProductDetailsActivity.this)
                       .setTitle("是否添加到购物车？")
                       .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               User_info user_info = User_info.getUser_info();

                               if(user_info!=null){
                                   int row = CariDBHelper.getInstance(ProductDetailsActivity.this).addCar(user_info.getUsername(), product_info.getProduct_id(),product_info.getProduct_image(),  product_info.getProduct_title(),product_info.getProduct_price());
                                   if(row>0)
                                   {
                                       Toast.makeText(ProductDetailsActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                                       finish();

                                   }else {
                                       Toast.makeText(ProductDetailsActivity.this, "添加失败", Toast.LENGTH_SHORT).show();

                                   }

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

    }
}