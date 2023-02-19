package com.zarlok.webshop.service;

import com.zarlok.webshop.dao.RoleDAO;
import com.zarlok.webshop.dao.UserDAO;
import com.zarlok.webshop.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleDAO roleDAO;

    @Transactional
    @Override
    public void saveRole(Role role) {
        roleDAO.saveRole(role);
    }
}
