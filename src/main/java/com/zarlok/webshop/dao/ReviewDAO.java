package com.zarlok.webshop.dao;

import com.zarlok.webshop.entity.Product;
import com.zarlok.webshop.entity.Review;
import com.zarlok.webshop.entity.Role;

import java.util.List;

public interface ReviewDAO {

    public void saveReview(Review review);

    public void deleteReview(Review review);

    public List<Review> getReviews(Product product);


}
