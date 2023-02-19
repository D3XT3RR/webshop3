package com.zarlok.webshop.dao;

import com.zarlok.webshop.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveRole(Role newRole) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(newRole);
    }

    @Override
    public Role getRole() {
        return null;
    }
}
