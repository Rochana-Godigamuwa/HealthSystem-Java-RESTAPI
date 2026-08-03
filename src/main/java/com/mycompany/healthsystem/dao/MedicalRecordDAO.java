/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.dao;

import com.mycompany.healthsystem.models.MedicalRecord;
import com.mycompany.healthsystem.models.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author thisa
 */
public class MedicalRecordDAO {
    
    // Initialize the logger 
    private static final Logger logger = Logger.getLogger(MedicalRecordDAO.class.getName());
    
    // Create a list to store the medical record objects
    private static List<MedicalRecord> medicalRecords = new ArrayList<>();
    
    // Add some sample data to the medical records list
    static {
        medicalRecords.add(new MedicalRecord(1, "Common Cold", "Rest and fluids", new Patient(1, "Alice Johnson", 123123, "No.23 /Baker/US", "No History", "Good")));
        medicalRecords.add(new MedicalRecord(2, "Sprained Ankle", "Rest, Ice, Compression, Elevation", new Patient(2, "Bob Brown", 1323123, "No.53 /Aber/UK", "105 Sugar Level", "Normal")));
    }

    // Retrieve all the data in the medical records list
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecords;
    }
    
    // Retrieve all the data for a specific medical record in the list
    public MedicalRecord getMedicalRecordById(Integer medicalRecordId) {
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getMedicalRecordId().equals(medicalRecordId)) {
                logger.info("Successfully retrieved the data of the medical record with ID: " + medicalRecordId);
                return medicalRecord;
            }
        }
        return null;
    }
    
    // Add a medical record object to the medical records list
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
        logger.info("Added medical record with ID: " + medicalRecord.getMedicalRecordId());
    }    
    
    // Update the values of an existing medical record in the medical records list
    public void updateMedicalRecord(MedicalRecord updatedMedicalRecord) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            if (medicalRecords.get(i).getMedicalRecordId().equals(updatedMedicalRecord.getMedicalRecordId())) {
                medicalRecords.set(i, updatedMedicalRecord);
                logger.info("Updated medical record with ID: " + updatedMedicalRecord.getMedicalRecordId());
                return;
            }
        }
    } 
    
    // Delete an existing medical record from the medical records list
    public void deleteMedicalRecord(Integer medicalRecordId) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            if (medicalRecords.get(i).getMedicalRecordId().equals(medicalRecordId)) {
                medicalRecords.remove(i);
                logger.info("Deleted medical record with ID: " + medicalRecordId);
                return;
            }
        }
    }  
}
