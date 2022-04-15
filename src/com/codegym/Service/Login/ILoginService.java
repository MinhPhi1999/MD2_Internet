package com.codegym.Service.Login;

import com.codegym.Model.Login;
import com.codegym.Model.User;
import com.codegym.Service.ILoginGeneric;

public interface ILoginService<L extends User> extends ILoginGeneric<Login> {
}
