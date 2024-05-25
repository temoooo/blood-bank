package com.hosiptal.web.controller;


import com.hosiptal.web.models.BloodStore;
import com.hosiptal.web.repository.BloodStoreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/bloodStore")
public class BloodStoreController {
    private BloodStoreRepository bloodStoreRepository;

    public BloodStoreController(BloodStoreRepository bloodStoreRepository) {
        this.bloodStoreRepository = bloodStoreRepository;
    }

    @GetMapping("/all/")
    public String allBloodStore(@RequestParam("id") Long id , Model model){
        List<BloodStore> bloodStores = this.bloodStoreRepository.findBySupervisorId(id);
        model.addAttribute("bloodStores",bloodStores);
        return "all-store";
    }

}
