package com.Asiya.HMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Asiya.HMS.Models.Appointment;
import com.Asiya.HMS.Models.Doctor;
import com.Asiya.HMS.Service.DoctorService;

import  java.util.*;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctor(){
        System.out.println("fetching the Doctors");
        return doctorService.getAllDoctor() ;
    }

    @PostMapping 
    public Doctor createDoctor(@RequestBody Doctor doctor){
           System.out.println("Creating doctors");
           return doctorService.createDoctor(doctor);
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
         System.out.println("fetching Doctor by id");
         return doctorService.getDoctorById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id){
      System.out.println("delete Doctors with id" + id);
       doctorService.deleteDoctor(id);
    }
    
    @PutMapping("/{id}")
    public void updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor){
         System.out.println(" update with id" + id);
         doctorService.updateDoctor(id,doctor);
    }
}
