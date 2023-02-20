package com.zarlok.webshop.service;

import com.zarlok.webshop.dao.UserDAO;
import com.zarlok.webshop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;


    private final PasswordEncoder passwordEncoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    @Transactional
    public void updateUser(User theUser) {
        userDAO.updateUser(theUser);
    }

    @Override
    @Transactional
    public void registerNewUser(User newUser) {
        // TODO: sprawdzic problem z rejestracją przy użyciu custom encodera
        newUser.setPassword(encodePassword(newUser.getPassword()));
        userDAO.registerNewUser(newUser);
    }

    @Override
    @Transactional
    public User getUser(String username) {
        return userDAO.getUser(username);
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        userDAO.deleteUser(username);
    }

    @Override
    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }
}
