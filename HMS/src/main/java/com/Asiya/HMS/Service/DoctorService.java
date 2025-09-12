package com.Asiya.HMS.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Asiya.HMS.Models.Bill;
import com.Asiya.HMS.Models.Doctor;
import com.Asiya.HMS.Repository.DoctorRepository;

import java.util.*;

@Service
public class DoctorService {
     private static final Logger logger  = LoggerFactory.getLogger(DoctorService.class);
     
     @Autowired
     DoctorRepository doctorRepository;
     public List<Doctor> getAllDoctor(){
      
        try{
          System.out.println("into Doctorservice layer");
          return doctorRepository.findAll();
        }catch(Exception e){
           System.err.println("error massage" +  e.getMessage());
           logger.error("An error occured while fetching Doctor {}", e.getMessage());
           return null;
        } 
    }


    public Doctor createDoctor(Doctor doctor){
         try{
            return doctorRepository.save(doctor);
         }catch(Exception e){
            System.err.println("error massage" +  e.getMessage());
             logger.error("An error occured while creating Doctor {}: {}", doctor , e.getMessage());
           return null;
         }
    }
     public Doctor getDoctorById(Long id){
         try{
            return doctorRepository.getById(id);
         }catch(Exception e){
            System.err.println("error massage" +  e.getMessage());
             logger.error("An error occured while getting Doctor by id: {}: {}",id, e.getMessage());
           return null;
         }
    }
     public void deleteDoctor(Long id){
         try{
            doctorRepository.deleteById(id);
         }catch(Exception e){
            System.err.println("error massage" +  e.getMessage());
             logger.error("An error occured while deleting Doctor {}: {}",id, e.getMessage());
           
         }
    }

    public Doctor updateDoctor(Long id,Doctor updateDoctor){
         try{
             Doctor existingDoctor = doctorRepository.findById(id).orElse(null);
             
        if (existingDoctor == null) {
            logger.error("Appointment with id {} not found", id);
            return null; // ✅ Add return statement for null case
        }
        
        existingDoctor.setName(updateDoctor.getName());
        existingDoctor.setSpeciality(updateDoctor.getSpeciality());
        existingDoctor.setAge(updateDoctor.getAge());
        
        return doctorRepository.save(existingDoctor);


         }catch(Exception e){
            System.err.println("error massage" +  e.getMessage());
             logger.error("An error occured while updating  Doctor by id: {}:{}",id , e.getMessage());
           return null;
         }
    }
}
