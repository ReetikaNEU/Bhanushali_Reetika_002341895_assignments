/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Reetika
 */
public class PersonDirectory {

    private ArrayList<Person> personList;
    
    public PersonDirectory() {
        this.personList = new ArrayList<Person>();
    }
    
    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
    public Person addNewPerson() {
       Person p = new Person();
       personList.add(p);
       return p;
   }
    
   public void deletePerson(Person person) {
       personList.remove(person);
   }
   
   
   public Person searchPerson(String searchString) {
    for (Person p : personList) {
        // Check if the first name, last name, or street address (home or work) contains the search string
        if (p.getFirstName().toLowerCase().contains(searchString.toLowerCase()) || 
            p.getLastName().toLowerCase().contains(searchString.toLowerCase()) ||
            (p.getHomeAddress() != null && p.getHomeAddress().getStreetName().toLowerCase().contains(searchString.toLowerCase())) ||
            (p.getWorkAddress() != null && p.getWorkAddress().getStreetName().toLowerCase().contains(searchString.toLowerCase()))) 
        {
            return p;
        }
    }
    return null;  // Return null if no match is found
}
    
}
