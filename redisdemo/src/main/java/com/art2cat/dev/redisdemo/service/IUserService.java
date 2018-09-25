package com.art2cat.dev.redisdemo.service;

import com.art2cat.dev.redisdemo.model.User;
import java.util.List;
import javax.validation.constraints.NotNull;

public interface IUserService {

    List<User> getAllUsers();

    User getUserById(@NotNull Integer id);

    User addUser(@NotNull User user);

    User updateUser(@NotNull User user);

    void deleteUserById(@NotNull  Integer id);
}
