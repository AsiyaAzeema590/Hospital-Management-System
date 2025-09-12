package com.Asiya.HMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.Asiya.HMS.Models.Appointment;
import com.Asiya.HMS.Models.Patient;
import com.Asiya.HMS.Service.AppointmentService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.Asiya.HMS.Models.Appointment;



@RestController
@RequestMapping("/api/v1/appointments")

public class AppointmentController {

       @Autowired
       private AppointmentService appointmentService;
       
    @GetMapping
    public List<Appointment> getAllAppointments(){
        System.out.println("fetching the Appointments");
        return  appointmentService.getAllAppointments();
    }

    @PostMapping 
    public Appointment createAppointment(@RequestBody Appointment appointment){
           System.out.println("Creating Appointments");
           return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
         System.out.println("fetching Appointment by id" + id);
         return appointmentService.getAppointmentById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id){
        System.out.println("delete Appointment with id" + id);
        appointmentService.deleteAppointment(id);
    }
    
    @PutMapping("/{id}")
public Appointment updateAppointment(@PathVariable Long id , @RequestBody Appointment appoinment){
    
         System.out.println("updating Appointment with id" + id);
         return appointmentService.updateAppointment(id, appoinment);

    }
}
