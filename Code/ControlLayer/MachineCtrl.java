package ControlLayer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ModelLayer.Copy;
import ModelLayer.Item;
import java.util.Stack;
import ModelLayer.Machine;

public class MachineCtrl extends ItemCtrl {
    private ArrayList<Machine> machines;

    /**
     *  Constructor of class ItemCtrl
     */
    public  MachineCtrl(){

        super();
        setMachines(super.getItems().getMachines());

    }
    
    /**
     * Creates a new item(Machine), add it to a collection and save it to the file
     */
    public void createItem(String name, String barcode, double price, int quantity, String category) {
        Item machine = new Machine( name, barcode, price,  quantity,  category);
        getMachines().add((Machine) machine);
        storeItemInFile();

    }
     /**
      * Creates a new copy and add it in a collection which is in a class Machine
      * @param machineBarcode is the barcode of a machine
      * @param serialNumber is a sirial number which will be used for the new copy
      * @param status it represents the status of the copy. If it is ture the copy is free otherwise is not free
      * @return true if the copy is made and false if it is not made;
      */

    public boolean createCopy(String machineBarcode,String serialNumber, boolean status) {
        Copy copy = new Copy(serialNumber, true);
        Machine m = getItem(machineBarcode);
        if(m != null){
            ArrayList<Copy> copies = m.getCopies();
            copies.add(copy);
            storeItemInFile();
            return true;
        }else{
            return false;
        }
    }

    
    /**
      * Serach for particular copy and return it if the copy is found  otherwise return null.
      * @param machineBarcode is the barcode of the machine. It is used for searching machine by it.
      * @param serialNumber is the serial number of the copy. It is used for searching copy by it.
      * @return copy is a instance of the Copy class.
      */
    public Copy getCopy(String machineBarcode, String serialNumber) {
        ArrayList<Copy> copies = getItem(machineBarcode).getCopies();
        for(Copy copy : copies){
            if(copy.getSerialNumber().equals(serialNumber))
                return copy;
        }
        return null;
    }
    /**
     * Search for paricular Item (Machine) and return it if the machine is found otherwise return null.
     * @param barcode is the barcode of the machine. It is used for searching machine by it.
     * @return m is a instance of the Machine class or null if there was no match in searching.
     */
    
    @Override
    
    public Machine getItem(String barcode) {

        for(Machine m : getMachines()){
            if(barcode.equals(m.getBarcode()))
                return m;
        }
        return null;
    }
    
