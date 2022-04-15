package com.codegym.Controller;

import com.codegym.Model.Login;
import com.codegym.Service.Login.LoginServiceIMPL;

public class ControllerLogin {
    private LoginServiceIMPL loginServiceIMPL = new LoginServiceIMPL();
    public boolean login(Login login){
        return loginServiceIMPL.login(login);
    }
}
