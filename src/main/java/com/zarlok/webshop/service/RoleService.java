package com.zarlok.webshop.service;

import com.zarlok.webshop.entity.Role;
import com.zarlok.webshop.entity.User;
import org.springframework.transaction.annotation.Transactional;

public interface RoleService {
    public void saveRole(Role role);
    public void updateRole(Role role);
    void deleteRole(Role role);
    public Role getRole(User user);
    public Role getRole(String user);
}
