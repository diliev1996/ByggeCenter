package ModelLayer;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
/**
 * Write a description of class ItemsReorderContainer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemsReorderContainer implements Serializable
{
    private Queue<Product> products;
    private static ItemsReorderContainer instance;
    /**
     * Make one instance of the class for the first time this method is invoked and after that
     * only this instance is used.
     * @return instance is the instance of the class ItemsReorderContainer
     */
    public static ItemsReorderContainer getInstance(){
        if(instance == null){
            instance = new ItemsReorderContainer();
        }
        return instance;
    }
    
    private ItemsReorderContainer(){
       
       products = new LinkedList<Product>();
       getProductForReorder();
    }
    /**
     * load all instances of Product class form  a file
     */
    private void getProductForReorder(){
      
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream("ProductReorder.ser" );
            ois = new ObjectInputStream(fis);

            products = (LinkedList<Product>)ois.readObject();
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
    public Queue<Product> getProductReorder(){
        return products;
    }
}
