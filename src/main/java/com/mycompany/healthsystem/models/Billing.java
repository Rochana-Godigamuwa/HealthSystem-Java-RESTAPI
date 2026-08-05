/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.models;

// Import necessary libraries
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Rochana Godigamuwa
 */

@JsonPropertyOrder({"billingId", "payment", "outstandingBalances", "patient"})
public class Billing {
    
    // Define the variables
    private Patient patient;
    private Integer billingId;
    private double payment;
    private double outstandingBalances;
    
    // Constructors
    public Billing(){
        
    }
    
    public Billing(Integer billingId, double payment, double outstandingBalances,Patient patient) {
        this.patient = patient;
        this.billingId = billingId;
        this.payment = payment;
        this.outstandingBalances = outstandingBalances;
    }
    
    // Getters and Setters
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Integer getBillingId() {
        return billingId;
    }

    public void setBillingId(Integer billingId) {
        this.billingId = billingId;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getOutstandingBalances() {
        return outstandingBalances;
    }

    public void setOutstandingBalances(double outstandingBalances) {
        this.outstandingBalances = outstandingBalances;
    } 
}
