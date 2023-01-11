package com.patientMicroService.patientDetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.patientMicroService.patientDetails.model.PatientDetails;

@Repository
public interface PatientRepository extends MongoRepository<PatientDetails, Integer> {
}
