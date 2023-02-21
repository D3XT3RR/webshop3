package com.zarlok.webshop.service;

import com.zarlok.webshop.dao.RoleDAO;
import com.zarlok.webshop.entity.Role;
import com.zarlok.webshop.entity.User;
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

    @Transactional
    @Override
    public void updateRole(Role role) {
        roleDAO.updateRole(role);
    }

    @Transactional
    @Override
    public void deleteRole(Role role){
        roleDAO.deleteRole(role);
    }

    @Transactional
    @Override
    public Role getRole(User user){
        return roleDAO.getRole(user);
    }
    @Transactional
    @Override
    public Role getRole(String user){
        return roleDAO.getRole(user);
    }
}
