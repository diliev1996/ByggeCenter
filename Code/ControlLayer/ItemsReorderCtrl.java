package ControlLayer;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import ModelLayer.*;
/**
 * Write a description of class ItemsReorderCtrl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemsReorderCtrl
{
    private Queue<Product> products;
    private ItemsReorderContainer container ;
     /**
     *  Constructor of class ItemsReorderCtrl
     */
    public ItemsReorderCtrl(){
        
        container = ItemsReorderContainer.getInstance();
        products = container.getProductReorder();
    }
        /**
      * store product in file
      */
    public void storeItemInFile() {
        try{
            
            FileOutputStream fos = new FileOutputStream("ProductReorder.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(products);
            oos.close();
            fos.close();
            
        } catch (FileNotFoundException ex) {
            System.out.printf("the file   was not found");

        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        
    }
    /**
     * add product instance in the collection and store it to a file.
     */
    public void addProductForReorder(Product product){        
        products.add(product);
        storeItemInFile();
    }
    /**
      * @return products is a collection which store all product instances which are met
      * the minimum porder of a quantity.
      */
    
    public Queue<Product> getProductsForReorder(){
        
        return products;
    }
    
    /**
     * Get eact  product from the products collection and set  new quantity for each product
     */
     public void makeReorder(){
        ProductCtrl pro = new ProductCtrl();
        if(products.isEmpty()){
            System.out.println(" There is no item which meet the minimum limit");
        }
        Scanner input = new Scanner(System.in);
        while(products.size() > 0 ){
            
            Product pr = products.remove();
            System.out.println(pr);
            System.out.println(" Type the quantity you want to reorder"); 
            int quantity = input.nextInt();
            
            int beforeOrd = pr.getQuantity();
            pro.setQuantity(pr.getBarcode(),quantity+beforeOrd);
            int afterOrd = pr.getQuantity();
            if(afterOrd >=pr.getMaximum()){
                System.out.println("The maximum limit has been exceeded");
                 pro.setQuantity(pr.getBarcode(),beforeOrd);
            }else{
               
             
                System.out.println("The reorder has been successful");
              
            }
        }
        storeItemInFile();
     
    }
    
}
