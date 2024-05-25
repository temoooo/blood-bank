package com.hosiptal.web.controller;

import com.hosiptal.web.models.BloodStore;
import com.hosiptal.web.models.BloodTransfusions;
import com.hosiptal.web.models.Employee;
import com.hosiptal.web.repository.BloodStoreRepository;
import com.hosiptal.web.repository.BloodTransfusionsRepository;
import com.hosiptal.web.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/bloodTransfusions")
public class BloodTransfusionsController {

    private BloodTransfusionsRepository bloodTransfusionsRepository;
    private EmployeeRepository employeeRepository;
    private BloodStoreRepository bloodStoreRepository;

    public BloodTransfusionsController(BloodTransfusionsRepository bloodTransfusionsRepository,EmployeeRepository employeeRepository,BloodStoreRepository bloodStoreRepository) {
        this.bloodTransfusionsRepository = bloodTransfusionsRepository;
        this.employeeRepository = employeeRepository;
        this.bloodStoreRepository = bloodStoreRepository;
    }

    @GetMapping("/all/")
    public String allBloodTransfusions(@RequestParam("id") Long id, Model model){
        List<BloodTransfusions> bloodTransfusions = bloodTransfusionsRepository.findByEmployeeId(id);
        model.addAttribute("bloodTransfusions",bloodTransfusions);
        model.addAttribute("id",id);
        return "all-bloodTransfusions";
    }

    @GetMapping("/create/")
    public String createTransfusionsInterface(@RequestParam("id") Long id,Model model){
        model.addAttribute("id",id);
        return "create-transfusions";
    }

    @PostMapping("/create/")
    public String createTransfusions(BloodTransfusions bloodTransfusions , @RequestParam("id") Long id){
        Employee employee = this.employeeRepository.findById(id).get();
        bloodTransfusions.setEmployee(employee);

        //update blood store
        Long idSupervisor = employee.getSupervisor().getId();
        BloodStore bloodStore = this.bloodStoreRepository.findBySupervisorIdAndBloodType(idSupervisor,bloodTransfusions.getBloodType());
        bloodStore.setQuantity(Integer.parseInt(bloodStore.getQuantity())+Integer.parseInt(bloodTransfusions.getQuantity())+"");
        bloodStore.setPlasma(Integer.parseInt(bloodStore.getPlasma())+Integer.parseInt(bloodTransfusions.getPlasma())+"");
        bloodStore.setPlatelets(Integer.parseInt(bloodStore.getPlatelets())+Integer.parseInt(bloodTransfusions.getPlatelets())+"");
        bloodStore.setRedBloodCells(Integer.parseInt(bloodStore.getRedBloodCells())+Integer.parseInt(bloodTransfusions.getRedBloodCells())+"");
        this.bloodStoreRepository.save(bloodStore);
        //finish update

        this.bloodTransfusionsRepository.save(bloodTransfusions);
        return "redirect:/bloodTransfusions/all/?id="+employee.getId();
    }

}
