package UILayer;

import ControlLayer.*;
import java.util.*;

/**
 * Public class EmployeeUI
 */
public class ManagerUI extends PersonUI {
    private ArrayList employees;
    private EmployeeCtrl empCtrl;
    private String file;
    private MachineUI machUI;
    private ItemsReorderCtrl itrCtrl;
    /**
     *  Constructor for objects of EmployeeUI class
     */
     ManagerUI() {
        empCtrl = new EmployeeCtrl();
        employees = new ArrayList();
        file = empCtrl.getFileName();
        machUI = new MachineUI();
        itrCtrl = new ItemsReorderCtrl();
    }

    /**
     * Creates a new employee using methods from the super class. Saves the employee to a file
     */
    protected void createEmployee() {
        String[] basic = basics();
        empCtrl.createEmployee(basic[0], basic[1], basic[2], basic[3], basic[4], inputBankAccount(), inputPosition(), inputSalary(),employees);
        System.out.println("Employee created successfuly");
    }
    
              
     /**
      * Method used to write the Person menu on the console
      * @return the choice from the console
      */
    private double writeManagerMenu(){
         System.out.println("***Manager Menu***");
         System.out.println("To enter Employee's Menu (1)");
         System.out.println("To enter Customer's Menu (2)");
         System.out.println("To enter Contractor's Menu (3)");
         System.out.println("To enter Product's Menu (4)");
         System.out.println("To enter Machine's Menu (5)");
         System.out.println("To see products for reordering (6)");
         System.out.println("To log out (7)");
         return inputDouble();
    }
    
          /**
     * Starting the main menu for Employees
     */
    private void ManagerMenu() {
        boolean finished = false;
        employees = loadPeople(file);
        while (!finished) {
            double choice = printEmployeeMenu();
            if (choice == 1) {
                createEmployee();
            } else if (choice == 2) {
                if(findPerson(employees)){
                    startFoundEmployeeMenu();
                }
            } else if (choice == 3) {
                showAll(employees);           
            } else if (choice == 4) {
                finished = true;
            } else {
                newLine();
            }
        }
    }

    /**
     * Printing the menu on the console
     * returns the choice from the keyboard
     */
    private double printEmployeeMenu() {
        System.out.println("***Employee Menu***");
        System.out.println("To create employee (1)");
        System.out.println("To find employe (2)");
        System.out.println("To see all employees(3)");
        System.out.println("To go back to the main menu (4)");
        return inputDouble();
    }
    
        /**
     * Starting the personMenu. Each choice opens a submenu
     */
    protected void ManagerMainMenu(){
        CustomerUI custUI = new CustomerUI();
        ContractorUI contUI = new ContractorUI();
        ProductUI prUI = new ProductUI();
         boolean finished = false;        
        while(!finished){
           double choice = writeManagerMenu();
           if(choice == 1){
               ManagerMenu();
            }else if (choice == 2){
                custUI.startCustomerMenu();
            }else if(choice ==3){
               contUI.startContractorMenu();
            }else if(choice ==4){
                prUI.ProductMenu();
            }else if(choice ==5){
                machUI.startMenu();
            }else if(choice == 6){
                itrCtrl.makeReorder();
            }else if(choice ==7){
                finished = true;
            }else{
                newLine();
            }
        }
    }
    
       /** Starts an update menu over a desired employee found by id
     */
    private void startUpdateMenu(String id) {
        boolean finished = false;
        if(id != null){
            while (!finished) {
                double choice = printUpdateMenu();
                if (choice == 1) {
                    empCtrl.changeBankAcc(id,inputBankAccount());
                } else if (choice == 2) {
                    empCtrl.changePosition(id,inputPosition());
                } else if (choice == 3) {
                    empCtrl.changeSalary(id,inputSalary());     
                } else if (choice == 4) {
                    empCtrl.changeName(id,inputName(),employees,empCtrl.findEmployee(id),file);               
                } else if (choice == 5) {
                    empCtrl.changeAddress(id,inputAddress(),employees,empCtrl.findEmployee(id),file);
                } else if(choice ==6){
                    empCtrl.changePhone(id,inputPhone(),employees,empCtrl.findEmployee(id),file);                       
                }else if(choice == 7){
                    empCtrl.changeEmail(id,inputEmail(),employees,empCtrl.findEmployee(id),file);
                }else if(choice == 8){
                    empCtrl.changeId(id,inputId(),employees,empCtrl.findEmployee(id),file);
                }else if(choice == 9){
                    finished = true;
                    ManagerMainMenu();
                }else {
                    newLine();
                }
                System.out.println("Changes made succesfuly");
            }
        }else{
            ManagerMainMenu();
        }
    }

    /**
     * Prints the update menu with override call to the superClass
     * returns the choice from the keyboard
     */
    protected double printUpdateMenu(){
        System.out.println("To change employee bank account (1)");
        System.out.println("To change employee position (2)");
        System.out.println("To change employee salary (3)");
        return super.printUpdateMenu();
    }

    /**
     * Statts the menu when an employee has been found
     */
    private void startFoundEmployeeMenu(){
        boolean finished = false;
        while(!finished){
            double choice = foundPersonMenu();
            if(choice == 1){
                startUpdateMenu(getCurrentPerson());
                finished = true;
            }else if(choice == 2){
                removePerson(getCurrentPerson(),employees,file);
                finished = true;
            }else if(choice == 3){
                finished = true;
                ManagerMainMenu();
            }else{
                newLine();
            }
        }
    }
    
    /**
     * The input from this method  becomes the employee bank account
     */
    private String inputBankAccount(){
        System.out.println("Input employee bank account");
        return notRestrictedString();
    }
    
    /**
     * The input from this method  becomes the employee position
     */
    private String inputPosition(){
        System.out.println("Input employee position");
        return inputString();
    }
    
    /**
     * The input from this method  becomes the employee salary
     */
    private double inputSalary(){
        System.out.println("Input employee salary");
        return inputDouble();
    }
}
