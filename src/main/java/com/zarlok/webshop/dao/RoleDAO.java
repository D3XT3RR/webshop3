package com.zarlok.webshop.dao;

import com.zarlok.webshop.entity.Role;
import com.zarlok.webshop.entity.User;

public interface RoleDAO {

    public void saveRole(Role newRole);

    public void updateRole(Role currentRole);

    void deleteRole(Role role);

    public Role getRole(User user);
    public Role getRole(String username);

}