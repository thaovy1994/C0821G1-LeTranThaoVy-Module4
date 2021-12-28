package com.user_registration_form.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserDTO {
    private String id;
    @NotEmpty(message = "First Name is not empty")
    @Pattern(regexp = "[A-Za-z ]{5,45}", message = "Number of word from 5 to 45")
    private String first_name;
    @NotEmpty(message = "Last Name is not empty")
    @Pattern(regexp = "[A-Za-z ]{5,45}", message = "Number of word from 5 to 45")
    private String last_name;
    @Pattern(regexp = "(090|070)+\\d{7}", message = "must be 10 numbers & start with 090 or 070")
    private String phone_number;
    @Min(18)
    private Integer age;
    @Pattern(regexp = "[A-Z0-9._%-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,4}", message = "Email is wrong format")
    private String email;

    public UserDTO() {
    }

    public UserDTO(String id, String first_name, String last_name, String phone_number, Integer age, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.age = age;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
