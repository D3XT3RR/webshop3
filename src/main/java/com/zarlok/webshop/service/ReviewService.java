package com.zarlok.webshop.service;

import com.zarlok.webshop.entity.Product;
import com.zarlok.webshop.entity.Review;

import java.util.List;

public interface ReviewService {

    public void saveReview(Review review);

    public void deleteReview(Review review);

    public List<Review> getReviews(Product product);
}
