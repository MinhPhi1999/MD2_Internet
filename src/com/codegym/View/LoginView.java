package com.codegym.View;

import com.codegym.Controller.ControllerLogin;
import com.codegym.Model.Login;

import java.sql.SQLOutput;
import java.util.Scanner;

public class LoginView {
    private ControllerLogin controllerLogin = new ControllerLogin();
    Scanner scanner = new Scanner(System.in);

    public void login(){
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter pass: ");
        String pass = scanner.nextLine();
        Login login = new Login(name,pass);

        if (controllerLogin.login(login)){
            new Main1();
        }else {
            System.out.println("sai rồi nhập lại đi");
            new Main();
        }
    }
}
