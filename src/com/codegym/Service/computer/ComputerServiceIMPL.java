package com.codegym.Service.computer;

import com.codegym.Model.Computer;
import com.codegym.config.ConfigReadAndWriteFile;

import java.util.List;

public class ComputerServiceIMPL implements IComputerService<Computer> {
    public static String path = "E:\\IdeaProjects\\CaseMD2_InternetService\\src\\com\\codegym\\Data\\computerList.txt";
    public static List<Computer> computerList = new ConfigReadAndWriteFile<Computer>().readFromFile(path);


    @Override
    public List<Computer> findAll() {
        new ConfigReadAndWriteFile<Computer>().writeToFile(path, computerList);
        return computerList;
    }

    @Override
    public void save(Computer computer) {
        computerList.add(computer);
    }


    public void removeComputer(int id) {
        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i).getId()==id) {
                computerList.remove(computerList.get(i));
            }
        }
    }
    public void removeAll(){
        computerList.removeAll(computerList);
        new ConfigReadAndWriteFile<Computer>().writeToFile(path, computerList);
    }

    public Computer getComputerByID(int id){
        for (int i = 0; i < computerList.size(); i++) {
            if (id == computerList.get(i).getId()) {
                return computerList.get(i);
            }
        }
        return null;
    }
    public void setOn(int id){
//        System.out.println("id ====== "+id );
        for (int i = 0; i < computerList.size(); i++) {
            if (id== computerList.get(i).getId()){
                computerList.get(i).setStatusAvaiable();
//                System.out.println("get status "+computerList.get(i).getStatus());
                new ConfigReadAndWriteFile<Computer>().writeToFile(path, computerList);
            }
        }
    }
    public void setOff(int id){
        for (int i = 0; i < computerList.size(); i++) {
            if (id== computerList.get(i).getId()){
                computerList.get(i).setStatusDisable();
                new ConfigReadAndWriteFile<Computer>().writeToFile(path, computerList);
            }
        }
    }


}
