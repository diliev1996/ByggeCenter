package UILayer;
import ControlLayer.MachineCtrl;

class MachineUI extends UIInputClass{
    private MachineCtrl machCtrl;
    private String currentMachine;
    private String currentCopy;
    /**
     * Constructor for objects of class MachineUI
     */
    MachineUI(){
        machCtrl = new MachineCtrl();

    }

    /** Writing the main menu of this class 
     * @return the input from the user
     */
    private int writeStartMenu(){
        System.out.println(" (1) To create new machine ");
        System.out.println(" (2) To create a copy of machine ");
        System.out.println(" (3) To find machine ");
        System.out.println(" (4) To find copy ");
        System.out.println(" (5) To find copy a specified machine ");
        System.out.println(" (6) To see all machines ");
        System.out.println(" (7) To see all copies of a machine " );
        System.out.println(" (8) To see all copies ");
        System.out.println(" (9) To go back ");
        return inputInteger();
    }
    
    /**
     * @return the currentMachine loaded
     */
    protected String getCurrentMachine(){
        return currentMachine;
    }
    
    /**
     * @return the current Copy loaded
     */
    protected String getCurrentCopy(){
        return currentCopy;
    }

    /**
     *  Start menu of this class 
     */
    protected void startMenu(){
        boolean finished = false;

        while(!finished){
            int choice = writeStartMenu();
            if(choice == 1){
                createMachine();
            }else if(choice == 2){
                createCopy();
            }else if(choice == 3){
                findMachine();
            }else if(choice == 4){
                findCopyBySerialNumb();
            }else if(choice == 5){
                findCopy();
            }else if(choice == 6){
                if(!ifEmpty()){
                    machCtrl.showAll();
                }
            }else if(choice == 7){
                if(!ifEmpty()){
                    showAllCopiesOfMachine();
                }
            }else if(choice == 8){
                if(!ifEmpty()){
                    machCtrl.showAllCopies();
                }
            }else if(choice == 9){
                finished = true;
            }else{
                newLine();
            }
        }
    }
    
    /**
     * Checks if the machine collection  is empty 
     */
    protected boolean ifEmpty(){
        if(machCtrl.ifEmpty()){
            System.out.println("No machines yet");
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Showing all copies of a machine if not empty
     */
    protected void showAllCopiesOfMachine(){
        String str = inputMachBarcode();
        if(machCtrl.getCopiesOfMachine(str) != null){
            machCtrl.showAllCopiesOfMachine(str);
        }else{
            System.out.println("Machine doesn't have any copies");
        }
    }

    /** Method for creating a machine
     */
    protected void createMachine(){
        System.out.println("Enter machine name");
        String name = inputString();        
        System.out.println("Enter price per day ");
        double prPerDay = inputDouble();
        System.out.println("Enter how many machines");
        int howMany = inputInteger();
        System.out.println("Enter machine category");
        String category = inputNotRestrictedString();

        machCtrl.createItem(name,inputMachBarcode(),prPerDay,howMany,category);
        System.out.println("Machine created successfuly");
    }

    /**
     * Finding a machine by barcode if the collection is not empty
     */
    protected void findMachine(){
        String str = inputMachBarcode();
        if(!machCtrl.getMachines().isEmpty()){
            if(machCtrl.getItem(str) != null){
                System.out.println(machCtrl.getItem(str));
                currentMachine = machCtrl.getItem(str).getName();
            }else{
                System.out.println("Machine not found");
            }
        }else{
            System.out.println("No machines created yet");
        }
    }

    /**
     * Finding a copy by the barcode of the machine and the serailNumber of the copy
     */
    protected void findCopy(){
        String str = inputMachBarcode();
        if(machCtrl.getcopies(str)){
            String copy = inputCopySer();
            System.out.println(machCtrl.getCopy(str,copy).toString());
            currentCopy = machCtrl.getCopy(str,copy).toString();
        }else{
            System.out.println("No copies of that machine");
        }
    }

    /** Finding a copy by serial number 
     * 
     */protected void findCopyBySerialNumb(){
        String serialNumb = inputCopySer();
        if(machCtrl.getCopy(serialNumb) != null){
            System.out.println(machCtrl.getCopy(serialNumb).toString());
        }else{
            System.out.println("No copy with that serialNumber found");
        }
    }

    /** Printing all copies of a particuliar machine
     * 
     */protected void getAllCopiesOfMachine(){
        String barcode = inputNotRestrictedString();
        if(!machCtrl.getCopiesOfMachine(barcode).isEmpty()){
            System.out.println(machCtrl.getCopiesOfMachine(barcode).toString());
        }else{
            System.out.println("No copies creaated yet");
        }
    }   

    /** Creates a copy to a particuliar machine
     * 
     */protected void createCopy(){        
        if(machCtrl.createCopy(inputMachBarcode(),inputCopySer(),true)){
            System.out.println("Copy created successfuly");
        }else{
            System.out.println("No machine with that barcode");
        }
    }
    
    
    /**
     * The input from this method becomes the barcode of the machine
     */protected String inputMachBarcode(){
        System.out.println("Enter barcode of the machine");
        return inputNotRestrictedString();
    }
    
    /**
     * The input from this method becomes the serial number of the copy
     */
    protected String inputCopySer(){
        System.out.println("Enter copy serialNuber");
        return inputNotRestrictedString();
    }

}
