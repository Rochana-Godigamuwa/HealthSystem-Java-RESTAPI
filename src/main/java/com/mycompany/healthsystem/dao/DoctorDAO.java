/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.dao;

import com.mycompany.healthsystem.models.Doctor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author thisa
 */
public class DoctorDAO {
    
    // Initialize the logger 
    private static final Logger logger = Logger.getLogger(DoctorDAO.class.getName());
   
    // Create a list to store the doctor objects
    static List<Doctor> doctors = new ArrayList<>();
    
    // Add some sample data to the doctors list
    static {
        doctors.add(new Doctor(1, "Dr. Messi", 123456789, "A/30 Somewhere", "Dentist", "1232132"));
        doctors.add(new Doctor(2, "Dr. Leo", 987654321, "V/20 Elm St", "Surgent", "131523135"));
        doctors.add(new Doctor(3, "Dr. Rochana", 111222333, "H/45 Oak St", "Psychiatrist", "353353"));
        doctors.add(new Doctor(4, "Dr. Asanga", 555666777, "Hell/V Pine St", "VP", "383333383"));
        doctors.add(new Doctor(5, "Dr. Me", 888999000, "Paticke sheet", "Dermatologist", "7252525257"));
    }

    // Retrieve all the data in the doctors list
    public static List<Doctor> getAllDoctors() {
        return doctors;
    }
    
    // Retrieve all the data to the specific user in the list
    public Doctor getDoctorById(Integer id) {
        for(Doctor doctor : doctors) {
            if (doctor.getId().equals(id)) {
                logger.info("Successfully retrieved the data of the doctor whose id of " + doctor.getId());
                return doctor; 
            }
        } return null;
    }
    
    // Add a person object to the doctors list
    public static void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        logger.info("Added doctor with ID: " + doctor.getId());
    } 
    
    // Update the values of a existing doctor in the doctors list
    public static void updateDoctor(Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId().equals(updatedDoctor.getId())) {
                doctors.set(i, updatedDoctor);
                logger.info("Updated person with ID: " + updatedDoctor.getId());
                return;
            } 
        }
    }  
    
    // Delete an existing patient from the patients list
    public static void deleteDoctor(Integer id) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId().equals(id)) {
                doctors.remove(i);
                logger.info("Deleted person with ID: " + id);
                return;
            }
        }
    }    
}
