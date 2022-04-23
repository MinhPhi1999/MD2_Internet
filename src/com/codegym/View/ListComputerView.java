package com.codegym.View;

import com.codegym.Controller.ComputerController;
import com.codegym.Model.Computer;
import com.codegym.config.ConfigReadAndWriteFile;

import java.util.List;
import java.util.Scanner;

public class ListComputerView {
    ComputerController computerController = new ComputerController();
    Scanner scanner = new Scanner(System.in);
    String path = "E:\\IdeaProjects\\CaseMD2_InternetService\\src\\com\\codegym\\Data\\computerList.txt";
    List<Computer> computerList = new ConfigReadAndWriteFile<Computer>().readFromFile(path);

    public void showListComputer() {
        System.out.println("Danh sách máy trong Cyber");
        if (computerList.size()==0){
            System.out.println("CHƯA MUA MÁY THÌ LÀM GÌ CÓ!!!");
            System.out.println("================================");
        }else {
        System.out.println(computerController.showComputerList());
        System.out.println("nhập name để xem thông tin máy");
    }
        System.out.println("nhấn B để trở về menu");
        String name = scanner.nextLine();
        switch (name) {
            case "B":
                new MainMenuView();
            default:
                getComputerByName(name);
        }
    }

    public void getComputerByName(String name) {
        for (int i = 0; i < computerList.size(); i++) {
            if (name.equalsIgnoreCase(computerList.get(i).getName())) {
                System.out.println(computerList.get(i).toString1());
            }
        }
        System.out.println("Nhập B để quay lại Menu");
        String choice = scanner.nextLine();
        switch (choice) {
            case "B":
                new MainMenuView();
        }
    }





}
