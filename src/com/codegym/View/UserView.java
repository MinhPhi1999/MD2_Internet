package com.codegym.View;

import com.codegym.Controller.UserListController;
import com.codegym.Model.User;

import java.util.Scanner;

public class UserView {
    Scanner scanner = new Scanner(System.in);
    UserListController userListController = new UserListController();
    public void showListUser(){
        userListController.showListUser();
        System.out.println("Ấn Q để quit");
        String quit = scanner.nextLine();
        switch (quit){
            case "q":
                new Main();
                break;
            default:
                break;
        }
    }
    public void addUserList(){
       while (true){
           System.out.println("enter username: ");
           String username = scanner.nextLine();
           System.out.println("enter password: ");
           String password = scanner.nextLine();
           User user = new User(username,password);
           userListController.addListUser(user);
           System.out.println("ấn T để tiếp tục: ");
           System.out.println("ấn Q để thoát: ");
           String quit = scanner.nextLine();
           switch (quit){
               case "T":
                   addUserList();
                   break;
               case "Q":
                   new Main();
                   break;
           }
       }
    }

}