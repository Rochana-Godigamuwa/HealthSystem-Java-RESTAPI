/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.dao;

// Import necessary libraries
import com.mycompany.healthsystem.models.Doctor;
import com.mycompany.healthsystem.models.Patient;
import com.mycompany.healthsystem.models.Prescription;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author thisa
 */

public class PrescriptionDAO {

    // Initialize the logger
    private static final Logger logger = Logger.getLogger(PrescriptionDAO.class.getName());
    
    // Create a list to store the prescription objects
    private static List<Prescription> prescriptions = new ArrayList<>();

    // Add some sample data to the prescriptions list
    static {
        prescriptions.add(new Prescription(1, new Patient(1, "Sadesh Weerasuriya", 123123, "Kandy Sheet", "No History", "Good"), new Doctor(1, "Dr. Messi", 123456789, "123 Main St", "Dentist", "1232132"), "Dosage 1", "Instructions 1", 7));
        prescriptions.add(new Prescription(2, new Patient(2, "Bob Brown", 1323123, "No.53 /Aber/UK", "105 Sugar Level", "Normal"), new Doctor(2, "Dr. Leo", 987654321, "456 Elm St", "Cardiologist", "231232"), "Dosage 2", "Instructions 2", 14));
    }

    // Retrieve all the data in the prescriptions list
    public List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }

    // Retrieve all the data to the specific prescriptions in the list
    public Prescription getPrescriptionById(Integer prescriptionId) {
        for (Prescription prescription : prescriptions) {
            if (prescription.getPrescriptionId().equals(prescriptionId)) {
                logger.info("Successfully retrieved the data of the prescription with ID: " + prescriptionId);
                return prescription;
            }
        }
        return null;
    }

    // Add a prescription object to the prescriptions list  
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
        logger.info("Added prescription with ID: " + prescription.getPrescriptionId());
    }

    // Update the values of a existing prescription in the prescriptions list  
    public void updatePrescription(Prescription updatedPrescription) {
        for (int i = 0; i < prescriptions.size(); i++) {
            if (prescriptions.get(i).getPrescriptionId().equals(updatedPrescription.getPrescriptionId())) {
                prescriptions.set(i, updatedPrescription);
                logger.info("Updated prescription with ID: " + updatedPrescription.getPrescriptionId());
                return;
            }
        }
    }

    // Delete an existing prescription from the prescriptions list
    public void deletePrescription(Integer prescriptionId) {
        for (int i = 0; i < prescriptions.size(); i++) {
            if (prescriptions.get(i).getPrescriptionId().equals(prescriptionId)) {
                prescriptions.remove(i);
                logger.info("Deleted prescription with ID: " + prescriptionId);
                return;
            }
        }
    }
}