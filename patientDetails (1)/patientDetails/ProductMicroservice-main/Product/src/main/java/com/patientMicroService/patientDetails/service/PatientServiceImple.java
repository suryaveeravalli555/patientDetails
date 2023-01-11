package com.patientMicroService.patientDetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientMicroService.patientDetails.model.PatientDetails;
import com.patientMicroService.patientDetails.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImple implements PatientService{

    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<PatientDetails> findAll() {
        List<PatientDetails> list=patientRepository.findAll();
        System.out.println(list);
        return list;
    }

    @Override
    public PatientDetails save(PatientDetails patientDetails) {
        System.out.println(patientDetails);
        return patientRepository.save(patientDetails);
    }

    @Override
    public void deleteById(int patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public PatientDetails findById(int id) {
        Optional<PatientDetails> op = patientRepository.findById(id);
        if(op.isPresent()) {
            PatientDetails patientDetails=op.get();
            return patientDetails;
        }
        else {
            return null;
        }
    }
}
