package com.zarlok.webshop.entity;

import java.util.List;

public class Cart {

    private int id;
    private List<Product> productsList;

    Cart(){}

    Cart(int cartId, List<Product> productsList){
        this.id = cartId;
        this.productsList = productsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }
}
