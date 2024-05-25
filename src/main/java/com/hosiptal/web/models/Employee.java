package com.hosiptal.web.models;


import com.hosiptal.web.dtos.EmployeeDto;
import jakarta.persistence.*;


@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(255)", nullable = false)
    private String name;

    @Column(name = "password", columnDefinition = "VARCHAR(255)", nullable = false)
    private String password;

    @Column(name = "phone", columnDefinition = "VARCHAR(255)", nullable = false)
    private String phone;

    @Column(name = "month-salary", columnDefinition = "VARCHAR(255)", nullable = false)
    private String monthSalary;

    @Column(name = "department", columnDefinition = "VARCHAR(255)", nullable = false)
    private String department;

    @Column(name = "university-degree", columnDefinition = "VARCHAR(255)", nullable = false)
    private String universityDegree;

    @ManyToOne
    @JoinColumn(name = "supervisor-id")
    private Supervisor supervisor;


    public Employee(EmployeeDto employeeDto, Supervisor supervisor) {
        this.name = employeeDto.name;
        this.password = employeeDto.password;
        this.phone = employeeDto.phone;
        this.monthSalary = employeeDto.monthSalary;
        this.department = employeeDto.department;
        this.universityDegree = employeeDto.universityDegree;
        this.supervisor = supervisor;
    }

    public Employee(Long id,EmployeeDto employeeDto,Supervisor supervisor){
        this.id = id;
        this.name = employeeDto.name;
        this.password = employeeDto.password;
        this.phone = employeeDto.phone;
        this.monthSalary = employeeDto.monthSalary;
        this.department = employeeDto.department;
        this.universityDegree = employeeDto.universityDegree;
        this.supervisor = supervisor;
    }

    public Employee(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getMonthSalary() {
        return monthSalary;
    }

    public String getDepartment() {
        return department;
    }

    public String getUniversityDegree() {
        return universityDegree;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMonthSalary(String monthSalary) {
        this.monthSalary = monthSalary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setUniversityDegree(String universityDegree) {
        this.universityDegree = universityDegree;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}
