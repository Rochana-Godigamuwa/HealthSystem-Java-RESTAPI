/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.resources;

// Import necessary libraries
import com.mycompany.healthsystem.dao.MedicalRecordDAO;
import com.mycompany.healthsystem.models.MedicalRecord;
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
 * @author Rochana Godi
 */
@Path("medicalrecords")
public class MedicalRecordResource {
    
    // Initialize the logger
    private static final Logger logger = Logger.getLogger(MedicalRecordResource.class.getName());
    
    // Create an instance of MedicalRecordDAO
    private final MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();
    
    // Retrieve all the medical records
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMedicalRecords() {
        try {
            List<MedicalRecord> medicalRecords = medicalRecordDAO.getAllMedicalRecords();
            logger.info("Successfully retrieved all medical records");
            return Response.ok(medicalRecords).build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while retrieving all medical records: " + e.getMessage());
            return Response.serverError().entity("Failed to retrieve medical records....").build();
        }
    }
    
    // Retrieve specific medical records by the medicalRecordId
    @GET
    @Path("/{medicalRecordId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicalRecordById(@PathParam("medicalRecordId") Integer medicalRecordId) {
        try {
            MedicalRecord medicalRecord = medicalRecordDAO.getMedicalRecordById(medicalRecordId);
            if (medicalRecord != null) {
                logger.info("Successfully retrieved medical record with ID: " + medicalRecordId);
                return Response.ok(medicalRecord).build();
            } else {
                logger.warning("Medical record with ID: " + medicalRecordId + " not found");
                return Response.status(Response.Status.NOT_FOUND).entity("Medical record not found....").build();
            }
            
        } catch (Exception e) {
            logger.severe("Error occurred while retrieving medical record with ID: " + medicalRecordId + ": " + e.getMessage());
            return Response.serverError().entity("Failed to retrieve medical record").build();
        }
    }
    
    // Insert new medical records
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMedicalRecord(MedicalRecord medicalRecord) {
        try {
            medicalRecordDAO.addMedicalRecord(medicalRecord);
            logger.info("Added medical record with ID: " + medicalRecord.getMedicalRecordId());
            return Response.status(Response.Status.CREATED).build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while adding medical record: " + e.getMessage());
            return Response.serverError().entity("Failed to add medical record....").build();
        }
    }
    
    // Update the medical record's data
    @PUT
    @Path("/{medicalRecordId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMedicalRecord(@PathParam("medicalRecordId") Integer medicalRecordId, MedicalRecord updatedMedicalRecord) {
        try {
            updatedMedicalRecord.setMedicalRecordId(medicalRecordId);
            medicalRecordDAO.updateMedicalRecord(updatedMedicalRecord);
            logger.info("Updated medical record with ID: " + medicalRecordId);
            return Response.ok().build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while updating medical record with ID: " + medicalRecordId + ": " + e.getMessage());
            return Response.serverError().entity("Failed to update medical record....").build();
        }
    }
    
    // Delete the medical record by the medicalRecordId
    @DELETE
    @Path("/{medicalRecordId}")
    public Response deleteMedicalRecord(@PathParam("medicalRecordId") Integer medicalRecordId) {
        try {
            medicalRecordDAO.deleteMedicalRecord(medicalRecordId);
            logger.info("Deleted medical record with ID: " + medicalRecordId);
            return Response.ok().build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while deleting medical record with ID: " + medicalRecordId + ": " + e.getMessage());
            return Response.serverError().entity("Failed to delete medical record....").build();
        }
    }
}