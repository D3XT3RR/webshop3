package com.zarlok.webshop.controller;


import com.zarlok.webshop.entity.Product;
import com.zarlok.webshop.entity.Review;
import com.zarlok.webshop.service.ProductService;
import com.zarlok.webshop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/list")
    public String listProduct(Model model){
        List<Product> productList = productService.getProducts();
        model.addAttribute(productList);
        return "/default/products/list";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model){
        Product newProduct = new Product();
        model.addAttribute("product", newProduct);

        return "/default/products/add-form";
    }

    @GetMapping("/addReview")
    public String addReview(@RequestParam("productId") int productId, Model model){
        Review review = new Review();
        review.setProduct(productService.getProduct(productId));
        model.addAttribute("review", review);
        return "/default/products/add-review-form";
    }

    @PostMapping("/addReview")
    public String addReview(@ModelAttribute("review") Review review){
        Product product = productService.getProduct(review.getProduct().getId());
        review.setProduct(product);
        reviewService.saveReview(review);

        return "redirect:/product/list";
    }

    @GetMapping("/reviews")
    public String showReviews(@RequestParam("productId") int productId, Model model){
        Product product = productService.getProduct(productId);

        model.addAttribute("reviews", product.getReviewsList());

        return "/default/products/reviews";
    }





}
