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
   
   public Person searchPerson(String firstName) {
       for (Person p : personList) {
           if (p.getFirstName().contains(firstName)) {
               return p;
           }
       }
       return null;
   }
    
}
