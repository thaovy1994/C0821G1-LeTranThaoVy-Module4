package com.case_study.dto;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;

public class EmployeeDto {
    private Integer employeeId;

    private String name;

    private String birthDay;

    private String idCard;

    private Double salary;
    @Pattern(regexp = "(090|091|(84)+90|(84)+91)+\\d{7}", message = "must be 10 numbers & start with 090 or 070")
    private String phone;

    private String email;

    private String address;
}
