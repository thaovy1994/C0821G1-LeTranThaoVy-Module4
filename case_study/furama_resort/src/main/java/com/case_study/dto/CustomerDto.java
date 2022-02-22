package com.case_study.dto;

import com.case_study.model.customer.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;

public class CustomerDto implements Validator {
    private Integer customerId;
    @NotBlank(message = "First name is not empty")
    @Pattern(regexp = "^[A-Za-z ]+$")
    @Size(min = 2, max = 40, message = "it must be from 2 to 40 words")
    private String firstName;
    @NotBlank(message = "Last name is not empty")
    @Pattern(regexp = "^[A-Za-z ]+$")
    @Size(min = 2, max = 40, message = "it must be from 2 to 40 words")
    private String lastName;
    @NotNull
    @DateTimeFormat
    private String dateOfBirth;
    @NotEmpty(message = "Address is not empty")
    private Integer gender;
    @Pattern(regexp = "(090|091|(84)+90|(84)+91)+\\d{7}", message = "must be 10 numbers & start with 090 or 070")
    private String phone;
    @Pattern(regexp = "^[a-z0-9._!#&%{|}?`*/+-]+@[a-z0-9.-]+.[a-z]{2,4}$", message = "Email is wrong format")
    private String email;
    @NotEmpty(message = "Address is not empty")
    private String address;

    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customerType_id", referencedColumnName = "customerType_id")
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(Integer customerId, String firstName, String lastName, String dateOfBirth, Integer gender,
                       String phone, String email, String address, CustomerType customerType) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
