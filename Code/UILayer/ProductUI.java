package UILayer;
import ControlLayer.*;
import java.util.Scanner;
/**
 * Write a description of class ProductUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class ProductUI extends UIInputClass{
    private ProductCtrl prCtrl;
    private String currentProduct;
    /**
     * Constructor for objects of class ProductUI
     */
    ProductUI(){
        prCtrl = new ProductCtrl();
    }
    
    /**
     * Main menu of this class starting a menu with different options
     */
    protected void ProductMenu(){
        boolean finished = false;
        while(!finished){
            double choice = writeProductMenu();
            if(choice ==1){
                createItem();
            }else if(choice == 2){
                findItem();
                if(currentProduct !=null){
                    startUpdateMenu(currentProduct);
                }
            }else if(choice == 3){
                if(!prCtrl.getProducts().isEmpty()){
                    prCtrl.showAll();
                }else{
                    System.out.println("No products registered");
                }
            }else if(choice == 4){
                finished = true;
            }else{
                newLine();
            }
        }
    }
    
    /**
     * Writing the main menu for the products 
     * @return the input from the user
     */
    private double writeProductMenu(){
        System.out.println("To create product (1)");
        System.out.println("To find product (2)");
        System.out.println("To see all (3)");
        System.out.println("To go back (4)");
        return inputDouble();
    }
    
    /**
     * Method to create a new product
     */
    protected void createItem(){
        System.out.println("Input product name");
        String name = inputNotRestrictedString();
        System.out.println("Input barcode");
        String barcode = inputNotRestrictedString();
        System.out.println("Input price of the item");
        double price = inputDouble();
        System.out.println("Input quantity of the product");
        int quantity = inputInteger();
        System.out.println("Input category of the product");
        String category = inputNotRestrictedString();
        System.out.println("Input location");
        String location = inputNotRestrictedString();
        System.out.println("Input minimum quantity of the product (when reached a request will be send to reorder)");
        int min = inputInteger();
        System.out.println("Input maximum quantity to be kept on stock (a request which will exceed this limit is not allowed)");
        int max = inputInteger();
        
        prCtrl.createItem(name,barcode,price,quantity,category,location,min,max);
        System.out.println("Product created succefully");
    }
    
    /**
     *  Finding an item in by barcode
     */protected String findItem(){
        System.out.println("Input the barcode of the product");
        String barcode = inputNotRestrictedString();
        try{
            prCtrl.getItem(barcode).toString();
            System.out.println(prCtrl.getItem(barcode).toString());
            currentProduct = barcode;
        }catch(NullPointerException ne){
            System.out.println("No product with that barcode");
        }
        return currentProduct;
    }
    
      /** Starts an update menu over a desired employee found by id
     */
    private void startUpdateMenu(String id) {
        boolean finished = false;
        int index = 0;
       
        if(id != null){
            while (!finished) {
                double choice = printUpdateMenu();
                if (choice == 1) {
                    System.out.println("Input minimum quantity of the product (when reached a request will be send to reorder)");
                    index = inputInteger();
                    prCtrl.setMinimumBorder(id,index);
                } else if (choice == 2) {
                    System.out.println("Input maximum quantity to be kept on stock (a request which will exceed this limit is not allowed)");
                    index = inputInteger();
                    prCtrl.setMaximumBorder(id,index);
                }else if(choice ==3){
                    finished = true;
                }else {
                    newLine();
                }
                System.out.println("Changes made succesfuly");
            }
        }else{
            finished = true;
        }
    }
    
        /**
     * Prints the update menu with override call to the superClass
     * returns the choice from the keyboard
     */
    protected double printUpdateMenu(){
        System.out.println("To change minumum quanity (1)");
        System.out.println("To change maximum quantity(2)");
        System.out.println("To go back (3)");
        return inputDouble();
    }
    
    

}
