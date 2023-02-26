package com.zarlok.webshop.service;

import com.zarlok.webshop.entity.User;
import com.zarlok.webshop.exception.UserExistsException;

import java.util.List;

public interface UserService {

    public List<User> getUsers();
    public void updateUser(User theUser);
    public void registerNewUser(User newUser) throws UserExistsException;
    public User getUser(String username);
    public void deleteUser(String username);
//    public String encodePassword(String password);
    public String encodePassword(String password);

}
