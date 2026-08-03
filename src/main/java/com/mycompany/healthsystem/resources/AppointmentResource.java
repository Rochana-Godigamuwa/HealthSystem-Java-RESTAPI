/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.resources;

// Import necessary libraries
import com.mycompany.healthsystem.dao.AppointmentDAO;
import com.mycompany.healthsystem.models.Appointment;
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

@Path("appointments")
public class AppointmentResource {

    // Initalize the logger object
    private static final Logger logger = Logger.getLogger(AppointmentResource.class.getName());

    // Create the instance of appointmentDAO
    private final AppointmentDAO appointmentDAO = new AppointmentDAO();

    // Retrieve all the appointments
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAppointments() {
        try {
            List<Appointment> appointments = AppointmentDAO.getAllAppointments();
            logger.info("Retrieved all appointments...");
            return Response.ok(appointments).build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while retrieving all appointments: " + e.getMessage());
            return Response.serverError().entity("Failed to retrieve appointments....").build();
        }
    }

    // Retrieve specific appointment by the appointmentId
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppointmentById(@PathParam("id") Integer appointmentId) {
        try {
            Appointment appointment = appointmentDAO.getAppointmentById(appointmentId);
            if (appointment != null) {
                logger.info("Successfully retrieved appointment with ID: " + appointmentId);
                return Response.ok(appointment).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Appointment not found").build();
            }
        } catch (Exception e) {
             logger.severe("Error occurred while retrieving all appointments: " + e.getMessage());
            return Response.serverError().entity("Failed to retrieve appointment....").build();
        }
    }

    // Insert new appointment
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAppointment(Appointment appointment) {
        try {
            AppointmentDAO.addAppointment(appointment);
             logger.info("Added appointment with ID: " + appointment.getAppointmentId());
            return Response.status(Response.Status.CREATED).build();
            
        } catch (Exception e) {
             logger.severe("Error occurred while adding appointment: " + e.getMessage());
            return Response.serverError().entity("Failed to add appointment....").build();
        }
    }

    // Update the existing appointment's data
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAppointment(@PathParam("id") Integer appointmentId, Appointment updatedAppointment) {
        try {
            updatedAppointment.setAppointmentId(appointmentId);
            AppointmentDAO.updateAppointment(updatedAppointment);
            logger.info("Updated appointment with ID: " + appointmentId);
            return Response.ok().build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while updating appointment with ID " + appointmentId + ": " + e.getMessage());
            return Response.serverError().entity("Failed to update appointment....").build();
        }
    }

    // Delete the appointment by the appointmentId
    @DELETE
    @Path("/{id}")
    public Response deleteAppointment(@PathParam("id") Integer appointmentId) {
        try {
            AppointmentDAO.deleteAppointment(appointmentId);
            logger.info("Deleted appointment with ID: " + appointmentId);
            return Response.ok().build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while deleting appointment with ID " + appointmentId + ": " + e.getMessage());
            return Response.serverError().entity("Failed to delete appointment....").build();
        }
    }
}