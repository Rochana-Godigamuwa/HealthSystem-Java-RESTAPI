/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.resources;

// Import necessary libraries
import com.mycompany.healthsystem.dao.DoctorDAO;
import com.mycompany.healthsystem.models.Doctor;
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
@Path("doctors")
public class DoctorResource {

    // Initalize the logger object
    private static final Logger logger = Logger.getLogger(DoctorResource.class.getName());
    
    // Create the instance of doctorDAO
    private final DoctorDAO doctorDAO = new DoctorDAO();

    // Retrieve all the doctors
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDoctors() {
        try {
            List<Doctor> doctors = DoctorDAO.getAllDoctors();
            logger.info("Retrieved all doctors");
            return Response.ok(doctors).build();
        } catch (Exception e) {
            logger.severe("Failed to retrieve all doctors" + e.getMessage());
            return Response.serverError().entity("Failed to retrieve doctors....").build();
        }
    }

    // Retrieve doctors by the id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoctorById(@PathParam("id") Integer id) {
        try {
            Doctor doctor = doctorDAO.getDoctorById(id);
            if (doctor != null) {
                logger.info("Retrieved doctor with ID: " + id);
                return Response.ok(doctor).build();
            } else {
                logger.warning("Doctor with ID " + id + " not found");
                return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found....").build();
            }
        } catch (Exception e) {
            logger.severe("Failed to retrieve doctor with ID: " + id + "with the error of: " + e.getMessage());
            return Response.serverError().entity("Failed to retrieve doctor. with the id of: " + id).build();
        }
    }

    // Insert new doctor
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDoctor(Doctor doctor) {
        try {
            DoctorDAO.addDoctor(doctor);
            logger.info("Added doctor with ID: " + doctor.getId());
            return Response.status(Response.Status.CREATED).build();
            
        } catch (Exception e) {
            logger.severe("Failed to add doctor... error of: " + e.getMessage());
            return Response.serverError().entity("Failed to add doctor....").build();
        }
    }

    // Update the existing doctor's data
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDoctor(@PathParam("id") Integer id, Doctor updatedDoctor) {
        try {
            updatedDoctor.setId(id);
            DoctorDAO.updateDoctor(updatedDoctor);
            logger.info("Updated doctor with ID: " + id);
            return Response.ok().build();
            
        } catch (Exception e) {
            logger.severe("Failed to update doctor with ID: " + id + "with the error of: " + e.getMessage());
            return Response.serverError().entity("Failed to update doctor....").build();
        }
    }

    // Delete the doctor by the id
    @DELETE
    @Path("/{id}")
    public Response deleteDoctor(@PathParam("id") Integer id) {
        try {
            DoctorDAO.deleteDoctor(id);
            logger.info("Deleted doctor with ID: " + id);
            return Response.ok().build();
            
        } catch (Exception e) {
            logger.severe("Failed to delete doctor with ID: " + id + "with the error of: " + e.getMessage());
            return Response.serverError().entity("Failed to delete docto with the id of: " + id).build();
        }
    }
}
