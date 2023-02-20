package com.zarlok.webshop.dao;

import com.zarlok.webshop.entity.Role;
import com.zarlok.webshop.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> getUsers();
    public void updateUser(User theUser);
    public void registerNewUser(User newUser);
    public User getUser(String username);
    public void deleteUser(String username);
    public void setPassword(String password);
    public void setRole(Role role);
}
