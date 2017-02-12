package ModelLayer;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class TradeContainer implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -8547958876751462729L;
    private ArrayList<Order> orders;
    private ArrayList<Rent> rents;
    private LinkedList<ProductSale> sales;
    private String fileNameSale;
    private String fileNameOrder;
    private String fileNameRent;
    private static TradeContainer instance;
    
    /**
     * Make one instance of the class for the first time this method is invoked and after that
     * only this instance is used.
     * @return instance is the instance of the class TradeContainer
     */
    public static TradeContainer getInstance(){
         if(instance == null){
            instance = new TradeContainer();
        }
        return instance;
    }
    
    private TradeContainer(){
        sales = new LinkedList<ProductSale>();
        orders = new ArrayList<Order>();
        rents = new ArrayList<Rent>();
        setFileNameSale("Sales.ser");
        setFileNameOrder("Orders.ser");
        setFileNameRent("Rent.ser");
        getTradeObjects();
        getTradeRent();
        getTradeSale();
    }
    /**
     * @return orders is the collection storing all instances of the class Order
     */
    public ArrayList<Order> getOrders(){
 
        return orders;
    }
    /**
     * @return rents is the collection storing all instances of the class Rent
     */
    public ArrayList<Rent> getRents(){
        return rents;
    }
    /**
     * load all instances of ProductSale class from a file
     */
    private void getTradeSale(){
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
             fis = new FileInputStream(getFileNameSale());
             ois = new ObjectInputStream(fis);
            
             sales = (LinkedList<ProductSale>) ois.readObject();
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
     * load all instances of Rent class from  a file
     */
    private void getTradeRent(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
             fis = new FileInputStream(getFileNameRent());
             ois = new ObjectInputStream(fis);
            
             rents= (ArrayList<Rent>) ois.readObject();
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
     * load all instances of Order class from  a file
     */
    private void getTradeObjects(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
             fis = new FileInputStream(getFileNameOrder());
             ois = new ObjectInputStream(fis);
            
             orders= (ArrayList<Order>) ois.readObject();
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
     * @return fileNameOrder is the name of the file storing Order instances
     */
    public String getFileNameOrder() {
        return fileNameOrder;
    }
    public void setFileNameOrder(String fileNameOrder) {
        this.fileNameOrder = fileNameOrder;
    }
     /**
     * @return fileNameRent is the name of the file storing Rent instances
     */
    public String getFileNameRent() {
        return fileNameRent;
    }
    public void setFileNameRent(String fileNameRent) {
        this.fileNameRent = fileNameRent;
    }
     /**
     * @return sales is the name of the file storing ProductSale instances
     */
    public LinkedList<ProductSale> getSales() {
        return sales;
    }
    public void setSales(LinkedList<ProductSale> sales) {
        this.sales = sales;
    }
    public String getFileNameSale() {
        return fileNameSale;
    }
    public void setFileNameSale(String fileNameSale) {
        this.fileNameSale = fileNameSale;
    }
}
