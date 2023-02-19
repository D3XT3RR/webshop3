package com.zarlok.webshop.service;

import com.zarlok.webshop.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();
    public void updateUser(User theUser);
    public void registerNewUser(User newUser);
    public User getUser(int userId);
    public void deleteUser(String username);
//    public String encodePassword(String password);
    public String encodePassword(String password);

}
