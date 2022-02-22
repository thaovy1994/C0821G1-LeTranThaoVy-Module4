package com.case_study.dto;

import com.case_study.model.Degree;
import com.case_study.model.Division;
import com.case_study.model.Position;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

public class EmployeeDto implements Validator {
    private Integer employeeId;
    @NotBlank(message = "Name is not empty")
    @Pattern(regexp = "^[A-Za-z ]+$")
    @Size(min = 2, max = 40, message = "name must be from 2 to 40 words")
    private String name;
    @NotNull
    @DateTimeFormat
    private String birthDay;
    @NotBlank(message = "not empty ")
    @Pattern(regexp = "[0-9]{9,12}", message = "Number of words from 9 to 12 and must be number")
    private String idCard;
    @Min(value = 1, message = "salary must be positive number")
    private Double salary;
    @Pattern(regexp = "(090|091|(84)+90|(84)+91)+\\d{7}", message = "must be 10 numbers & start with 090 or 070")
    private String phone;
    //@Pattern(regexp = "^[a-z0-9._!#&%{|}?`*/+-]+@[a-z0-9.-]+.[a-z]{2,4}$", message = "Email is wrong format")
    @Email
    private String email;
    @NotEmpty(message = "Address is not empty")
    private String address;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "position_id", referencedColumnName = "position_id")
    private Position position;

    @ManyToOne(targetEntity = Degree.class)
    @JoinColumn(name = "degree_id", referencedColumnName = "degree_id")
    private Degree degree;

    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id", referencedColumnName = "division_id")
    private Division division;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer employeeId, String name, String birthDay, String idCard,
                       Double salary, String phone, String email, String address,
                       Position position, Degree degree, Division division) {
        this.employeeId = employeeId;
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.degree = degree;
        this.division = division;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        if (employeeDto.name.matches("[@;,.= -+…]+")) {
            errors.rejectValue("name", "name.invalidFormat");
        }
    }
}
