package com.hosiptal.web.controller;

import com.hosiptal.web.models.BloodStore;
import com.hosiptal.web.models.DonateHistory;
import com.hosiptal.web.models.Downer;
import com.hosiptal.web.models.Employee;
import com.hosiptal.web.repository.BloodStoreRepository;
import com.hosiptal.web.repository.DonationHistoryRepository;
import com.hosiptal.web.repository.DownerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/donation")
public class DonationHistoryController {

    private DonationHistoryRepository donationHistoryRepository;
    private DownerRepository downerRepository;
    private BloodStoreRepository bloodStoreRepository;

    public DonationHistoryController(DonationHistoryRepository donationHistoryRepository,DownerRepository downerRepository,BloodStoreRepository bloodStoreRepository) {
        this.donationHistoryRepository = donationHistoryRepository;
        this.downerRepository = downerRepository;
        this.bloodStoreRepository = bloodStoreRepository;
    }

    @GetMapping("/all/")
    public String allDonation(@RequestParam("id") Long id, Model model){
        List<DonateHistory> donateHistories = this.donationHistoryRepository.findByDownerId(id);
        model.addAttribute("donationList",donateHistories);
        model.addAttribute("id",id);
        return "all-donation";
    }

    @GetMapping("/create/")
    public String createDonationInterface(@RequestParam("id") Long id,Model model){
        Optional<Downer> downer = this.downerRepository.findById(id);
        model.addAttribute("blood" , downer.get().getBloodType());
        model.addAttribute("id",id);
        return "create-donation";
    }

    @PostMapping("/create/")
    public String createDonation(DonateHistory donateHistory ,@RequestParam("id") Long id ,Model model){
        Optional<Downer> downer = this.downerRepository.findById(id);
        model.addAttribute("blood" , downer.get().getBloodType());
        //update blood store
        Long idSupervisor = downer.get().getEmployee().getSupervisor().getId();
        BloodStore bloodStore = this.bloodStoreRepository.findBySupervisorIdAndBloodType(idSupervisor,downer.get().getBloodType());
        bloodStore.setQuantity(Integer.parseInt(bloodStore.getQuantity())+Integer.parseInt(donateHistory.getQuantity())+"");
        bloodStore.setPlasma(Integer.parseInt(bloodStore.getPlasma())+Integer.parseInt(donateHistory.getPlasma())+"");
        bloodStore.setPlatelets(Integer.parseInt(bloodStore.getPlatelets())+Integer.parseInt(donateHistory.getPlatelets())+"");
        bloodStore.setRedBloodCells(Integer.parseInt(bloodStore.getRedBloodCells())+Integer.parseInt(donateHistory.getRedBloodCells())+"");
        this.bloodStoreRepository.save(bloodStore);
        //finish update

        donateHistory.setDowner(downer.get());
        this.donationHistoryRepository.save(donateHistory);
        return "redirect:/donation/all/?id="+downer.get().getId();
    }

    @GetMapping("/update/")
    public String updateDonationInterface(@RequestParam("id") Long id,Model model){
        Optional<DonateHistory> donateHistory = this.donationHistoryRepository.findById(id);
        model.addAttribute("donation",donateHistory.get());
        return "update-donation";
    }

    @PostMapping("/update/")
    public String updateDonation(DonateHistory donateHistory,@RequestParam("id") Long id){

        // جبنا الشي اللقديم بالمخزون و جبنا التبرع القديم للمتبرع و جبنا التبرع الجديد عن طريق الفورم و عملنا المخزون - القديم + الجديد
        Downer downer = this.donationHistoryRepository.findById(id).get().getDowner();
        Employee employee = downer.getEmployee();
        DonateHistory oldDonateHistory = this.donationHistoryRepository.findById(id).get();

        //update blood store
        Long idSupervisor = employee.getSupervisor().getId();
        BloodStore bloodStore = this.bloodStoreRepository.findBySupervisorIdAndBloodType(idSupervisor,oldDonateHistory.getBloodType());
        bloodStore.setQuantity(Integer.parseInt(bloodStore.getQuantity())+Integer.parseInt(donateHistory.getQuantity())-Integer.parseInt(oldDonateHistory.getQuantity())+"");
        bloodStore.setPlasma(Integer.parseInt(bloodStore.getPlasma())+Integer.parseInt(donateHistory.getPlasma())-Integer.parseInt(oldDonateHistory.getPlasma())+"");
        bloodStore.setPlatelets(Integer.parseInt(bloodStore.getPlatelets())+Integer.parseInt(donateHistory.getPlatelets())-Integer.parseInt(oldDonateHistory.getPlatelets())+"");
        bloodStore.setRedBloodCells(Integer.parseInt(bloodStore.getRedBloodCells())+Integer.parseInt(donateHistory.getRedBloodCells())-Integer.parseInt(oldDonateHistory.getRedBloodCells())+"");
        this.bloodStoreRepository.save(bloodStore);
        //finish update

        donateHistory.setId(id);
        donateHistory.setDowner(downer);
        this.donationHistoryRepository.save(donateHistory);
        return "redirect:/donation/all/?id="+downer.getId();
    }

    @GetMapping("/delete/")
    public String deleteDonation(@RequestParam("id") Long id){
        DonateHistory donateHistory = this.donationHistoryRepository.findById(id).get();
        Downer downer = donateHistory.getDowner();
        Long idSuper = downer.getEmployee().getSupervisor().getId();
        BloodStore bloodStore = this.bloodStoreRepository.findBySupervisorIdAndBloodType(idSuper,donateHistory.getBloodType());
        //update
        bloodStore.setQuantity(Integer.parseInt(bloodStore.getQuantity())-Integer.parseInt(donateHistory.getQuantity())+"");
        bloodStore.setPlatelets(Integer.parseInt(bloodStore.getPlatelets())-Integer.parseInt(donateHistory.getPlatelets())+"");
        bloodStore.setRedBloodCells(Integer.parseInt(bloodStore.getRedBloodCells())-Integer.parseInt(donateHistory.getRedBloodCells())+"");
        bloodStore.setPlasma(Integer.parseInt(bloodStore.getPlasma())-Integer.parseInt(donateHistory.getPlasma())+"");
        //finish
        this.bloodStoreRepository.save(bloodStore);
        this.donationHistoryRepository.deleteById(id);
        return "redirect:/donation/all/?id="+downer.getId();
    }

}
