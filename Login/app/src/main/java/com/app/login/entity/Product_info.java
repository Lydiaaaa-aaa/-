package com.app.login.entity;

import java.io.Serializable;

public class Product_info implements Serializable {
    private int product_id;
    private int product_image;
    private String product_title;
    private String product_details;
    private int product_price;

    public Product_info(int product_id, int product_price, String product_details, String product_title, int product_image) {
        this.product_id = product_id;
        this.product_price = product_price;
        this.product_details = product_details;
        this.product_title = product_title;
        this.product_image = product_image;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_image() {
        return product_image;
    }

    public void setProduct_image(int product_image) {
        this.product_image = product_image;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_details() {
        return product_details;
    }

    public void setProduct_details(String product_details) {
        this.product_details = product_details;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }
}
