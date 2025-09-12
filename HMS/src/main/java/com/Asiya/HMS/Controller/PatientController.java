package com.Asiya.HMS.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

// import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.Asiya.HMS.Models.*;
import com.Asiya.HMS.Service.PatientsService;
import org.springframework.data.domain.Page;

import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/v1/patients")

public class PatientController {

    
     
    @Autowired
    private PatientsService  patientsService;

    // PatientController(Controller.AppointmentController appointmentController) {
    //     this.appointmentController = appointmentController;
    // }
    
    @GetMapping
    public Page <Patient> getAllPatients(@RequestParam(defaultValue = "0")int page ,
                                       @RequestParam(defaultValue = "2")int size){
        System.out.println("fetching the patients");
        return patientsService.getAllPatients(page,size);

    }

    @PostMapping 
    public Patient createPatient(@RequestBody Patient patient){
           System.out.println("Creating Patients");
           return patientsService.createPatient(patient);
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
         System.out.println("fetching patiets by id");
         return patientsService.getPatientById(id);
    }
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id){
        System.out.println("delelting patients by id");
         patientsService.deletePatients(id);
    }
    
    @PutMapping("/{id}")
    public void updatePatients(@PathVariable Long id, @RequestBody Patient patient){
        System.out.println("updating patients by id");
            patientsService.updatePatients(id,patient);
    }
}
