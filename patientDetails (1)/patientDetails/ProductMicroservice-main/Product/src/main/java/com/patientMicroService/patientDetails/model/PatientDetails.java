package com.patientMicroService.patientDetails.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Patient")
public class PatientDetails {

    @Id
    private int patientId;
    private String patientName;
    private String patientGender;

    public PatientDetails(int patientId, String patientName, String patientGender) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientGender = patientGender;
    }

    public PatientDetails() {
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setProductPrice(String patientGender) {
        this.patientGender = patientGender;
    }
}
