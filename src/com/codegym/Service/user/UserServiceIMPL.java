package com.codegym.Service.user;

import com.codegym.Model.User;
import com.codegym.config.ConfigReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class UserServiceIMPL implements IUserGeneric<User>{
    private String path="E:\\IdeaProjects\\CaseMD2_InternetService\\src\\com\\codegym\\Data\\registerList.txt";
    List<User> userList = new ConfigReadAndWriteFile<User>().readFromFile(path);


    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
        new ConfigReadAndWriteFile<User>().writeToFile(path,userList);
    }
}
