package com.hosiptal.web.controller;

import com.hosiptal.web.models.Diseases;
import com.hosiptal.web.models.Downer;
import com.hosiptal.web.models.Employee;
import com.hosiptal.web.repository.DiseasesRepository;
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
@RequestMapping("/diseases")
public class DiseasesController {

    private DiseasesRepository diseasesRepository;
    private DownerRepository downerRepository;

    public DiseasesController(DiseasesRepository diseasesRepository,DownerRepository downerRepository) {
        this.diseasesRepository = diseasesRepository;
        this.downerRepository = downerRepository;
    }

    @GetMapping("/all/")
    public String AllDiseases(@RequestParam("id") Long id,Model model){
        List<Diseases> diseases = this.diseasesRepository.findByDownerId(id);
        model.addAttribute("diseases",diseases);
        model.addAttribute("id",id);
        return "all-diseases";
    }

    @GetMapping("/create/")
    public String createExamInterface(@RequestParam("id") Long id , Model model){
        model.addAttribute("id",id);
        return "create-diseases";
    }

    @PostMapping("/create/")
    public String createExam(Diseases diseases,@RequestParam("id") Long id){
        Downer downer = this.downerRepository.findById(id).get();
        diseases.setDowner(downer);
        this.diseasesRepository.save(diseases);
        return "redirect:/diseases/all/?id="+id;
    }
}
