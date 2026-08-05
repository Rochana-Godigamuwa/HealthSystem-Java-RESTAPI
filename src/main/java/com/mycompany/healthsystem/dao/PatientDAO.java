/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.dao;

import com.mycompany.healthsystem.models.Patient;
import com.mycompany.healthsystem.models.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Rochana Godigamuwa
 */

public class PatientDAO {
    
    // Initialize the logger 
    private static final Logger logger = Logger.getLogger(PatientDAO.class.getName());
   
    // Create a list to store the Patient objects
    private static List<Patient> patients = new ArrayList<>();
    
    // Import the persons list from the PersonDAO
    private static List<Person> persons = PersonDAO.persons;
    
    // Add some sample data to the patients list
    static {
        patients.add(new Patient(1, "Sadesh Weerasuriya", 45556564, "Kandy sheet japan", "No History", "Good"));
        patients.add(new Patient(2, "Sachin Wanija", 21432552, "A/44 ,  Monaragala", "105 Sugar Level", "Normal"));
        patients.add(new Patient(3, "Charlie Davis", 43145242, "4/33 Area 1", "Allergy to Penciluim", "Stable"));
    }

    // Retrieve all the data in the patients list
    public static List<Patient> getAllPatients() {
        return patients;
    }
    
    // Retrieve all the data to the specific user in the list
    public Patient getPatientById(Integer id) {
        for(Patient patient : patients) {
            if (patient.getId().equals(id)) {
                logger.info("Successfully retrieved the data of the patient whose id of " + patient.getId());
                return patient; 
            }
        } return null;
    }
    
    // Add a person object to the patients list
    public static void addPatient(Patient patient) {
        patients.add(patient);
        logger.info("Added person with ID: " + patient.getId());
    } 
    
    // Update the values of a existing patient in the patients list
    public static void updatePatient(Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId().equals(updatedPatient.getId())) {
                patients.set(i, updatedPatient);
                logger.info("Updated person with ID: " + updatedPatient.getId());
                return;
            } 
        }
    }  
    
    // Delete an existing patient from the patients list
    public static void deletePatient(Integer id) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId().equals(id)) {
                patients.remove(i);
                logger.info("Deleted person with ID: " + id);
                return;
            }
        }
    }      
}
