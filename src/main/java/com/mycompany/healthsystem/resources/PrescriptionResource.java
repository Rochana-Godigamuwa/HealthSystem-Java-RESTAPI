/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.resources;

// Import necessary libraries
import com.mycompany.healthsystem.dao.PrescriptionDAO;
import com.mycompany.healthsystem.models.Prescription;
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

@Path("prescriptions")
public class PrescriptionResource {

    // Initialize the logger
    private static final Logger logger = Logger.getLogger(PrescriptionResource.class.getName());
    
    // Create an instance of prescriptionDAO
    private final PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    // Retrieve all the prescriptions
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPrescriptions() {
        try {
            List<Prescription> prescriptions = prescriptionDAO.getAllPrescriptions();
            logger.info("Successfully retrieved all prescriptions");
            return Response.ok(prescriptions).build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while retrieving all prescriptions: " + e.getMessage());
            return Response.serverError().entity("Failed to retrieve prescriptions").build();
        }
    }

    // Retrieve specific prescriptions by the prescriptionId
    @GET
    @Path("/{prescriptionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrescriptionById(@PathParam("prescriptionId") Integer prescriptionId) {
        try {
            Prescription prescription = prescriptionDAO.getPrescriptionById(prescriptionId);
            if (prescription != null) {
                logger.info("Successfully retrieved prescription with ID: " + prescriptionId);
                return Response.ok(prescription).build();
            } else {
                logger.warning("Prescription with ID: " + prescriptionId + " not found");
                return Response.status(Response.Status.NOT_FOUND).entity("Prescription with ID: " + prescriptionId + " not found").build();
            }
            
        } catch (Exception e) {
            logger.severe("Error occurred while retrieving prescription with ID: " + prescriptionId + ": " + e.getMessage());
            return Response.serverError().entity("Failed to retrieve prescription").build();
        }
    }

    // Insert new prescriptions
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPrescription(Prescription prescription) {
        try {
            prescriptionDAO.addPrescription(prescription);
            logger.info("Added prescription with ID: " + prescription.getPrescriptionId());
            return Response.status(Response.Status.CREATED).build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while adding prescription: " + e.getMessage());
            return Response.serverError().entity("Failed to add prescription").build();
        }
    }

    // Update the prescription's data    
    @PUT
    @Path("/{prescriptionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePrescription(@PathParam("prescriptionId") Integer prescriptionId, Prescription updatedPrescription) {
        try {
            updatedPrescription.setPrescriptionId(prescriptionId);
            prescriptionDAO.updatePrescription(updatedPrescription);
            logger.info("Updated prescription with ID: " + prescriptionId);
            return Response.ok().build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while updating prescription with ID: " + prescriptionId + ": " + e.getMessage());
            return Response.serverError().entity("Failed to update prescription").build();
        }
    }

    // Delete the prescription by the prescriptionId    
    @DELETE
    @Path("/{prescriptionId}")
    public Response deletePrescription(@PathParam("prescriptionId") Integer prescriptionId) {
        try {
            prescriptionDAO.deletePrescription(prescriptionId);
            logger.info("Deleted prescription with ID: " + prescriptionId);
            return Response.ok().build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while deleting prescription with ID: " + prescriptionId + ": " + e.getMessage());
            return Response.serverError().entity("Failed to delete prescription").build();
        }
    }
}
