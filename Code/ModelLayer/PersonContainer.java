package ModelLayer;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Public class PersonContainer used to get the collections of persons from files
 */

public class PersonContainer{
    private ArrayList<Person> persons;
    
    /** Constructor of class PersonContainer
     */
    public PersonContainer(){
        persons = new ArrayList<>();
    }
    
    /** Returns an ArrayList from the desired file
     */
    public ArrayList getPeople(String file){
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new FileInputStream(file));
            while(true){
                persons = (ArrayList)input.readObject(); 
            }
        }catch(EOFException | FileNotFoundException | NullPointerException e){
             try {
                 input.close();
             }catch(NullPointerException | IOException ex){
                 
             }
        } catch (IOException | ClassNotFoundException ex) {
        }
        return persons;
    }
    
}

    

