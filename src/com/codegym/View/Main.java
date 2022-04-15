package com.codegym.View;

import java.util.Scanner;

public class Main {
    public Main() {
        System.out.println("1. register");
        System.out.println("2. login");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
              new  UserView().addUserList();
              break;
            case 2:
                new LoginView().login();
        }
    }

    public static void main(String[] args) {
	// write your code here
        new Main();

    }
}
