/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.resources;

// Import necessary libraries
import com.mycompany.healthsystem.dao.BillingDAO;
import com.mycompany.healthsystem.models.Billing;
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
 * @author Rochana
 */

@Path("billings")
public class BillingResource {
    
    // Initialize the logger
    private static final Logger logger = Logger.getLogger(BillingResource.class.getName());
    
    // Create an instance of BillingDAO
    private final BillingDAO billingDAO = new BillingDAO();
    
    // Retrieve all the bills
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBillings() {
        try {
            List<Billing> billings = billingDAO.getAllBillings();
            logger.info("Successfully retrieved all billings");
            return Response.ok(billings).build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while retrieving all billings: " + e.getMessage());
            return Response.serverError().entity("Failed to retrieve billings....").build();
        }
    }
    
    // Retrieve specific bill by the billingId
    @GET
    @Path("/{billingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBillingById(@PathParam("billingId") Integer billingId) {
        try {
            Billing billing = billingDAO.getBillingById(billingId);
            if (billing != null) {
                logger.info("Successfully retrieved billing with ID: " + billingId);
                return Response.ok(billing).build();
            } else {
                logger.warning("Billing with ID: " + billingId + " not found");
                return Response.status(Response.Status.NOT_FOUND).entity("Bill with Id:" + billingId + " not found").build();
            }
            
        } catch (Exception e) {
            logger.severe("Error occurred while retrieving billing with ID: " + billingId + ": " + e.getMessage());
            return Response.serverError().entity("Failed to retrieve billing....").build();
        }
    }
    
    // Insert new bill
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBilling(Billing billing) {
        try {
            billingDAO.addBilling(billing);
            logger.info("Added billing with ID: " + billing.getBillingId());
            return Response.status(Response.Status.CREATED).build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while adding billing: " + e.getMessage());
            return Response.serverError().entity("Failed to add billing....").build();
        }
    }
    
    // Update the existing bill's data
    @PUT
    @Path("/{billingId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBilling(@PathParam("billingId") Integer billingId, Billing updatedBilling) {
        try {
            updatedBilling.setBillingId(billingId);
            billingDAO.updateBilling(updatedBilling);
            logger.info("Updated billing with ID: " + billingId);
            return Response.ok().build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while updating billing with ID: " + billingId + ": " + e.getMessage());
            return Response.serverError().entity("Failed to update billing....").build();
        }
    }
    
    // Delete the bill by the billingId
    @DELETE
    @Path("/{billingId}")
    public Response deleteBilling(@PathParam("billingId") Integer billingId) {
        try {
            billingDAO.deleteBilling(billingId);
            logger.info("Deleted billing with ID: " + billingId);
            return Response.ok().build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while deleting billing with ID: " + billingId + ": " + e.getMessage());
            return Response.serverError().entity("Failed to delete billing....").build();
        }
    }
}
