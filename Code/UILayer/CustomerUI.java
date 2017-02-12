package UILayer;

import ControlLayer.*;
import java.util.*;
/**
 * Public class CustomerUI
 */
public class CustomerUI extends PersonUI {
    private CustomerCtrl custCtrl;
    private String currentCust; //the current customer found
    private ArrayList customers;
     /**
     * Constructor for objects of this class
     */
    CustomerUI(){
        custCtrl = new CustomerCtrl();
        customers = new ArrayList();
        customers = loadPeople(getFileName());
    }
    
    /**
     *  Sets the currentCustomer served
     */
    protected void setCurrentCustomer(String newCust){
        currentCust = newCust;
    }
    
    /**
     * @return the current Customer served
     */
    protected String getCurrentCustomer(){
        return currentCust;
    }
    /**
     * Creates a new customer with calls to the super class. Saves the new customer to the file
     */
    private void createCustomer(){
        String[] basic = basics();
        custCtrl.createCustomer(basic[0], basic[1], basic[2], basic[3], basic[4],inputGroup(),inputBalance(),inputCreditCard(), inputBill(),customers);
        System.out.println("Customer created successfuly");
    }
    
    /**
     * @return an ArrayList of all customers
     */
    protected ArrayList getCustomers(){
        return customers;
    }
    
    /**
     * @return the file where customers are saved
     */
    private String getFileName(){
        return custCtrl.getFileName();
    }
    
   /**
    * Changes the products a customer has bought 
    */
   protected void setBalanceForStatistics(String str, double prBought){
       try{
           double index = custCtrl.findCustomer(str).getProductsBought();
           custCtrl.findCustomer(str).setBalance(index + prBought);
        }catch(Exception e){
            
        }
   }
    
   /**
    * @returrn the difference between the price to be paid and the amount customer is giving 
    */
   protected double makePayment(double price,double amount){
        if(custCtrl.makePayment(price,amount) >=0){
            return amount - price;
        }else{
            return -1;
        }
    }

    /**
     * Starts the main menu of this class
     */
    protected void startCustomerMenu() {
        boolean finished = false;
        customers = custCtrl.getPeople(custCtrl.getFileName());
        while (!finished) {
            double choice = writeCustomerMenu();
            if (choice == 1) {
                createCustomer();
            } else if (choice == 2) {
                if(findPerson(customers)){
                    startUpdateMenu(getCurrentPerson());
                }
            } else if (choice == 3) {
                showAll(customers);
            } else if( choice == 4){
                finished = true;
                
            }else{
                newLine();
            }
        }
    }
    
    /**Printing the main menu of this class
     * @returns the choice from the keyboard
     */
    private double writeCustomerMenu() {
        System.out.println("***Customer Menu***");
        System.out.println("To create customerr (1)");
        System.out.println("To find customerr (2)");
        System.out.println("To see all customers (3)");
        System.out.println("To go back (4)");
        return inputDouble();
    }

    /**
     * Starts update menu for a customer found by Id
     */
    private void startUpdateMenu(String id) {
        boolean finished = false;
        if(id != null){
            while (!finished) {
                double choice = printUpdateMenu();
                if (choice == 1) {
                    custCtrl.changeGroup(id, inputGroup());
                } else if (choice == 2) {
                    custCtrl.changeBalance(id,inputBalance());       
                } else if (choice == 3) {
                    custCtrl.changeBill(id,inputBill());            
                } else if (choice == 4) {
                    custCtrl.changeName(id,inputName(),customers,custCtrl.findCustomer(id),getFileName());          
                } else if (choice == 5) {
                    custCtrl.changeAddress(id,inputAddress(),customers,custCtrl.findCustomer(id),getFileName());
                } else if(choice ==6){
                    custCtrl.changePhone(id,inputPhone(),customers,custCtrl.findCustomer(id),getFileName());
                }else if(choice == 7){
                    custCtrl.changeEmail(id,inputEmail(),customers,custCtrl.findCustomer(id),getFileName());
                }else if(choice == 8){
                    custCtrl.changeId(id,inputId(),customers,custCtrl.findCustomer(id),getFileName());
                }else if(choice == 9){
                    finished = true;
                    startCustomerMenu();
                }else{
                    newLine();
            }
                    System.out.println("Changes made succesfuly");
            }
        }else{
            startCustomerMenu();
        }
    }
    
    /**
     * Prints out an update menu
     * retun@ the choice from the keyboard
     */
    protected double printUpdateMenu(){
        System.out.println("To change customer group (1)");
        System.out.println("To change customer balance (2)");
        System.out.println("To change customer bill ammount (3)");
        return super.printUpdateMenu();
    }
    
    /**
     * Starts the menu when a customer has been found
     */
    private void startFoundCustomerMenu(){
        boolean finished = false;
        while(!finished){
            double choice = foundPersonMenu();
            if(choice == 1){
                startUpdateMenu(currentCust);
            }else if(choice == 2){
                removePerson(currentCust,customers,getFileName());
            }else if(choice == 3){
                finished = true;
                startCustomerMenu();
            }else{
                newLine();
            }
        }
    }
    
   /** The input of this method becomes the person group
    *
    */
   private String inputGroup(){
        System.out.println("Input customer group");
        return inputString();
    }
    
   /** The input of this method becomes the person balance
    *
    */
   private double inputBalance(){
        System.out.println("Input customer balance");
        return inputDouble();  
    }
    
   /** The input of this method becomes the person creditCard
    *
    */
   private String inputCreditCard(){
        System.out.println(" Type the creditcard of the person: ");
        return notRestrictedString();
    }
    
   /** The input of this method becomes the person bill
    *
    */
   private double inputBill(){
        System.out.println("Input customer bill amount");
        return inputDouble();
    }

}