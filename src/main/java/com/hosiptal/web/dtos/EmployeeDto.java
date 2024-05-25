package com.hosiptal.web.dtos;


public class EmployeeDto {
    public String name;

    public String password;

    public String phone;

    public String monthSalary;

    public String department;

    public String universityDegree;

    public Long supervisor_id;



    public EmployeeDto(String name, String password, String phone, String monthSalary, String department, String universityDegree, Long supervisor_id) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.monthSalary = monthSalary;
        this.department = department;
        this.universityDegree = universityDegree;
        this.supervisor_id = supervisor_id;
    }

}
