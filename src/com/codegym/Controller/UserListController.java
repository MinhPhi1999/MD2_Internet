package com.codegym.Controller;

import com.codegym.Model.User;
import com.codegym.Service.user.UserServiceIMPL;

import java.util.List;

public class UserListController {
    private UserServiceIMPL userServiceIMPL = new UserServiceIMPL();
    public List<User> showListUser(){
        return userServiceIMPL.findAll();
    }
    public void addListUser(User user){
        userServiceIMPL.addUser(user);
    }
}
