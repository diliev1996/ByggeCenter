package ModelLayer;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class ItemContainer {
    private ArrayList<Product> products;
    private ArrayList<Machine> machines;
    private static ItemContainer instance;
    
    /**
     * Make one instance of the class for the first time this method is invoked and after that
     * only this instance is used.
     * @return instance is the instance of the class ItemContainer
     */
    public static ItemContainer getInstance(){
         if(instance == null){
            instance = new ItemContainer();
        }
        return instance;
    }
    
    private ItemContainer(){
        products = new ArrayList<Product>();
        machines = new ArrayList<Machine>();
        
        // Store all machine object in a array list from file
        getMachineObjects();
        getProductObjects();
        
    }
    
    
    
     /**
     * load all instances of Machine class from a file
     */
    private void getMachineObjects(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
             fis = new FileInputStream("Machines.ser");
             ois = new ObjectInputStream(fis);
            
             machines = (ArrayList<Machine>) ois.readObject();
             ois.close();
             fis.close();
            
        } catch (ClassNotFoundException ex) {
        } catch (EOFException ex) {
            
        } catch (FileNotFoundException ex) {
            
        } catch(IOException ioe){
            
            ioe.printStackTrace();
        }
        
    }
    
     /**
     * load all instances of Product class from a file
     */
    
    private void getProductObjects(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("Product.ser" );  
            ois = new ObjectInputStream(fis);

            products = (ArrayList<Product>)ois.readObject();
            ois.close();
            fis.close();
        
        }catch(ClassNotFoundException ex){
            
        }catch (FileNotFoundException ex){
            
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        
        
        
    }
    
    /**
     * @return products is the collection storing all instances of the class Product
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    /**
     * @return machines is the collection storing all instances of the class Machine
     */
    public ArrayList<Machine> getMachines() {
        return machines;
    }

    public void setMachines(ArrayList<Machine> machines) {
        this.machines = machines;
    }
    
    
}
