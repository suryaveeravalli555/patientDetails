package com.patientMicroService.patientDetails.service;


import org.springframework.stereotype.Service;

import com.patientMicroService.patientDetails.model.PatientDetails;

import java.util.List;

@Service
public interface PatientService {

    List<PatientDetails> findAll();

    PatientDetails save(PatientDetails crop);

    void deleteById(int patientId);

    PatientDetails findById(int id);
}
