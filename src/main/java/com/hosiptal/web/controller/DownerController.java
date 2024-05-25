package com.hosiptal.web.controller;


import com.hosiptal.web.models.Downer;
import com.hosiptal.web.models.Employee;
import com.hosiptal.web.repository.DownerRepository;
import com.hosiptal.web.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/downer")
public class DownerController {

    private DownerRepository downerRepository;
    private EmployeeRepository employeeRepository;

    public DownerController(DownerRepository downerRepository,EmployeeRepository employeeRepository){
        this.downerRepository = downerRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/all/")
    public String getAllDowner(@RequestParam("id") Long id,Model model){
        List<Downer> downers = this.downerRepository.findByEmployeeId(id);
        model.addAttribute("downerList",downers);
        return "all-downer";
    }

    @GetMapping("/create/")
    public String createDownerInterface(@RequestParam("id") Long id, Model model){
        model.addAttribute("id",id);
        return "create-downer";
    }

    @PostMapping("/create/")
    public String createDowner(Downer downer , @RequestParam("id") Long id){
        Optional<Employee> employee = this.employeeRepository.findById(id);
        downer.setEmployee(employee.get());
        this.downerRepository.save(downer);
        return "redirect:/employee/manager/?id="+id;
    }

}
