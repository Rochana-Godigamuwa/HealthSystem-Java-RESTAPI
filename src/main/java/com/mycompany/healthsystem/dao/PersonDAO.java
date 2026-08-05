/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystem.dao;

// Import the necessary libraries
import com.mycompany.healthsystem.models.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Rochana Godigamuwa
 */

public class PersonDAO {

    // Initialize the logger 
    private static final Logger logger = Logger.getLogger(PersonDAO.class.getName());
   
    // Create a list to store the Person objects
    static List<Person> persons = new ArrayList<>();
    
    // Add some sample data to the persons list
    static {
        persons.add(new Person(1, "Rochana Godi", 51616566, "A/30 Bell Sheet"));
        persons.add(new Person(2, "Chandupa", 987654321, "B/34 Noisey sheet"));
        persons.add(new Person(3, "Sadesh Weerasuriya", 432165884, "Kandy sheet a/20"));
    }
    
    // Retrieve all the data in the persons list
    public static List<Person> getAllPersons() {
        return persons;
    }
    
    // Retrieve all the data to the specific user in the list
    public Person getPersonById(Integer id) {
        for(Person person : persons) {
            if (person.getId().equals(id)) {
                logger.info("Successfully retrieved the data of the person whose id of " + person.getId());
                return person; 
            }
        } return null;
    }
       
    // Add a person object to the persons list
    public static void addPerson(Person person) {
        persons.add(person);
        logger.info("Added person with ID: " + person.getId());
    } 
    
    // Update the values of a existing person in the persons list
    public static void updatePerson(Person updatedPerson) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getId().equals(updatedPerson.getId())) {
                persons.set(i, updatedPerson);
                logger.info("Updated person with ID: " + updatedPerson.getId());
                return;
            } 
        }
    }  
    
    // Delete an existing person from the persons list
    public static void deletePerson(Integer id) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getId().equals(id)) {
                persons.remove(i);
                logger.info("Deleted person with ID: " + id);
                return;
            }
        }
    }  
}
