package com.codegym.View;

import com.codegym.Controller.ComputerController;
import com.codegym.Model.Computer;
import com.codegym.config.ConfigReadAndWriteFile;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);
    ComputerController computerController = new ComputerController();
    String path = "E:\\IdeaProjects\\CaseMD2_InternetService\\src\\com\\codegym\\Data\\computerList.txt";
    List<Computer> computerList = new ConfigReadAndWriteFile<Computer>().readFromFile(path);

    public MainMenu() {
        System.out.println("Welcome to Cyber");
        System.out.println("Giá: 10.000 vnd/h");
        System.out.println("1. Hiển thị danh sách máy có trong quán");
        System.out.println("2. Thêm 1 máy mới vào danh sách");
        System.out.println("3. Sửa đổi thông tin của máy");
        System.out.println("4. Xóa 1 máy khỏi danh sách.");
        System.out.println("5. Thêm dịch vụ");
        System.out.println("6. Chỉnh sửa tính tiền theo giờ");
        System.out.println("7. Tính Tiền");
        System.out.println("8. Quản lý tài khoản đăng nhập");
        System.out.println("9. Doanh Thu");
        System.out.println("10. Đăng xuất");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                new ListComputerView().showListComputer();
                break;
            case 2:
                addComputer();
                break;
            case 3:
                new ChanceComputerView().chooseChange();
                break;
            case 4:
                deleteComputer();
                break;
            case 10:
                new Main();
                break;
        }
    }


    public void addComputer() {
        while (true) {
            int id;
            if (computerList.size() == 0) {
                id = 1;
            } else {
                id = computerList.get(computerList.size() - 1).getId() + 1;
            }
            System.out.println("nhập tên máy mới: ");
            String name = scanner.nextLine();
            Computer computer = new Computer(id, name);
            computerList.add(computer);
            new ConfigReadAndWriteFile<Computer>().writeToFile(path, computerList);
            String choice = "";
            while (!choice.equalsIgnoreCase("yes") || !choice.equalsIgnoreCase("no")) {
                System.out.println("bạn muốn thêm máy tiếp không?(yes/no)");
                choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    addComputer();
                } else if (choice.equalsIgnoreCase("no")) {
                    new MainMenu();
                } else {
                    System.err.println("chỉ yes và no thôi bro");
                }
            }
        }
    }

    public void deleteComputer() {
        System.out.println(computerController.showComputerList());
        System.out.println("bạn muốn xóa máy nào");
        System.out.println("nhập id vào đây");
        int idRemove = scanner.nextInt();
        scanner.nextLine();
        int idvalue = 0;
        for (int i = 0; i < computerList.size(); i++) {
            if ((computerList.get(i).getId()) == idRemove) {
                idvalue = 1;
            }
        }
        if (idvalue == 1) {
//            String choice = "";
//            while (!choice.equalsIgnoreCase("yes") || !choice.equalsIgnoreCase("no")) {
//                System.out.println("bạn muốn xóa nữa không?(yes/no)");
//                choice = scanner.nextLine();
//                if (choice.equalsIgnoreCase("yes")) {
//                    computerController.removeComputer(idRemove);
//                    System.out.println(computerController.showComputerList());
//                } else if (choice.equalsIgnoreCase("no")) {
//                    System.out.println(computerController.showComputerList());
//                } else {
//                    System.err.println("chỉ yes và no thôi bro");
//                }
//            }
            computerController.removeComputer(idRemove);
            System.out.println(computerController.showComputerList());
        } else {
            System.err.println("không thấy máy cần xóa");
        }
        String choice = "";
        while (!choice.equalsIgnoreCase("yes") || !choice.equalsIgnoreCase("no")) {
            System.out.println("bạn muốn xóa tiếp máy nào không?(yes/no)");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                deleteComputer();
            } else if (choice.equalsIgnoreCase("no")) {
                new MainMenu();
            } else {
                System.err.println("chỉ yes và no thôi bro");
            }
        }
    }

}
