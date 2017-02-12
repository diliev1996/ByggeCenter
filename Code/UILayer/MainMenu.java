
package UILayer;
import ControlLayer.EmployeeCtrl;
import java.util.Scanner;
/**
 * Public class Person Menu used to start a desired menu 
 */
public class MainMenu extends UIInputClass{
    private EmployeeUI empUI;
    private ManagerUI manUI;
    private String currentPerson;
    private EmployeeCtrl empCtrl;
    /**
     * Constructor for objects of class PersonMenu
     */
    MainMenu(){
        empUI = new EmployeeUI();
        manUI = new ManagerUI();
        empCtrl = new EmployeeCtrl();
        startMainMenu();
    }
    
    /**
     * Message telling the user that he is no longer using the program
     */
    private void logout(){
         System.out.println("You have now been logged out!");
         empUI.setCurrentEmployee(null);
    }
    
    /**
     * Method used to authorize the login of a person 
     * Depending on their position the people are redirected to different menus
     */
    private int login(){
       Scanner keyboard = new Scanner(System.in);
       
       System.out.println("Please enter your name:");
       String loginName = inputString();
       
       System.out.println("Please enter id");
       String id = inputNotRestrictedString();
       
       int index = findWorker(loginName,id);
     
       if(index == 1){   
           System.out.println("You are now logged in as Manager " + loginName );
        }else if(index ==2 ){
            System.out.println("You are now logged in as Employee " + loginName);    
            empUI.setCurrentEmployee(id);
       }else{
           System.out.println("User not found. Please try again");
        }
        String str = keyboard.nextLine();
       return index; 
    }
    
        /**
     * Checks wheter the employee is with position Manager or not
     * @return 1 if manager 2 if anything else
     */
    private int findWorker(String name,String id){
          int index = 0;
          empUI.loadPeople(empCtrl.getFileName());
          try{
              if(empCtrl.findEmployee(id).getPosition().equals("Manager") && empCtrl.findEmployee(id).getName().equals(name)){
                  index = 1;
              }else if(empCtrl.findEmployee(id).getName().equals(name)){
                  index = 2;
                }
          }catch(NullPointerException ne){
              index = 0;
          }
          return index;
       }
       
    
    /** The start menu of the program It checks if there are any employes registered and if not it opens a registration menu 
     */
    private double startMainMenu(){
        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;
        double choice = 0;
        int login = 0;
        while(!exit){
            if(empCtrl.getPeople(empCtrl.getFileName()).isEmpty()){
                writeFirstMenu();
                manUI.createEmployee();
            }else{
                choice = writeStartMenu();
            }
            if (choice == 1){
               login = login();
               if(login ==1){
                   manUI.ManagerMainMenu();
               }else if(login == 2){
                   empUI.EmployeeMenu();
               }
            }else if(choice == 2){
                logout();
                exit = true;
            }
        }//end while
        return choice;
    }
    
    /**
     * Writing the start menu 
     * @return the input of the user
     */
    private double writeStartMenu(){
            System.out.println("\f *** Start Menu ***");
            System.out.println(" (1) Login");
            System.out.println(" (2) Logout");
            System.out.print("\n Make your choice: ");
            
            return inputDouble();
    }
    
    /**
     * Writing this instructions if there are no employees registered
     */
    private void writeFirstMenu(){
        System.out.println("\f *** Registration ***");
        System.out.println("In order to use the program follow the instructions of registration");
        System.out.println("Input your details and position so you can access the other menus");
        System.out.println("Just make sure when you register to set your position as");
        System.out.print("\"Manager\"");
        System.out.println();
    }
    }

