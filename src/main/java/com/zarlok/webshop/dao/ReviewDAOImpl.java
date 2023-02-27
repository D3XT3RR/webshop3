package com.zarlok.webshop.dao;

import com.zarlok.webshop.entity.Product;
import com.zarlok.webshop.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ReviewDAOImpl implements ReviewDAO{

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void saveReview(Review review) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(review);
    }

    @Override
    public void deleteReview(Review review) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(review);

    }

    @Override
    public List<Review> getReviews(Product product) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Review> query = currentSession.createQuery("select Review from Review order by id", Review.class);
        return query.getResultList();

    }
}
