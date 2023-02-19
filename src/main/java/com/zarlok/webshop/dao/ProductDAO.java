package com.zarlok.webshop.dao;

import com.zarlok.webshop.entity.Product;

import java.util.List;

public interface ProductDAO {

    public List<Product> getProducts();
    public void saveProduct(Product product);
    public Product getProduct(int productId);
    public void deleteProduct(int productId);
}
