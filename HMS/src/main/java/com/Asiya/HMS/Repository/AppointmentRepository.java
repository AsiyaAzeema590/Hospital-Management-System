package com.Asiya.HMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Asiya.HMS.Models.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    
}
