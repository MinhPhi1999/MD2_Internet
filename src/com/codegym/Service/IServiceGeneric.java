package com.codegym.Service;

import java.util.List;

public interface IServiceGeneric<T> {
    List<T> findAll();
    void addUser(T t);
}
