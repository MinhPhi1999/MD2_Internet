package com.codegym.View;

import com.codegym.Controller.ComputerController;
import com.codegym.Model.Computer;
import com.codegym.config.ConfigReadAndWriteFile;

import java.util.List;
import java.util.Scanner;

public class PaymentView {
    ComputerController computerController = new ComputerController();
    Scanner scanner = new Scanner(System.in);
    String path = "E:\\IdeaProjects\\CaseMD2_InternetService\\src\\com\\codegym\\Data\\computerList.txt";
    List<Computer> computerList = new ConfigReadAndWriteFile<Computer>().readFromFile(path);
    public void showMoney(){
        System.out.println("nhập id máy bạn muốn thanh toán");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(computerController.getComputerByID(id).price()+"đồng");
        System.out.println("=================================");
        System.out.println("nhập Quit để quay lại MENU");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Quit")) {
            new MainMenuView();
        }

    }
}
