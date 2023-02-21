package com.zarlok.webshop.dao;

import com.zarlok.webshop.entity.Role;
import com.zarlok.webshop.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Queue;

@Repository
public class RoleDAOImpl implements RoleDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveRole(Role newRole) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(newRole);
    }

    @Override
    public void updateRole(Role currentRole){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(currentRole);
    }

    @Override
    public void deleteRole(Role role){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(role);
    }

    @Override
    public Role getRole(User user){
        Session currentSession = sessionFactory.getCurrentSession();
         return currentSession.get(Role.class,user.getUsername());
    }

    @Override
    public Role getRole(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        //currentSession.get(Role.class, username);
        Query<Role> query = currentSession
                .createQuery("from Role where username=:username", Role.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }
}
