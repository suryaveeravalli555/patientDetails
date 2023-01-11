package com.patientMicroService.patientDetails.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.patientMicroService.patientDetails.model.PatientDetails;
import com.patientMicroService.patientDetails.repository.PatientRepository;
import com.patientMicroService.patientDetails.service.PatientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @PostMapping("/add")
    public ResponseEntity<String> insertCrops(@RequestBody PatientDetails patientDetails) {
        try {
            patientService.save(patientDetails);
            return new ResponseEntity<String>("Patient added successfully", HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<String>("There have some problem in the entry", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allPatient")
    public ResponseEntity<Object> getAllCrops(){
        try {
            List<PatientDetails> list=new ArrayList<>();
            patientService.findAll().forEach(list::add);
            if(!list.isEmpty()) {
                return new ResponseEntity<Object>(list, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<Object>("There is no product in the list", HttpStatus.NO_CONTENT);
            }
        }catch(Exception e) {
            return new ResponseEntity<Object>("Connection problem", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatePatient/{productId}")
    public ResponseEntity<Object> updatePatientById(@PathVariable("patientId") int patientId, @RequestBody PatientDetails patientDetails)
    {
        try {
            Optional<PatientDetails> op=patientRepository.findById(patientId);
            if(op.isPresent())
            {
                PatientDetails patientDetails1=op.get();
                patientService.save(patientDetails);
                return new ResponseEntity<Object>("The Data is updated successfully for id "+patientDetails1.getPatientId(), HttpStatus.OK);

            }
            else
            {
                return new ResponseEntity<Object>("PatientID NOT FOUND", HttpStatus.NOT_FOUND);
            }
        }catch(Exception e) {
            return new ResponseEntity<Object>("Connection problem", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletePatient/{patientId}")
    public ResponseEntity<String> deletePatientById(@PathVariable("patientId") int patientId) {
        try {
            Optional<PatientDetails> op = patientRepository.findById(patientId);
            if(op.isPresent()) {
                patientService.deleteById(patientId);
                return new ResponseEntity<String>("Patient deleted Successfully", HttpStatus.OK);
            }
            else {
                return new ResponseEntity<String>("There is no such Patient Id", HttpStatus.NO_CONTENT);
            }
        }catch(Exception e) {
            return new ResponseEntity<String>("Connection problem", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
