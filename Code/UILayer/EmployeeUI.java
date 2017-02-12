package UILayer;

import ControlLayer.*;
import java.util.*;

/**
 * Public class EmployeeUI
 */
public class EmployeeUI extends PersonUI {

    private EmployeeCtrl empCtrl;
    private CustomerCtrl custCtrl;
    private static String currentEmp; //used to hold the current employee choosen
    private ArrayList employees;
    private ProductCtrl  prCtrl;
    private CustomerUI custUI;
    private ProductSaleCtrl prSaleCtrl;
    private double totPrice;
    private String currentProduct;
    private EmployeeRent empRent;
    private ProductUI prUI;
    private OrderUI ordUI;
    /**
     *  Constructor for objects of EmployeeUI class
     */
    public EmployeeUI() {
        empCtrl = new EmployeeCtrl();
        employees = new ArrayList();
        employees = loadPeople(getFileName());
        prCtrl = new ProductCtrl();
        prSaleCtrl = new ProductSaleCtrl();
        custUI = new CustomerUI();
        custCtrl = new CustomerCtrl();
        prUI = new ProductUI();
        empRent = new EmployeeRent();
    }

    /**
     * @return the current total price of a sale
     */
    protected double getTotalPrice(){
        return totPrice;
    }

    /** Changes the current employee 
     */
    protected void setCurrentEmployee(String emp){
        currentEmp = emp;
    } 

    protected String getCurrentEmployee(){
        return currentEmp;
    }

    /**
     * Checks if a client is registered customer
     * 
     */
    protected String checkIfCustomer(){
        System.out.println("To enter customer account(y) / (n) ");
        String account = notRestrictedString();
        if(checkIfY(account)){
            System.out.println("Enter customer id");
            account = notRestrictedString();
            return account;
        }
        return null;
    }

    /**
     * Checks whether the next chart is y
     */
    protected boolean checkIfY(String account){
        if(account.equals("y")){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Method makeProductSale applies a discount to a sale and print out a receipt
     */
    protected boolean makeProductSale(){
        if(makesale() != 0){
            return true;
        }
        return false;
    }

    protected boolean payment(){

        System.out.println("Please enter customer payment sum.");
        double amount= inputDouble();

        double change = custUI.makePayment(totPrice,amount);
        boolean end = false;
        while(!end){
            if(change(change)){
                return true;
            }
            end = proceed();
        }
        return false;
    }

    protected boolean change(double change){
        if(change >= 0){
            printReceipt(change);   
            changeValues();
            empCtrl.changeProductsSold(currentEmp,totPrice);
            return true;
        }else{
            System.out.println("Transaction failed.");
            return false;
        }
    }

    protected int applyDiscount(){
        System.out.println("Please enter discount percentage if any");
        int discount =  inputInteger();

        if(prSaleCtrl.checkDiscount(discount)){
            totPrice = prSaleCtrl.applyDiscount(totPrice,discount);
            System.out.println("Discount applied");
            System.out.println("Total price " + totPrice );
            prSaleCtrl.newProductSale(totPrice,discount,getCurrentPerson(),currentEmp,currentProduct);
            return discount;
        }else{
            System.out.println("Discount not in valid range 1-20%");
            return 0;
        }
    }

    private void changeValues(){
        try{
            double custBalance = custCtrl.getBalance(getCurrentPerson());
            custCtrl.changeBalance(getCurrentPerson(),custBalance - totPrice);
            custCtrl.changeProductsBought(getCurrentPerson(),totPrice);
        }catch(Exception e){
        }
    }

    /**
     * Method makesale add products to a collection until the customer has no more products
     * @return the total price of the sale
     */
    protected double  makesale(){
        boolean endSale = false;
        boolean finishSale = false;
        String itemId = null;
        int quantity = 0;
        double total = 0;
        LinkedList products = new LinkedList();
        loadPeople(custCtrl.getFileName());       
        String cust = checkIfCustomer();
        while(!endSale){
            if(cust != null){
                setCurrentPerson(cust);
                System.out.println(custCtrl.findCustomer(cust));
            }

            itemId = prUI.findItem();
            // Enter the item Id;
            if(prCtrl.checkForItem(itemId)){
                currentProduct = itemId;
                // Enter the quantity
                System.out.println("Enter quantity: ");
                quantity = inputInteger();
                total = calculateTotal(itemId,quantity,products);
                custUI.setBalanceForStatistics(cust,total);
                endSale = endSale();
            }else{
                endSale = endSale();
            }

        }
        return total ;
    }

    /**
     * calculate the total price of a sale 
     * @param itemID is the id of te product
     * @param quanitty is the quantity of the product
     * @param products is the linkedList where all products are located
     * @return the total price 
     */private double calculateTotal(String itemId,int quantity,LinkedList products){
        double total = 0;
        String name = null;
        if(prSaleCtrl.makeSale(itemId,quantity)){
            name = prCtrl.getItemName(itemId);
            total = prSaleCtrl.enterItem(itemId, quantity,products);
            totPrice = total;
            System.out.println("Product " + name + " added " + quantity  + " times " + ". Current total price " + total);
            prSaleCtrl.calculateQuantity(itemId,quantity,0);
        }else{
            System.out.println("Not enought items in stock");                   
        }
        return total;
    }

    /**
     * CheckWheter a client is a customer
     */
    private void checkForCustomer(){
        if(checkIfCustomer() != null){
            findPerson(custUI.getCustomers());
        }
    }

    /**
     *  Checks whether next input is "y"
     *  @return wheter is it y or no
     */private boolean proceed(){
        boolean end  = false;
        System.out.println("Press (y) to continue");
        String str = inputString();
        if(checkIfY(str)){
            end = true;
        }
        return end;
    }

    /**
     * Asks the employee wheter the sale should finish
     */
    private boolean endSale(){
        System.out.println("To end sale ('y') to continue('n') ");
        String endSaleChoice= inputString();
        return checkIfY(endSaleChoice);
    }

    /**
     * Prints a receipt consitsting of the change and the current employee serving the customer
     */
    private void printReceipt(double change){
        System.out.println("Change is '"+ change + "'. You were served by " + empCtrl.findEmployee(currentEmp).getName() + ".");
    }

    /**
     * @return the filename where employees are saved
     */
    private String getFileName(){
        return empCtrl.getFileName();
    }

    /**
     * Starts the main menu for employees
     */
    protected void EmployeeMenu(){
        boolean exit = false;
        while(!exit){
            //show menu and return the user's choise
            int choice  =   writeEmployeeMenu();
            if (choice == 1){
                if(makeProductSale()){
                    applyDiscount();
                    payment();
                    proceed();
                }
            }else if(choice == 2){
                custUI.startCustomerMenu();
            } else if(choice == 3){
                empRent.rentMenu();
            }else if(choice == 4){
                ordUI = new OrderUI();
                ordUI.StartOrderMenu();
            }else if(choice ==5){
                prUI.findItem();
                proceed();
            }else if(choice == 6){
                prCtrl.showAll();
                proceed();
            }else if(choice ==7){
                exit = true;
            }else{
                newLine();
            }

        }//end while

    }

    /**
     * Writing the main menu for employees
     */
    private int writeEmployeeMenu(){
        System.out.println("\f *** Employee Menu ***");
        System.out.println(" (1) Start new sale");
        System.out.println(" (2) To enter Customers menu ");
        System.out.println(" (3) Create rent");
        System.out.println(" (4) Order menu");
        System.out.println(" (5) To find products ");
        System.out.println(" (6) To see all products ");
        System.out.println(" (7) Exit");
        System.out.print("\n Make your choice: ");
        return inputInteger();
    }

}
