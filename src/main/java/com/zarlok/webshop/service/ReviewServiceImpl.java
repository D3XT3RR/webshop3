package com.zarlok.webshop.service;

import com.zarlok.webshop.dao.ReviewDAO;
import com.zarlok.webshop.entity.Product;
import com.zarlok.webshop.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    ReviewDAO reviewDAO;

    @Transactional
    @Override
    public void saveReview(Review review) {
        reviewDAO.saveReview(review);
    }

    @Transactional
    @Override
    public void deleteReview(Review review) {
        reviewDAO.deleteReview(review);
    }

    @Transactional
    @Override
    public List<Review> getReviews(Product product) {
        return reviewDAO.getReviews(product);
    }
}
