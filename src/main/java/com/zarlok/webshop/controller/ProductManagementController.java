package com.zarlok.webshop.controller;


import com.zarlok.webshop.entity.Product;
import com.zarlok.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manage/product")
public class ProductManagementController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String listProduct(Model model){
        List<Product> productList = productService.getProducts();
        model.addAttribute(productList);
        return "management/products/products-list";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model){
        Product newProduct = new Product();
        model.addAttribute("product", newProduct);

        return "management/products/add-product-form";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/manage/product/list";
    }

    @GetMapping("/updateProduct")
    public String updateProduct(@RequestParam("productId") int productId, Model model){
        Product theProduct = productService.getProduct(productId);
        model.addAttribute("product",theProduct);
        return "management/products/product-form";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("productId") int productId){
        productService.deleteProduct(productId);

        return "redirect:/manage/product/list";
    }
}