    /**
     * Store the hole collection machines in a file
     */
    @Override
    // store the Array list  in a file
    public void storeItemInFile(){
        try {
            FileOutputStream fos = new FileOutputStream("Machines.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(getMachines());
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.printf("the file   was not found");

        } catch (IOException ex) {
            ex.printStackTrace();
        } 

    }
    
    /**
     * @return machines is a collection wchich store all machine instance of class Machine
     */
    public ArrayList<Machine> getMachines() {
        return machines;
    }
    
    /**
     * replace the old collection with new one.
     * @param machines is collection which store machine instance of class Machine
     */
    public void setMachines(ArrayList<Machine> machines) {
        this.machines = machines;
    }
    
    /**
     * search for particular item by barcode and then remove it.
     * @param barcode is the barcode of the machine which is searching for removing
     */
    @Override
    public void removeItem(String barcode) {
       
          getMachines().remove(getItem(barcode));

      

    }
    /**
     * search for particular item(Machine) by barcode and then return its name.
     * @param barcode is the barcode of the machine which is searching for .
     */
    @Override
    public String getItemName(String barcode) {

        
         return getItem(barcode).getName();
        
       
    }
     /**
     * search for particular item(Machine) by barcode and then return its price.
     * @param barcode is the barcode of the machine which is searching for .
     */

    @Override
    public double getItemPrice(String barcode) {
        
         return getItem(barcode).getPrice();
        
    }
     /**
     * search for particular item(Machine) by barcode and then return its quantity.
     * @param barcode is the barcode of the machine which is searching for .
     */
    
    @Override
    public int getItemQuantity(String barcode) {

       
         return getItem(barcode).getQuantity();
        
    }
    /**
     * search for particular item(Machine) by barcode and then return its category.
     * @param barcode is the barcode of the machine which is searching for .
     */
    @Override
    public String getItemCategory(String barcode) {

       
        return getItem(barcode).getCategory();
       
    }
    /**
     * print on the consol all machines which are in the collection machines.
     */
    public void showAll(){
        for(Machine m : getMachines()){
            System.out.println(m.toString());
        }
    }
    /**
     * print on the consol all copies which are in the collection copies.
     */
    public void showAllCopies(){
        for(Machine m : getMachines()){
            for(Copy c : m.getCopies()){
                System.out.println(c.toString());
            }
        }
    }
    
    /**
     * print on the consol all copies of a particular machine searched by barcode.
     */
    
    public void showAllCopiesOfMachine(String barcode){
       
                System.out.println(getItem(barcode).getCopies());
          
        
    }
    
    /**
     * check whether the collection machines is empty
     * @return ture if the collection of machines is empty 
     * @return false if hte collectoin of machines is not empty
     */
    
    public boolean ifEmpty(){
        if(getMachines().isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * check whether the particular machines found by barcode is not equal to null. If it is not return its copies else return null.
     * @return getItem(barcode).getCopies() is the copies of particular item(Machine).
     * @return null if there is no such a machine
     */
    
    public ArrayList<Copy> getCopiesOfMachine(String barcode){
      if(getItem(barcode) != null){
          return getItem(barcode).getCopies();
      }
      return null;
    }
    
    /**
     * check whether the collection of copies for particular machine is empty
     * @return true if the collection of copies is not empty 
     * @return false if hte collectoin of copies is  empty
     */
    public boolean getcopies(String barcode){
        if(getCopiesOfMachine(barcode) != null){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * search in all machines all copies for particular copy until coincidence. If there is no coincidence returned value is null.
     * @param serialNumber is the serial number of the copy
     * @return c is the copy instance of Copy class
     * @return null is returned if there is no coincidence
     */
    public Copy getCopy(String serialnNumber){
        for(Machine m : getMachines()){
            for(Copy c : m.getCopies()){
                if(c.getSerialNumber().equals(serialnNumber))
                    return c;
            }
        }

        return null;

    }
            
 
    /**
     * check the status of pariticular copy searched by serialNumber. If there is such a copy returned value is ture for available or false which means not available
     * @param serialNubmer is the serial number of the copy
     * @return ture means available 
     * @return false means not available
     */
    public boolean getCopyStatus(String serialNumber){

        return getCopy(serialNumber).getStatus();
    }
    
      /**
       * if there is a machine of given category is pushed in the stack. At the end is returned the whole stack with all machines of the category.
       * @param category is the category of the machine by it is searched
       * @return machinesStackk is the collection of all machines of the particular category
       */
    
    public Stack<Machine> getItemsByCategory(String category ){
         Stack<Machine> machinesStackk = new Stack<Machine>();
        for(Machine m : getMachines()){
            if(m.getCategory().equals(category))
                machinesStackk.push(m);
            
        }
        
        
        return machinesStackk;
        
    }
    
    /**
       * if there is a machine of given category and at least one of its copies has status ture  is pushed in the stack.
       * At the end is returned the whole stack with all machines of the category which are available.
       * @param category is the category of the machine by it is searched
       * @return machinesTrue is the collection of all machines of the particular category which are available.
       */
      
    public Stack<Machine> getAvailableMachinebyCategory(String category){
        
        Stack<Machine> machinesTruee = new Stack<Machine>();
        Stack<Machine> var = getItemsByCategory(category);
        
    
        for(Machine m : var){
            for(Copy c: m.getCopies()){
                if(c.getStatus() == true ){
                    machinesTruee.push(m);
                    break;
                }
            }
            
        }
        
        return machinesTruee;
    }
    
    
      /**
       * if there is a machine found by given barcode  each of its  copies  whit status  equal to ture is pushed in the stack.
       * At the end is returned the whole stack with all copies of the particular machines found by barcode.
       * @param barcode is one of the value of the machine by it is searched
       * @return copiesTrue is the collection of all copies .
       */
    
    public Stack<Copy> getAvailableCopiesOfMachinebyBarcode(String barcode){
        Stack<Copy> copiesTrue  = new Stack<>();
        for(Copy c :getCopiesOfMachine(barcode)){
            if(c.getStatus() == true)
                copiesTrue.add(c);
                
        }
        return copiesTrue;
    }
    
    /**
       *Find the copy by parameter copySerNumber and change its status .
       * @param copySerNumber is the of the fields of the Copy by it is searched.
       * @param status  is the new value which will replace the old status.
       
       */
    public void changeCopyStatus(String copySerNumber, boolean status){
        
        getCopy(copySerNumber).setStatus(status);
        storeItemInFile();
    }
    
     /**
       * For each machine  each of its  copies   is pushed in the stack.
       * At the end is returned the whole stack with all copies of the particular machines.
       * @return copiesTrue is the collection of all copies .
       */
    public Stack<Copy> getCopiesOfMachines(){
        Stack<Copy> copiesTrue  = new Stack<>();
        for(Machine m : getMachines()){
            for(Copy c : m.getCopies()){
                copiesTrue.add(c);
            }
        }
        return copiesTrue;
    }
}
