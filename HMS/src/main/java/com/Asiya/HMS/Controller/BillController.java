package com.Asiya.HMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Asiya.HMS.Models.Appointment;
import com.Asiya.HMS.Models.Bill;
import com.Asiya.HMS.Service.BillService;

import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/bills")

public class BillController {
    
  @Autowired
  private BillService billService;
      
    @GetMapping
    public List<Bill> getAllBills(){
        System.out.println("fetching the Bill");
        return billService.getAllBills() ;
    }

    @PostMapping 
    public Bill createBills(@RequestBody Bill bill){
           System.out.println("Creating Bills");
           return billService.createBill(bill);
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id){
         System.out.println("fetching Bills by id");
         return billService.getBillById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id){
      System.out.println("delete Bills with id" + id);
      billService.deleteBill(id);
    }
    
    @PutMapping("/{id}")
    public void updateBill(@PathVariable Long id, @RequestBody Bill bill){
         System.out.println("updating Bills with id" + id);
         billService.updateBill(id,bill);
    }
}
