package com.Asiya.HMS.Service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;


import com.Asiya.HMS.Models.Patient;
import com.Asiya.HMS.Repository.PatientsRepository;

import org.springframework.data.domain.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PatientsService {
    
   private static final Logger logger  = LoggerFactory.getLogger(PatientsService.class);
    
   @Autowired
   private PatientsRepository patientsRepository;
    public Page<Patient> getAllPatients(int page,int size){
      
        try{
          System.out.println("from service layer");
         // return patientsRepository.findAll();
          Pageable pageable  = PageRequest.of(page , size);
          return patientsRepository.findAll(pageable);
        }catch(Exception e){
           System.err.println("error massage" +  e.getMessage());
           logger.error("An error occured while fetching patients: {}", e.getMessage());
           return null;
        } 
    }


    public Patient getPatientById(Long id){
         try{
           return patientsRepository.findById(id).orElse(null);
         }catch(Exception e){
            System.err.println("error massage" +  e.getMessage());
             logger.error("An error occured while fetching patient by id {}: {}",id , e.getMessage());
           return null;
         }
    }
     public Patient createPatient(Patient patient){
         try{
              patientsRepository.save(patient);
              return patient;
         }catch(Exception e){
            System.err.println("error massage" +  e.getMessage());
             logger.error("An error occured while creating patients: {}", e.getMessage());
           return null;
         }
    }
     public void deletePatients(Long id){
         try{
            logger.info("deleting patient with id : {}",id);
            patientsRepository.deleteById(id);
         }catch(Exception e){
            System.err.println("error massage" +  e.getMessage());
             logger.error("An error occured while deleting patients: {}", e.getMessage());
           
         }
    }

    public Patient updatePatients(Long id , Patient updatePatient){
         try{
             Optional <Patient> existingPatients = patientsRepository.findById(id);
             if(existingPatients.isPresent()){
               Patient p = existingPatients.get();
               p.setName(updatePatient.getName());
                Patient savedPatient = patientsRepository.save(p);
               return savedPatient;
             }else{
               logger.error("Patients with id {} not found",id);
               return null;
             }
         }catch(Exception e){
            System.err.println("error massage" +  e.getMessage());
             logger.error("An error occured while updating  patients by id: {}",id , e.getMessage());
           return null;
         }
    }
}
