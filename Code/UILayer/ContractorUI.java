
package UILayer;
import ControlLayer.*;
import java.util.*;
/**
 * Public class ContractorUI
 */
public class ContractorUI extends PersonUI {
    private ContractorCtrl contCtrl;
    private String currentCont;//used to hold the current contractor found
    private ArrayList contractors;
    /** Consturctor for objects of this class
     */
    ContractorUI(){
        contCtrl = new ContractorCtrl();
        contractors = new ArrayList();
        contractors = loadPeople(getFileName());
    }

    /**
     *  Creates a new contractor using methods from the super class
     */
    private void createContractor(){
        String[] basic = basics();
        contCtrl.createContractor(basic[0], basic[1], basic[2], basic[3], basic[4],contractors);
        System.out.println("Contractor created successfuly");
    }
    
    /**
     * @return the filename of the file where contractors are saved 
     */
    private String getFileName(){
        return contCtrl.getFileName();
    }

    /**
     * Start the main menu of this class
     */
    protected void startContractorMenu() {
        boolean finished = false;
        contractors = contCtrl.loadPeople(getFileName());
        while (!finished) {
            double choice = printContractorMenu();
            if (choice == 1) {
                createContractor();
            } else if (choice == 2) {
                if(findPerson(contractors)){
                    startUpdateMenu(getCurrentPerson());
                }
            } else if (choice == 3) {
                showAll(contractors);
            } else if (choice == 4) {
                finished = true;
            }else{
                newLine();
            }
        }
    }

    /**
     * Prints the main menu to the console
     * @returns the choice from the keyboard
     */
    private double printContractorMenu() {
        System.out.println("***Contractor Menu***");
        System.out.println("To create contractor (1)");
        System.out.println("To find contractor (2)");
        System.out.println("To see all contractors (3)");
        System.out.println("To go back to the persons menu (4)");
        return inputDouble();
    }

    /**
     * Starts an update menu for a contractor found by his id
     */
    private void startUpdateMenu(String id) {
        boolean finished = false;
        String str = null;
        if( id !=null){
            while (!finished) {
                double choice = printUpdateMenu();
                if (choice == 1) {
                    contCtrl.changeName(id,inputName(),contractors,contCtrl.findContractor(id),getFileName());
                } else if (choice == 2) {
                    contCtrl.changeAddress(id,inputAddress(),contractors,contCtrl.findContractor(id),getFileName());
                } else if (choice == 3) {
                    contCtrl.changePhone(id,inputPhone(),contractors,contCtrl.findContractor(id),getFileName());              
                } else if (choice == 4) {
                    contCtrl.changeEmail(id,inputEmail(),contractors,contCtrl.findContractor(id),getFileName());
                } else if (choice == 5) {
                    contCtrl.changeId(id,inputId(),contractors,contCtrl.findContractor(id),getFileName());
                } else if(choice ==6){
                    finished = true;
                    startContractorMenu();
                }else{
                    newLine();
                }
                System.out.println("Changes made succesfuly");
            }
        }else{
            startContractorMenu();
        }
    }
    
    /**
     * Prints the update menu for a found contracotr
     * @return the choice from the keyboard
     */
    protected double printUpdateMenu(){
        System.out.println("To change  name (1)");
        System.out.println("To change  address (2)");
        System.out.println("To change phone (3)");
        System.out.println("To change email (4)");
        System.out.println("To change id (5)");
        System.out.println("To go back (6)");
        return inputDouble();
    }
    
    /**
     * Prints the menu when a contractor has been found
     */
    private void startFoundContractorMenu(){
        boolean finished = false;
        while(!finished){
            double choice = foundPersonMenu();
            if(choice == 1){
                startUpdateMenu(currentCont);
            }else if(choice == 2){
                removePerson(getCurrentPerson(),contractors,getFileName());
            }else if(choice == 3){
                finished = true;
                startContractorMenu();
            }else{
                newLine();
            }
        }
    }

}