package com.Asiya.HMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Asiya.HMS.Models.Patient;




@Repository
public interface PatientsRepository extends JpaRepository<Patient,Long> {
   
}
