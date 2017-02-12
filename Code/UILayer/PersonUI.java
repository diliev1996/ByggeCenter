package UILayer;
import ControlLayer.PersonCtrl;
import java.util.ArrayList;

/**
 * Write a description of class PersonUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PersonUI
{
    private PersonCtrl persCtrl;
    private String currentPers;
    private UIInputClass UIclass;
    /**
     * Constructor for objects of class PersonUI
     */
    public PersonUI()
    {
        persCtrl = new PersonCtrl();
        UIclass= new UIInputClass();
    }


    /** return an arraylist of people loaded from a file
     */
    protected ArrayList loadPeople(String str){
        return persCtrl.loadPeople(str);
    }
    
    /**
     * @return an array of String objects
     */
    protected String[] basics(){
        String name = inputName();
        String address = inputAddress();
        String phone = inputPhone();
        String email = inputEmail();
        String id = inputId();
        String[] basics = new String[]{name,address,phone,email,id};
        return basics;
    }
    
    /** Show all people in a collection if it is not empty
     */
    protected void showAll(ArrayList arraylist){
        if(!arraylist.isEmpty()){
            System.out.println("Total amount " + arraylist.size());
            persCtrl.showAllPeople(arraylist);
        }else{
            System.out.println("No people registerd");
        }
    }
    
        /**
     * Removes a customer by his id if he exits
     */
    protected void removePerson(String id,ArrayList persons,String fileName){
        if(persCtrl.findPerson(id,persons) != null){
            persCtrl.removePerson(id,persons,fileName);
            System.out.println("Persont created successfuly");
        }else{
            System.out.println("There is no person with that id");
        }
    }
    
   
    /** @ return wheter a person exists in a collection
     */
    protected boolean findPerson(ArrayList persons){
        String id = inputId();
        if(persCtrl.findPerson(id,persons) != null){
            System.out.println(persCtrl.findPerson(id,persons));
            currentPers = id;
            return true;
        }else{
            System.out.println("No person with that id");
            return false;
        }
    }
    
    /**
     * @return the currentPerson currently hold
     */
    protected String getCurrentPerson(){
        return currentPers;
    }
    
    /**
     * @sets the current person
     */
    protected void setCurrentPerson(String str){
        currentPers = str;
    }
    
    /** The input of this method becomes the person name
     *  
     */
    protected String inputName(){
        System.out.println("Input person name");
        return UIclass.inputString();
    }
    
    /**
     * The input of this method becomes the person address
     */
    protected String inputAddress(){
        System.out.println("Input person address");
        return UIclass.inputNotRestrictedString();
    }
    
    /**
     * The input of this method becomes the person phone
     */
    protected String inputPhone(){
        System.out.println("Input person phone");
        return UIclass.inputNotRestrictedString();
    }
    
    /**
     * The input of this method becomes the person email
     */
    protected String inputEmail(){       
        System.out.println("Input person email");
        return UIclass.inputNotRestrictedString();
    }
    
    /**
     * The input of this method becomes the person id
     */
    protected String inputId(){
        System.out.println("Input person id");
        return UIclass.inputNotRestrictedString();
    }
    
    protected double inputDouble(){
        return UIclass.checkIfDouble();
    }
    
    protected int inputInteger(){
        return UIclass.checkIfInt();
    }
    
    protected String inputString(){
        return UIclass.inputString();
    }

    protected String notRestrictedString(){
        return UIclass.inputNotRestrictedString();
    }
    
    /**
    * Error message when the user has typed something incorrectly
    */
    protected void newLine(){
        System.out.println("Unknown command");
    }
    
    /**
     * Update Menu for all person objects
     */
    protected double printUpdateMenu(){
        System.out.println("To change  name (4)");
        System.out.println("To change  address (5)");
        System.out.println("To change phone (6)");
        System.out.println("To change email (7)");
        System.out.println("To change id (8)");
        System.out.println("To go back (9)");
        return UIclass.inputDouble();
    }
    
    /**
     * Prints the menu when an employee has been found
     * return the choice from the keyboard
     */
    protected double foundPersonMenu(){
        System.out.println("To update person information (1)");
        System.out.println("To remove person (2)");
        System.out.println("To go back (3)");
        return UIclass.inputDouble();
    }
}
