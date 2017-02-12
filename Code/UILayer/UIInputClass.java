package UILayer;
import ControlLayer.*;
import java.util.*;
/**
 * UIInputClass used for input and restricting methods which it subclasses used
 */
public class UIInputClass{
    private Scanner reader;
    /**
     * Constructor for objects of class UISuperClass
     */
    public UIInputClass(){
        reader = new Scanner(System.in);
    }

    /**
     *  Checks if the input in the keyboard is double
     */
    protected double checkIfDouble(){
        double index = 0;
        boolean ok = false;
         while(!ok){
            try{
                 index = reader.nextDouble();
                 ok = true;
            }catch(Exception e){
                 reader = new Scanner(System.in);
                 System.out.println("You have to type a number, please try again");
            }
        }
            return index;
    }
    
        /**
     *  Checks if the input in the keyboard is integer
     */
    protected int checkIfInt(){
        int index = 0;
        boolean ok = false;
         while(!ok){
            try{
                 index = reader.nextInt();
                 ok = true;
            }catch(Exception e){
                 reader = new Scanner(System.in);
                 System.out.println("You have to type a number, please try again");
            }
        }
            return index;
    }
  
    
    /**
     * Error message when the user has typed something incorrectly
    */
    protected void newLine(){
        System.out.println("Unknown command");
        reader.nextLine();
    }
    
    /**
     * Checks if the input in the keyboard is String
     */
    protected String checkIfString(){
         String str = " ";
         boolean ok = false;
         reader = new Scanner(System.in);
         while(!ok){
            str = reader.nextLine();
            if(str.matches("[a-zA-Z ]*\\d+.*")){
                System.out.println("You have to type a string, please try again");
            }else{
                ok = true;
            }
         }
            return str;
    }
    
    /** 
     * @return the input from the keyboard
     */
    protected String inputString(){
         return checkIfString();
    }
    
    /**
     * @return the input from the keyboard
     */
    protected double inputDouble(){
        return checkIfDouble();
    }
    
    /**
     * checks wheter the input of the keyboard is integer
     */
    protected int inputInteger(){  
        return checkIfInt();
    }
    
    /** Allowing numbers to be typen on the keyboard as String
     * @return the input from the keyboard
     */
    protected String inputNotRestrictedString(){
        String str = "";
        Scanner keyboard = new Scanner(System.in);
        return str = keyboard.nextLine();
    }
   
}