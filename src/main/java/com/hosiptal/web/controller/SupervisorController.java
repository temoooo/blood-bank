package com.hosiptal.web.controller;

import com.hosiptal.web.models.BloodStore;
import com.hosiptal.web.models.Supervisor;
import com.hosiptal.web.repository.BloodStoreRepository;
import com.hosiptal.web.repository.SupervisorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Optional;

@Controller
@RequestMapping("/supervisor")
public class SupervisorController {

    private SupervisorRepository supervisorRepository;
    private BloodStoreRepository bloodStoreRepository;

    public SupervisorController(SupervisorRepository supervisorRepository,BloodStoreRepository bloodStoreRepository) {
        this.supervisorRepository = supervisorRepository;
        this.bloodStoreRepository= bloodStoreRepository;
    }

    @GetMapping("/register/")
    public String createSupervisor(@RequestParam("name") String name ,@RequestParam("password")  String password){
        Supervisor supervisor = this.supervisorRepository.save(new Supervisor(name,password));
        this.bloodStoreRepository.save(new BloodStore("A+","0","0","0","0",supervisor));
        this.bloodStoreRepository.save(new BloodStore("A-","0","0","0","0",supervisor));
        this.bloodStoreRepository.save(new BloodStore("B+","0","0","0","0",supervisor));
        this.bloodStoreRepository.save(new BloodStore("B-","0","0","0","0",supervisor));
        this.bloodStoreRepository.save(new BloodStore("AB+","0","0","0","0",supervisor));
        this.bloodStoreRepository.save(new BloodStore("AB-","0","0","0","0",supervisor));
        this.bloodStoreRepository.save(new BloodStore("O+","0","0","0","0",supervisor));
        this.bloodStoreRepository.save(new BloodStore("O-","0","0","0","0",supervisor));
        return "redirect:/supervisor/manage/?id=" + supervisor.getId();
    }

    @GetMapping("/register")
    public String registerInterface(){
        return "supervisor";
    }

    @GetMapping("/login")
    public String loginInterface(){
        return "login.html";
    }

    @GetMapping("/login/")
    public String getSupervisor(@RequestParam("name") String name ,@RequestParam("password")  String password){
        Optional<Supervisor> supervisor = this.supervisorRepository.findByNameAndPassword(name , password);
        if(supervisor.isPresent()){
            return "redirect:/supervisor/manage/?id="+supervisor.get().getId();
        }
        //don't forget create failure screen
        return "failure";
    }

    @GetMapping("/manage/")
    public String manageOrCreateEmployee(@RequestParam("id") Long id , Model model){
        model.addAttribute("id",id);
        return "manage";
    }

}
