package com.zarlok.webshop.service;

import com.zarlok.webshop.dao.ProductDAO;
import com.zarlok.webshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDAO productDAO;

    @Override
    @Transactional
    public List<Product> getProducts() {
        return productDAO.getProducts();
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        productDAO.saveProduct(product);
    }

    @Override
    @Transactional
    public Product getProduct(int productId) {
        return productDAO.getProduct(productId);
    }

    @Override
    @Transactional
    public void deleteProduct(int productId) {
        productDAO.deleteProduct(productId);
    }
}
