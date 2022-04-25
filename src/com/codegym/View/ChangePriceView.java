package com.codegym.View;

import com.codegym.Controller.ComputerController;
import com.codegym.Model.Computer;
import com.codegym.config.ConfigReadAndWriteFile;

import java.util.List;
import java.util.Scanner;

public class ChangePriceView {
    ComputerController computerController = new ComputerController();
    Scanner scanner = new Scanner(System.in);
    String path = "E:\\IdeaProjects\\CaseMD2_InternetService\\src\\com\\codegym\\Data\\computerList.txt";
    List<Computer> computerList = new ConfigReadAndWriteFile<Computer>().readFromFile(path);

    public void changePrice() {
        System.out.println("BẠN MUỐN ĐỔI THÀNH GIÁ BAO NHIÊU?");
        long price = scanner.nextLong();
        scanner.nextLine();
        for (int i = 0; i < computerList.size(); i++) {
            computerList.get(i).setPrice(price);
            new ConfigReadAndWriteFile<Computer>().writeToFile(path, computerList);
        }
        System.out.println("nhập Quit để quay lại MENU");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Quit")) {
            new MainMenuView();
        }
    }
}
