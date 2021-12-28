package com.user_registration_form.service.impl;

import com.user_registration_form.dto.UserDTO;
import com.user_registration_form.model.User;
import com.user_registration_form.repository.IUserRepository;
import com.user_registration_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void save(UserDTO userDto) {
        User user = new User(userDto.getId(),userDto.getFirst_name(),userDto.getLast_name(),
                userDto.getPhone_number(),userDto.getAge(),userDto.getEmail());
//        user.setCreateDate(LocalDate.now());
        userRepository.save(user);
    }
}
