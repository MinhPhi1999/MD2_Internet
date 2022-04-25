package com.codegym.View;

import com.codegym.Controller.ComputerController;
import com.codegym.Model.Computer;
import com.codegym.Model.Status;
import com.codegym.Service.computer.ComputerServiceIMPL;
import com.codegym.config.ConfigReadAndWriteFile;

import java.util.List;
import java.util.Scanner;

public class ChanceComputerView {
    Scanner scanner = new Scanner(System.in);
    ComputerController computerController = new ComputerController();
    String path = "E:\\IdeaProjects\\CaseMD2_InternetService\\src\\com\\codegym\\Data\\computerList.txt";
    List<Computer> computerList = ComputerServiceIMPL.computerList;

    public void chooseChange() {
        System.out.println("1. bật tắt máy");
        System.out.println("2. đổi tên máy");
        System.out.println("0. để quay lại menu");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                onOffComputer();
                break;
            case 2:
                changeComputer();
                break;
            default:
                new MainMenuView();
        }
    }

    public void onOffComputer() {
        while (true) {
            System.out.println(computerList);
            System.out.println("nhập 'id' máy bạn muốn ON/OFF");
            System.out.println("nhập '0' nếu bạn muốn quay lại");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id == 0) {
                new ChanceComputerView().chooseChange();
            } else {
                for (int i = 0; i < computerList.size(); i++) {
                    if (id == computerList.get(i).getId()) {
                        if (computerList.get(i).getStatus() == Status.DISABLE) {
                            setOn(id);

                        } else {
                            setOff(id);
                        }
                    }
                }
                System.out.println("nhập bất kỳ phím nào để tiếp tục hoặc 'quit' để quay lại ");
                String backMenu = scanner.nextLine();
                if (backMenu.equalsIgnoreCase("quit")) {
                    new ChanceComputerView();
                }
            }
        }
    }

    public void changeComputer() {
            while (true) {
                System.out.println(computerList);
                System.out.println("nhập 'id' máy bạn muốn thay đổi");
                System.out.println("nhập 0 để quay lại");
                int id = scanner.nextInt();
                scanner.nextLine();
                if (id == 0) {
                    new ChanceComputerView().chooseChange();
                } else {
                    boolean check = false;
                    for (int i = 0; i < computerList.size(); i++) {
                        if (computerList.get(i).getId() == id) {
                            check = true;
                            System.out.println(computerList.get(i));
                            System.out.println("bạn muốn đổi tên máy thành gì?");
                            String name = scanner.nextLine();
                            computerList.get(i).setName(name);
                            System.out.println("KẾT QUẢ : ");
                            System.out.println(computerList.get(i));
                            computerList.get(i);
                            new ConfigReadAndWriteFile<Computer>().writeToFile(path, computerList);
                            System.out.println("=====================");
                        }
                    }
                    if (check == false) {
                        System.out.println("không thấy máy có id này");
                        new ChanceComputerView().changeComputer();
                    }
                    System.out.println("nhập bất kỳ phím nào để tiếp tục hoặc 'quit' để quay lại ");
                    String backMenu = scanner.nextLine();
                    if (backMenu.equalsIgnoreCase("quit")) {
                        new ChanceComputerView().chooseChange();
                    }
                }
            }
        }

    public void setOn(int id) {
        while (true) {
            boolean check = true;
            for (int i = 0; i < computerList.size(); i++) {
                if (id == computerList.get(i).getId()) {
                    computerController.setOn(id);
                    check = false;
                    System.out.println("BẬT MÁY " + computerList.get(i).getName() + " THÀNH CÔNG!");
                    onOffComputer();
                }
            }
            if (check) {
                System.out.println("không thấy máy này");
                new MainMenuView();
            }
        }
    }

    public void setOff(int id) {
        while (true) {
            boolean check = true;
            for (int i = 0; i < computerList.size(); i++) {
                if (id == computerList.get(i).getId()) {
                    computerController.setOff(id);
                    check = false;
                    System.out.println("tắt máy " + computerList.get(i).getName() + " thành công");
                    onOffComputer();
                }
            }
            if (check) {
                System.out.println("không thấy máy này");
                new MainMenuView();
            }
        }
    }
}
