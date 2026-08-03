/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.dao;

// Import necessary libraries
import com.mycompany.healthsystem.models.Appointment;
import com.mycompany.healthsystem.models.Doctor;
import com.mycompany.healthsystem.models.Patient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author thisa
 */

public class AppointmentDAO {
    
    // Initialize the logger 
    private static final Logger logger = Logger.getLogger(AppointmentDAO.class.getName());
   
    // Create a list to store the appointment objects
    static List<Appointment> appointments = new ArrayList<>();    
    
    // Add some sample data to the appointments list
    static {
        appointments.add(new Appointment(1, new Date(), "09:00", new Patient(1, "Alice Johnson", 123123, "No.23 /Baker/US", "No History", "Good"), new Doctor(1, "Dr. Smith", 123456789, "123 Main St", "Dentist", "1232132")));
        appointments.add(new Appointment(2, new Date(), "10:00", new Patient(2, "Bob Brown", 1323123, "No.53 /Aber/UK", "105 Sugar Level", "Normal"), new Doctor(2, "Dr. Johnson", 987654321, "456 Elm St", "Cardiologist", "231232")));
    }
    
    // Retrieve all the data in the doctors list
    public static List<Appointment> getAllAppointments() {
        return appointments;
    }
    
    // Retrieve all the data to the specific appointment in the list
    public Appointment getAppointmentById(Integer appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                logger.info("Successfully retrieved the data of the appointment with ID: " + appointmentId);
                return appointment;
            }
        }
        return null;
    }
    
    // Add a appointment object to the appointments list    
    public static void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        logger.info("Added appointment with ID: " + appointment.getAppointmentId());
    }    
    
    // Update the values of a existing appointment in the appointments list  
    public static void updateAppointment(Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getAppointmentId().equals(updatedAppointment.getAppointmentId())) {
                appointments.set(i, updatedAppointment);
                logger.info("Updated appointment with ID: " + updatedAppointment.getAppointmentId());
                return;
            }
        }
    } 
    
    // Delete an existing appointment from the appointments list
    public static void deleteAppointment(Integer appointmentId) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getAppointmentId().equals(appointmentId)) {
                appointments.remove(i);
                logger.info("Deleted appointment with ID: " + appointmentId);
                return;
            }
        }
    }     
}
