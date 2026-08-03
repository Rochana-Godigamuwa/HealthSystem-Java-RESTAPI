/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.resources;

// Import necessary libraries
import com.mycompany.healthsystem.dao.PersonDAO;
import com.mycompany.healthsystem.models.Person;
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

@Path("persons")
public class PersonResource {

    // Initalize the logger object
    private static final Logger logger = Logger.getLogger(PersonResource.class.getName());
    
    // Create the instance of personDAO
    private final PersonDAO personDAO = new PersonDAO();

    // Retrieve all the persons
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response getAllPersons() {
        try {
            List<Person> persons = PersonDAO.getAllPersons();
            return Response.ok(persons).build();
        } catch (Exception e) {
            logger.severe("Error occurred while retrieving all persons" + e.getMessage());
            return Response.serverError().entity("Failed to retrieve persons....").build();
        }
    }

    // Retrieve persons by the id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonById(@PathParam("id") Integer id) {
        try {
            Person person = personDAO.getPersonById(id);
            if (person != null) {
                return Response.ok(person).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Person not found").build();
            }
        } catch (Exception e) {
            logger.severe("Error occurred while retrieving person with ID: " + id + "with the error of: " + e.getMessage());
            return Response.serverError().entity("Failed to retrieve person....").build();
        }
    }

    // Insert new person
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        try {
            PersonDAO.addPerson(person);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            logger.severe("Error occurred while adding person " + e.getMessage());
            return Response.serverError().entity("Failed to add person....").build();
        }
    }

    // Update the existing person's data
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("id") Integer id, Person updatedPerson) {
        try {
            updatedPerson.setId(id);
            PersonDAO.updatePerson(updatedPerson);
            return Response.ok().build();
        } catch (Exception e) {
            logger.severe("Error occurred while updating person with ID: " + id + "the error of: " + e.getMessage());
            return Response.serverError().entity("Failed to update person....").build();
        }
    }

    // Delete the person by the id
    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") Integer id) {
        
        try {
            PersonDAO.deletePerson(id);
            logger.info("Deleted the person with the Id of: " + id);
            return Response.ok().build();
            
        } catch (Exception e) {
            logger.severe("Error occurred while deleting person with ID: " + id + "the error of: " + e.getMessage());
            return Response.serverError().entity("Failed to delete person....").build();
        }
    }
}



