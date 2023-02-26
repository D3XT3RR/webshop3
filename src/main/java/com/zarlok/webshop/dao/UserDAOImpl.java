package com.zarlok.webshop.dao;

import com.zarlok.webshop.entity.Role;
import com.zarlok.webshop.entity.User;
import com.zarlok.webshop.exception.UserExistsException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> userQuery =
                currentSession.createQuery("from User order by first_name" , User.class);

        return userQuery.getResultList();
    }

    @Override
    public void updateUser(User theUser) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(theUser);
    }

    @Override
    public void registerNewUser(User newUser) throws UserExistsException {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Integer> userQuery =
                currentSession.createQuery("SELECT id from User where username='" + newUser.getUsername()+"'", Integer.class);
        System.out.printf(userQuery.getQueryString());
        if(userQuery.getSingleResult() != null){
            throw new UserExistsException("This username is already in use!");
        }else {
            currentSession.save(newUser);
        }
    }

    @Override
    public User getUser(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(User.class, username);
    }

    @Override
    public void deleteUser(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(currentSession.get(User.class, username));
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public void setRole(Role role) {

    }

}
