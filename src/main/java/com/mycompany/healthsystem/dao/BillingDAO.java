/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.dao;

// Import necessary libraries
import com.mycompany.healthsystem.models.Billing;
import com.mycompany.healthsystem.models.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Rochana
 */

public class BillingDAO {
    
    // Initialize the logger 
    private static final Logger logger = Logger.getLogger(BillingDAO.class.getName());
    
    // Create a list to store the bill objects
    private static List<Billing> billings = new ArrayList<>();
    
    // Add some sample data to the billing list
    static {
        billings.add(new Billing(1, 100.0, 50.0, new Patient(1, "Chandupa Marapana", 543453453, "A/30 Kegalle", "No History", "Good")));
        billings.add(new Billing(2, 150.0, 75.0, new Patient(2, "Imal Godi", 315315132, "A/66 , GoneSheet", "150 Sugar Level", "High")));
    }

    // Retrieve all the data in the billing list
    public List<Billing> getAllBillings() {
        return billings;
    }
    
    // Retrieve all the data to the specific bill in the list
    public Billing getBillingById(Integer billingId) {
        for (Billing billing : billings) {
            if (billing.getBillingId().equals(billingId)) {
                logger.info("Successfully retrieved the data of the billing with ID: " + billingId);
                return billing;
            }
        }
        return null;
    }
    
    // Add a bill object to the billing list 
    public void addBilling(Billing billing) {
        billings.add(billing);
        logger.info("Added billing with ID: " + billing.getBillingId());
    }    
    
    // Update the values of a existing bill in the billing list  
    public void updateBilling(Billing updatedBilling) {
        for (int i = 0; i < billings.size(); i++) {
            if (billings.get(i).getBillingId().equals(updatedBilling.getBillingId())) {
                billings.set(i, updatedBilling);
                logger.info("Updated billing with ID: " + updatedBilling.getBillingId());
                return;
            }
        }
    } 
    
    // Delete an existing bill from the billing list
    public void deleteBilling(Integer billingId) {
        for (int i = 0; i < billings.size(); i++) {
            if (billings.get(i).getBillingId().equals(billingId)) {
                billings.remove(i);
                logger.info("Deleted billing with ID: " + billingId);
                return;
            }
        }
    }  
}