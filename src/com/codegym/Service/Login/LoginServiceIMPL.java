package com.codegym.Service.Login;


import com.codegym.Model.Login;
import com.codegym.Model.User;
import com.codegym.config.ConfigReadAndWriteFile;

import java.util.List;

public class LoginServiceIMPL implements ILoginService<Login> {
    private String path = "E:\\IdeaProjects\\CaseMD2_InternetService\\src\\com\\codegym\\Data\\registerList.txt";
    private List<User> userList = new ConfigReadAndWriteFile<User>().readFromFile(path);


    @Override
    public boolean login(Login login) {
        boolean check = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(login.getUsername()) && userList.get(i).getPassword().equals(login.getPassword())) {
                check = true;
            }
        }
        return check;
    }
}
