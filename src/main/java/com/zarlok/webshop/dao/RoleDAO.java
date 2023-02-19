package com.zarlok.webshop.dao;

import com.zarlok.webshop.entity.Role;

public interface RoleDAO {

    public void saveRole(Role newRole);
    public Role getRole();

}