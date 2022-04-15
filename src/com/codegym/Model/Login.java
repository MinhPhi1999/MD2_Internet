package com.codegym.Model;

import java.io.Serializable;

public class Login extends User implements Serializable {
    public Login() {
    }

    public Login(String username, String password) {
        super(username, password);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
