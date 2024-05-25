package com.hosiptal.web.controller;


import com.hosiptal.web.dtos.EmployeeDto;
import com.hosiptal.web.models.Employee;
import com.hosiptal.web.models.Supervisor;
import com.hosiptal.web.repository.EmployeeRepository;
import com.hosiptal.web.repository.SupervisorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    EmployeeRepository employeeRepository;
    SupervisorRepository supervisorRepository;

    public EmployeeController(EmployeeRepository employeeRepository , SupervisorRepository supervisorRepository) {
        this.employeeRepository = employeeRepository;
        this.supervisorRepository = supervisorRepository;
    }

    //part for supervisor

    @GetMapping("/all/")
    public String getAllEmployee(@RequestParam("id") Long id, Model model){
        List<Employee> employeeList = this.employeeRepository.findBySupervisorId(id);
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("id",id);
        return "all-employee";
    }
 @GetMapping("/createEmployee/")
    public String createEmployeeInterface(@RequestParam("id") Long id,Model model){
        model.addAttribute("id",id);
        return "create-employee";
    }
    
    @PostMapping("/createEmployee/")
    public String createEmployee(EmployeeDto employeeDto){
        Supervisor supervisor = this.supervisorRepository.findById(employeeDto.supervisor_id).get();
        Employee employee = new Employee(employeeDto,supervisor);
        this.employeeRepository.save(employee);
        return "redirect:/employee/all/?id="+employeeDto.supervisor_id;
    }

   

    @GetMapping("/delete/")
    public String deleteEmployee(@RequestParam("id") Long id){
        Long idSupervisor = this.employeeRepository.findById(id).get().getSupervisor().getId();
        this.employeeRepository.deleteById(id);
        return "redirect:/employee/all/?id="+idSupervisor;
    }

    @GetMapping("/update")
    public String updateEmployeeInterface(@RequestParam("idE") Long idE,@RequestParam("idS") Long idS,Model model){
        Optional<Employee> employee = this.employeeRepository.findById(idE);
        model.addAttribute("employee",employee.get());
        model.addAttribute("idE",idE);
        model.addAttribute("idS",idS);
        return "update-employee";
    }

    @PostMapping("/update/{idE}/{idS}/")
    public String updateEmployee(EmployeeDto employeeDto,@PathVariable("idE") Long idE,@PathVariable("idS") Long idS){
        Optional<Supervisor> supervisor = this.supervisorRepository.findById(idS);
        Employee employee = new Employee(idE,employeeDto,supervisor.get());
        this.employeeRepository.save(employee);
        return "redirect:/employee/all/?id="+idS;
    }

    //part for employee
    @GetMapping("/login")
    public String getEmployeeLoginInterface(){
        return "employee-login";
    }

    @GetMapping("/login/")
    public String employeeLogin(@RequestParam("name") String name,@RequestParam("password") String password){
        Employee employee = this.employeeRepository.findByNameAndPassword(name , password);
        if(employee!=null){
            return "redirect:/employee/manager/?id="+employee.getId();
        }
        return "failure";
    }

    @GetMapping("/manager/")
    public String employeeManager(@RequestParam("id") Long id,Model model){
        model.addAttribute("id",id);
        return "employee-manager";
    }

}
