package UILayer;

import java.util.Scanner;

import ControlLayer.MachineCtrl;
import ControlLayer.RentCtrl;

public class EmployeeRent extends UIInputClass{
    private MachineCtrl machine;
    private RentCtrl rent;
    private String barcode;
    private boolean isTrue;
    
    public EmployeeRent(){
        setMachine(new MachineCtrl());
        setRent(new RentCtrl());
        setTrue(true); 
    }
    /**
     * print on the screen menu rent menu and then fulfil the option which is chosen
     */
    public void rentMenu(){
        
        int choiceValue;
        boolean isTrue = true;
        
        while (isTrue == true) {
            setMachine(new MachineCtrl());
            setRent(new RentCtrl());
        
        // Display menu graphics
        System.out.println("============================");
        System.out.println("|       RENT MENU          |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Type 1 for renting Machine     |");
        System.out.println("|        2. Type 2 for seeing all rentings |");
        System.out.println("|        3. Type 3 for seeing all machines |");
        System.out.println("|        4. Type 4 for seeing all copies   |");
        System.out.println("|        5. Exit           |");
        System.out.println("============================");
        choiceValue = inputInteger();
        
        // Switch construct
        

            switch (choiceValue) {
            case 1:
                rent();

                break;
            case 2:
                System.out.println("Option 2 selected");
                System.out.println(rent.getRents());
                
                System.out.println();
                System.out.println();
                
                
                break;
                
            case 3:
                System.out.println(machine.getMachines());
                break;
                
            case 4:
                 System.out.println(machine.getCopiesOfMachines());
                break;
            case 5:
                System.out.println("Exit selected");
                isTrue = false;
                break;
            default:
                System.out.println("Invalid selection");
                break; // This break is not really necessary
            }
        }
        
    
        
    }
    /**
     * print on the screen available machine searched by barcode and their copies
     */
    private void rent(){
        
          System.out.println("Option 1 selected"); 
          System.out.println();
          inputNotRestrictedString();
          
          printAvailableMachineByBarcode();
          if(isTrue() == false){
              rentMenu();
          }
          printAvailableCopies();
          creatingRent();
          
    }
    
    /**
     * print available machine on the schreen found it by barcode
     */
    private void printAvailableMachineByBarcode(){
        System.out.println("Please type category of Machine");
        
        String category = inputString();
        if(machine.getAvailableMachinebyCategory(category).size() > 0){
            System.out.println(machine.getAvailableMachinebyCategory(category));
            setTrue(true);
        }else{
            System.out.println("There is no available machines at the moment");
            setTrue(false);
            
        }
        
    }
    /**
     * require form the user to input barcode of the machine and then prints its available copies. 
     */
    private void printAvailableCopies(){
        System.out.println("Please type barcode of the machine you wanted to get");
        
         barcode = inputString();
        
        System.out.println(machine.getAvailableCopiesOfMachinebyBarcode(barcode));
        
    }
    /**
     * require form the user to input data about the rent and make new rent
     */
    private void creatingRent(){
        System.out.println("Please type the copy ID");
        String copyID = inputString();
        
        System.out.println("Please type the customer ID");
        String custID = inputString();
        
        System.out.println("Please type the employee ID");
        String empID = inputString();
        
        System.out.println("Please type the rent ID");
        String id = inputString();
        
        System.out.println("Please type the renting period(\" The numbers of days\") ");
        int period = inputInteger();
        
        inputNotRestrictedString();
        System.out.println("Please type the day of borrowing");
        String borrowDate = inputString();
        
        System.out.println("Please type the percent of discount: from 0% to 100%");
        int dicount = inputInteger();
        
        rent.newRent(dicount, custID, empID, id, period, borrowDate, copyID,barcode);
        
        
        
    }
    

    
    private MachineCtrl getMachine() {
        return machine;
    }
    
    private void setMachine(MachineCtrl machine) {
        this.machine = machine;
    }
    

    
    private RentCtrl getRent() {
        return rent;
    }
    private void setRent(RentCtrl rent) {
        this.rent = rent;
    }
    private boolean isTrue() {
        return isTrue;
    }
    private void setTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }
}
