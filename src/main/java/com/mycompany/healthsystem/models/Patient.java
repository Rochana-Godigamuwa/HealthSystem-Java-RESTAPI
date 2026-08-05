/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.models;

/**
 *
 * @author Rochana Godigamuwa
 */

public class Patient extends Person {
    
    //Define the variables
    private Person person;
    private String medicalHistory;
    private String currentHealthStatus;
    
    // Constructors
    public Patient() {
        
    }
        
    public Patient(Integer id, String name, Integer contactInfo, String address, String medicalHistory, String currentHealthStatus) {
        super(id, name, contactInfo, address);
        this.medicalHistory = medicalHistory;
        this.currentHealthStatus = currentHealthStatus;
    }
    
    // Getters and Setters
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }
}
