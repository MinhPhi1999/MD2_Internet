package com.codegym.View;

import com.codegym.Controller.ComputerController;
import com.codegym.Model.Computer;
import com.codegym.config.ConfigReadAndWriteFile;

import java.util.List;
import java.util.Scanner;

public class MainMenuView {
    Scanner scanner = new Scanner(System.in);
    ComputerController computerController = new ComputerController();
    String path = "E:\\IdeaProjects\\CaseMD2_InternetService\\src\\com\\codegym\\Data\\computerList.txt";
    List<Computer> computerList = new ConfigReadAndWriteFile<Computer>().readFromFile(path);

    public MainMenuView() {
        System.out.println("WELCOME TO NÉT CỎ !!!");
        System.out.println("1. Hiển thị danh sách máy có trong quán");
        System.out.println("2. Thêm 1 máy mới vào danh sách");
        System.out.println("3. ON/OFF & Sửa thông tin của máy");
        System.out.println("4. Xóa máy khỏi danh sách");
        System.out.println("5. Thêm dịch vụ");
        System.out.println("6. Chỉnh sửa tính tiền theo giờ");
        System.out.println("7. Tính Tiền");
        System.out.println("8. Quản lý tài khoản đăng nhập");
        System.out.println("9. Doanh Thu");
        System.out.println("10. Đăng xuất");
        System.out.println("=============================================");
        System.out.println("NHẬP SỐ TRÊN MENU: ");
        try {
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
                case 6:
                    new ChangePriceView().changePrice();
                    break;
                case 5:
                case 8:
                case 9:
                    System.err.println("CHƯA LÀM TÍNH NĂNG NÀY!!! KHÓ QUÁ ANH CHỊ EM Ạ");
                    System.out.println("============================================================");
                    new MainMenuView();
                    break;
                case 7:
                    new PaymentView().showMoney();
                    break;
                case 10:
                    new Main();
                    break;
                default:
                    System.err.println("NHẬP SỐ TRÊN KIA THÔI BRO!!!");
                    new MainMenuView();
            }
        }catch (Exception e){
            System.err.println("NHẬP SỐ THÔI BRO!!!");
            new MainMenuView();
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
            System.out.println(computerList);
            System.out.println("nhập tên máy mới: ");
            String name = scanner.nextLine();
            Computer computer = new Computer(id, name);
            computerController.addComputer(computer);
            System.out.println(computerList);
            String choice = "";
            while (!choice.equalsIgnoreCase("yes") || !choice.equalsIgnoreCase("no")) {
                System.out.println("bạn muốn thêm máy tiếp không?(yes/no)");
                choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    addComputer();
                } else if (choice.equalsIgnoreCase("no")) {
                    new MainMenuView();
                } else {
                    System.err.println("chỉ yes và no thôi bro");
                }
            }
        }
    }

    public void deleteComputer() {
        System.out.println(computerController.showComputerList());
//        System.out.println("bạn muốn xóa máy nào");
//        System.out.println("nhập 'id' vào đây");
        System.out.println("======================================");
        System.out.println("nhập '0' nếu bạn muốn xóa toàn bộ máy");
        System.out.println("nhập '1' nếu bạn muốn xóa từng máy");
        System.out.println("nhập '-1' nếu bạn muốn trở lại MENU");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case -1:
                new MainMenuView();
                break;
            case 0:
                computerController.removeAllComputer();
                System.out.println("ĐÃ XÓA TOÀN BỘ MÁY");
                System.out.println("nhập 'quit' để quay lại MENU");
                String backMenu = scanner.nextLine();
                if (backMenu.equalsIgnoreCase("quit")) {
                    new MainMenuView();
                }
                break;
            case 1:
                System.out.println("bạn muốn xóa máy nào");
                delete1Com();
                String choice1 = "";
                while (!choice1.equalsIgnoreCase("yes") || !choice1.equalsIgnoreCase("no")) {
                    System.out.println("bạn muốn xóa tiếp máy nào không?(yes/no)");
                    choice1 = scanner.nextLine();
                    if (choice1.equalsIgnoreCase("yes")) {
                        delete1Com();
                    } else if (choice1.equalsIgnoreCase("no")) {
                        new MainMenuView();
                    } else {
                        System.err.println("chỉ yes và no thôi bro");
                    }
                }
                break;
        }
    }
    public void delete1Com(){
        System.out.println("nhập 'id' vào đây");
        int idRemove = scanner.nextInt();
        scanner.nextLine();
        int idvalue = 0;
        for (int i = 0; i < computerList.size(); i++) {
            if ((computerList.get(i).getId()) == idRemove) {
                idvalue = 1;
            }
        }
        if (idvalue == 1) {
            computerController.removeComputer(idRemove);
            System.out.println(computerController.showComputerList());
        } else {
            System.err.println("không thấy máy cần xóa");
        }
    }
}
