package com.codegym.Service;

import java.util.List;

public interface IComputerGeneric<T> {
    List<T> findAll();
//    void addComputer(T t);
    void save(T t);
}
