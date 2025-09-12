package com.Asiya.HMS.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

import com.Asiya.HMS.Models.Appointment;
import com.Asiya.HMS.Models.Bill;
import com.Asiya.HMS.Models.Patient;
import com.Asiya.HMS.Repository.AppointmentRepository;

@Service
public class AppointmentService {
      private static final Logger logger  = LoggerFactory.getLogger(AppointmentService.class);
         @Autowired
         private AppointmentRepository appointmentRepository;

      public List<Appointment> getAllAppointments(){
      
        try{
          System.out.println("into Appointment service layer");
           return appointmentRepository.findAll();
        }catch(Exception e){
           System.err.println("error massage" +  e.getMessage());
           logger.error("An error occured while fetching Appointments {}", e.getMessage());
           return Collections.emptyList();
        } 
    }


    public Appointment createAppointment(Appointment appoinment){
         try{
              return appointmentRepository.save(appoinment);
         
         }catch(Exception e){
            System.err.println("error massage" +  e.getMessage());
             logger.error("An error occured while creating Appointment {}: {}", appoinment , e.getMessage());
           return null;
         }
    }
     public Appointment getAppointmentById(Long id){
         try{
             return appointmentRepository.findById(id).orElse(null);
         }catch(Exception e){
            System.err.println("error massage" +  e.getMessage());
             logger.error("An error occured while getting appointment by id {}:{}",id, e.getMessage());
           return null;
         }
    }
     public void deleteAppointment(Long id){
         try{
            logger.info("deleting patient with id : {}",id);
            appointmentRepository.deleteById(id);
         }catch(Exception e){
            System.err.println("error massage" +  e.getMessage());
             logger.error("An error occured while deleting Appointment {}: {}",id, e.getMessage());
           
         }
    }

    public Appointment updateAppointment(Long id, Appointment updateAppointment) {
    try {
        Appointment existingAppointment = appointmentRepository.findById(id).orElse(null);
        
        if (existingAppointment == null) {
            logger.error("Appointment with id {} not found", id);
            return null; // ✅ Add return statement for null case
        }
        
        existingAppointment.setPatientId(updateAppointment.getPatientId());
        existingAppointment.setDoctorId(updateAppointment.getDoctorId());
        existingAppointment.setDate(updateAppointment.getDate());
        
        return appointmentRepository.save(existingAppointment);
    } catch (Exception e) {
        System.err.println("error message: " + e.getMessage());
        logger.error("An error occurred while updating Appointment by id {}: {}", id, e.getMessage());
        return null; // ✅ Add return statement for exception case
    }
   }
}
