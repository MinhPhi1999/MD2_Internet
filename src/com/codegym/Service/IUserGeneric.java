package com.codegym.Service;

import java.util.List;

public interface IUserGeneric<T> {
    List<T> findAll();
    void addUser(T t);
}
