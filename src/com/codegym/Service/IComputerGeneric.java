package com.codegym.Service;

import java.util.List;

public interface IComputerGeneric<T> {
    List<T> findAll();
    void save(T t);
}
