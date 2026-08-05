/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.models;

/**
 *
 * @author Rochana Godigamuwa
 */
public class Doctor extends Person {
    
    // Define the variables
    private String specialization;
    private String contactDetails;
    
    // Constructors
    public Doctor(){
        
    }
    
    public Doctor(Integer id, String name, Integer contactInfo, String address, String specialization, String contactDetails) {
        super(id, name, contactInfo, address);
        this.specialization = specialization;
        this.contactDetails = contactDetails;
    }
   
    // Getters and Setters
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
}
