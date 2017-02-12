package ControlLayer;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import ModelLayer.*;
/**
 * Public class PersonCtrl used to save collections to files
 */
public class PersonCtrl {
    private PersonContainer persCont;
    
    /** Constructor of class PersonCtrl
     */
    public PersonCtrl() {
        persCont = new PersonContainer();
    }
    
    /** Adds a person object to a specified collection and saves it to a specified file
     * 
     */
    protected void addPerson(String fileName,Person pers,ArrayList<Person> persons){
        persons.add(pers);
        save(fileName,persons);
    }
  
    /** Saves an ArrayList to a specified file
     */
    protected void save(String fileName, ArrayList pers) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(pers);
        } catch (IOException e) {
        } finally {
            try {
                out.close();
            } catch (IOException es) {
                System.out.println("error with file");
            }
        }
    }
    
    /** Load people from a specified file
     * @return an ArrayList of the objects in the file
     */
    public ArrayList loadPeople(String fileName){
        return persCont.getPeople(fileName);
    }
    
    public ArrayList getPeople(String fileName){
        return persCont.getPeople(fileName);
    }
    
    /** finds a person by id in a specified collectiom 
     * @return the object found null otherwise
     */
    public Person findPerson(String id,ArrayList<Person> persons){
        for(Person pers : persons){
            if(pers.getID().equals(id)){
                return pers;
            }       
        }
        return null;
    }
    
    /** removes a person found by its id from a specified collection
     * the changes are saved to the file after that
     */
    public void removePerson(String id,ArrayList<Person> persons,String fileName){
        Person p = findPerson(id,persons);
        persons.remove(p);
        save(fileName,persons);
    }
    
    /** Printing all the information about people in  a collection
     */
    public void showAllPeople(ArrayList<Person> persons){
        for(Person pers : persons){
            System.out.println(pers.toString());
        }
    }
    
    /** Changes the name of a person found by id
     * Changes are save to a file later
     */
    public void changeName(String id, String str, ArrayList<Person> persons, Person pers,String fileName){
        findPerson(id,persons).setName(str);
        save(fileName,persons);
    }
    
     /** Changes the address of a person found by id
     * Changes are save to a file later
     */
    public void changeAddress(String id, String str, ArrayList<Person> persons, Person pers,String fileName){
        findPerson(id,persons).setAddress(str);
        save(fileName,persons);
    }
    
     /** Changes the email of a person found by id
     * Changes are save to a file later
     */
    public void changeEmail(String id, String str, ArrayList<Person> persons, Person pers,String fileName){
        findPerson(id,persons).setEmail(str);
        save(fileName,persons);
    }
    
     /** Changes the id of a person found by id
     * Changes are save to a file later
     */
    public void changeId(String id, String str, ArrayList<Person> persons, Person pers,String fileName){
        findPerson(id,persons).setID(str);
        save(fileName,persons);
    }
    
     /** Changes the phone of a person found by id
     * Changes are save to a file later
     */
    public void changePhone(String id, String str, ArrayList<Person> persons, Person pers,String fileName){
        findPerson(id,persons).setPhone(str);
        save(fileName,persons);
    }
    
    /**
     * @return the name of a found person in a collection
     */
    public String getName(String id,ArrayList<Person> persons){
        return findPerson(id,persons).getName();
    }
    
    /**
     * @return the address of a found person in a collection
     */
    public String getAddress(String id,ArrayList<Person> persons){
        return findPerson(id,persons).getAddress();
    }   
       
    /**
     * @return the email of a found person in a collection
     */
    public String getEmail(String id,ArrayList<Person> persons){
        return findPerson(id,persons).getEmail();
    }
        
    /**
     * @return the id of a found person in a collection
     */
    public String getId(String id,ArrayList<Person> persons){
        return findPerson(id,persons).getID();
    }
       
    /**
     * @return the phone of a found person in a collection
     */
    public String getPhone(String id,ArrayList<Person> persons){
        return findPerson(id,persons).getPhone();
    }       
}
