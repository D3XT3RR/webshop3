package com.zarlok.webshop.dao;

import com.zarlok.webshop.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Product> getProducts() {

        // get the current session status
        Session currentSession = sessionFactory.getCurrentSession();

        // create query sort by id
        Query<Product> theQuery =
                currentSession.createQuery(
                        "from Product order by name",
                        Product.class);
        //

        return theQuery.getResultList();
    }

    @Override
    public void saveProduct(Product product) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(product);
    }

    @Override
    public Product getProduct(int productId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Product.class,productId);
    }

    @Override
    public void deleteProduct(int productId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(currentSession.get(Product.class,productId));
    }
}
