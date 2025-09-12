package com.Asiya.HMS.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.Asiya.HMS.Models.Appointment;
import com.Asiya.HMS.Models.Bill;
import com.Asiya.HMS.Repository.BillRepository;

@Service
public class BillService {
     private static final Logger logger  = LoggerFactory.getLogger(BillService.class);

     @Autowired
     private BillRepository billRepository;
     public List<Bill> getAllBills(){
      
        try{
          System.out.println("into Billservice layer");
          return billRepository.findAll();
        }catch(Exception e){
           System.err.println("error massage" +  e.getMessage());
           logger.error("An error occured while fetching Bills {}", e.getMessage());
           return null;
        } 
    }


    public Bill createBill(Bill bill){
         try{
            return billRepository.save(bill);
         }catch(Exception e){
            System.err.println("error massage" +  e.getMessage());
             logger.error("An error occured while creating bill {}: {}", bill , e.getMessage());
           return null;
         }
    }
     public Bill getBillById(Long id){
         try{
            return billRepository.findById(id).orElse(null);
         }catch(Exception e){
            System.err.println("error massage" +  e.getMessage());
             logger.error("An error occured while getting bill by id: {}",id, e.getMessage());
           return null;
         }
    }
     public void deleteBill(Long id){
         try{
            billRepository.deleteById(id);
         }catch(Exception e){
            System.err.println("error massage" +  e.getMessage());
             logger.error("An error occured while deleting Bill {}",id, e.getMessage());
           
         }
    }

    public Bill updateBill(Long id,Bill updateBill){
         try{
             Bill existingBill = billRepository.findById(id).orElse(null);
        
        if (existingBill == null) {
            logger.error("Appointment with id {} not found", id);
            return null; // ✅ Add return statement for null case
        }
        
        existingBill.setPatientId(updateBill.getPatientId());
        existingBill.setAmount(updateBill.getAmount());
        existingBill.setStatus(updateBill.getStatus());
        
        return billRepository.save(existingBill);
         }catch(Exception e){
            System.err.println("error massage" +  e.getMessage());
             logger.error("An error occured while updating  Bill by id: {}",id , e.getMessage());
           return null;
         }
    }
    
}
