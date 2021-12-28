package com.user_registration_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserDTO implements Validator {
    private Integer id;
    @NotNull(message = "Name is not empty")
    @Pattern(regexp = "[A-Za-z ]{5,45}", message = "Number of word from 5 to 45")
    private String first_name;
    private String last_name;
    private String phone_number;
    private String age;
    private String email;

    public UserDTO() {
    }

    public UserDTO(Integer id, String first_name, String last_name, String phone_number, String age, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        if (!userDTO.first_name.matches("[A-Za-z ]{5,45}")) {
            errors.rejectValue("nameErr", "nameErr.invalidFormat");
        }
    }
}
