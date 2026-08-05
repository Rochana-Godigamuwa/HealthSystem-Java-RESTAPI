/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.models;

/**
 *
 * @author Rochana Godigamuwa
 */
public class MedicalRecord {
    
    // Define the variables
    private Integer medicalRecordId;
    private Patient patient;
    private String diagnoses;
    private String treatments;
    
    // Constructors
    public MedicalRecord() {
    }
    
    public MedicalRecord(Integer medicalRecordId, String diagnoses, String treatments, Patient patient) {
        this.medicalRecordId = medicalRecordId;
        this.patient = patient;
        this.diagnoses = diagnoses;
        this.treatments = treatments;
    }
    
    // Getters and Setters

    public Integer getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(Integer MedicalRecordId) {
        this.medicalRecordId = MedicalRecordId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }
}
