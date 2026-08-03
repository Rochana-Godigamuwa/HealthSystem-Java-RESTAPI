/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.resources;

// Import necessary libraries
import com.mycompany.healthsystem.dao.PatientDAO;
import com.mycompany.healthsystem.models.Patient;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author thisa
 */

@Path("patients")
public class PatientResource {

    // Initialize the logger 
    private static final Logger logger = Logger.getLogger(PatientResource.class.getName());
    
    // Create an instance of PatientDAO
    private final PatientDAO patientDAO = new PatientDAO();

    // Retrieve all the patients
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPatients() {
        try {
            List<Patient> patients = PatientDAO.getAllPatients();
            logger.info("Retrieved all patients");
            return Response.ok(patients).build();
        } catch (Exception e) {
            logger.severe("Failed to retrieve all patients" + e.getMessage());
            return Response.serverError().entity("Failed to retrieve patients").build();
        }
    }

    // Retrieve patient by the id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientById(@PathParam("id") Integer id) {
        try {
            Patient patient = patientDAO.getPatientById(id);
            if (patient != null) {
                return Response.ok(patient).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Patient with the Id of: " + id + " is not found").build();
            }
        } catch (Exception e) {
            logger.severe("Error occurred while retrieving patient with ID: " + id + " with the error of: " + e.getMessage());
            return Response.serverError().entity("Failed to retrieve patient....").build();
        }
    }

    // Insert new patient
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPatient(Patient patient) {
        try {
            patientDAO.addPatient(patient);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            logger.severe("Error occurred while adding patient... error: " + e.getMessage());
            return Response.serverError().entity("Failed to add patient....").build();
        }
    }

    // Update existing patient's details
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePatient(@PathParam("id") Integer id, Patient updatedPatient) {
        try {
            updatedPatient.setId(id);
            patientDAO.updatePatient(updatedPatient);
            return Response.ok().build();
        } catch (Exception e) {
            logger.severe("Error occurred while updating patient with ID: " + id + "with the error of: " + e.getMessage());
            return Response.serverError().entity("Failed to update patient.....").build();
        }
    }

    // Delete a patient by the id
    @DELETE
    @Path("/{id}")
    public Response deletePatient(@PathParam("id") Integer id) {
        try {
            patientDAO.deletePatient(id);
            return Response.ok().build();
        } catch (Exception e) {
            logger.severe("Error occurred while deleting patient with ID: " + id + "with the error of: " + e.getMessage());
            return Response.serverError().entity("Failed to delete patient.....").build();
        }
    }
}