//package com.hosiptal.web.service;
//
//import com.hosiptal.web.models.Supervisor;
//import com.hosiptal.web.repository.SupervisorRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private SupervisorRepository supervisorRepository;
//
//    public CustomUserDetailsService(SupervisorRepository supervisorRepository) {
//        this.supervisorRepository = supervisorRepository;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Supervisor supervisor = supervisorRepository.findByName(username);
//
//        if (supervisor == null) {
//            throw new UsernameNotFoundException("Not found!");
//        }
//
//        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
//                supervisor.getName(),
//                supervisor.getPassword(), new ArrayList<>()
//        );
//
//        return userDetails;
//    }
//}
