package com.user_registration_form.service;

import com.user_registration_form.dto.UserDTO;
import com.user_registration_form.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    void save(User user);

    void save(UserDTO userDto);
}
