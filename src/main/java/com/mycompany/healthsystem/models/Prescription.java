/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.models;

/**
 *
 * @author Rochana Godigamuwa
 */
public class Prescription {
    
    // Define the variables
    private Integer prescriptionId;
    private Patient patient;
    private Doctor doctor;
    private String dosage;
    private String instructions;
    private Integer duration;
    
    // Constructors
    public Prescription(){
        
    }
    
    public Prescription(Integer prescriptionId, Patient patient, Doctor doctor, String dosage, String instructions, Integer duration) {
        this.prescriptionId = prescriptionId;
        this.patient = patient;
        this.doctor = doctor;
        this.dosage = dosage;
        this.instructions = instructions;
        this.duration = duration;
    }
    
    // Getters and Setters
    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
