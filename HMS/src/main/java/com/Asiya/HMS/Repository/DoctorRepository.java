package com.Asiya.HMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Asiya.HMS.Models.Doctor;

@Repository
public interface DoctorRepository  extends JpaRepository<Doctor,Long>{
    
}
