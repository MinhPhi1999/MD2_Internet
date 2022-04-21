package com.codegym.Controller;

import com.codegym.Model.Computer;
import com.codegym.Service.computer.ComputerService;

import java.util.List;

public class ComputerController {
    private ComputerService computerService = new ComputerService();
    public List<Computer> showComputerList(){
        return computerService.findAll();
    }
    public void addComputer(){
        computerService.addComputer();
    }
    public void removeComputer(int id){
        computerService.removeComputer(id);
    }
    public Computer getComputerByID(int id){
        return computerService.getComputerByID(id);
    }
    public void setOn(int id){
        computerService.setOn(id);
    }
    public void setOff(int id){
        computerService.setOff(id);
    }


}
