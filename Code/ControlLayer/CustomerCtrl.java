package ControlLayer;

import ModelLayer.Customer;
import ModelLayer.PersonContainer;
import java.util.ArrayList;

/**
 *  Public class CustomerCtrl used to manipulate customer objects
 */
public class CustomerCtrl extends PersonCtrl{
    private final String fileName = "customers.ser";
    private ArrayList<Customer> customers;

    /**
     * Constructor of class CustomerCtrl
     */
    public CustomerCtrl() {
        customers = new ArrayList<>();
    }

    /**
     * Creates a new customer and save it to the file
     */
    public void createCustomer(String name, String address, String phone, String email, String id, 
    String group, double balance, String creditCardNo, double bill,ArrayList customers) {
        Customer cust = new Customer(name, address, phone, email, id, group, balance, creditCardNo, bill);
        addPerson(fileName,cust,customers);
    }
    

    /** @param totalPrice is the price of the sale 
     *  @param amount is the amount a customer pays
     *  @return the difference from the calculation
     */
    public double makePayment(double totalPrice, double amount){
        if(totalPrice <= amount){
            // Calculate the change
            double change =  amount - totalPrice;
            // Reset the total
            totalPrice = 0;
            return change;
        } else{
            // Maybe throw an exception instead
            return -1;
        }
    }

    /**
     *  Return a customer found by id from the collection null otherwise
     */
    public Customer findCustomer(String id) {
        for (Customer cust : customers) {
            if (cust.getID().equals(id)) {
                return cust;
            }
        }
        return null;
    }
    
    /**
     * Changes the group of a found customer and save the changes to the file
     */
    public void changeGroup(String id, String str){
       findCustomer(id).setGroup(str);
       save(fileName,customers);
    }
    
    /**
     * Changes the balance of a found customer and save the changes to the file
     */
    public void changeBalance(String id, double str){
        findCustomer(id).setBalance(str);
        save(fileName,customers);
    }
    
    /**
     * Changes the creditCardNo of a found customer and save the changes to the file
     */
    public void changeCreditCardNo(String id,String str){
        findCustomer(id).setCreditCardNo(str);
        save(fileName,customers);
    }
    
    /**
     * Changes the bill of a found customer and save the changes to the file
     */
    public void changeBill(String id,double str){
        findCustomer(id).setBill(str);
        save(fileName,customers);
    }
    
    /** @return the filename of the file where customer objects are kept
     */
    public String getFileName(){
        return fileName;
    }
    
    /** @return the balance of a find customer by id
     */
    public double getBalance(String id){
        return findCustomer(id).getBalance();
    }
    
    /** @return the bill of a find customer by id
     */
    public double getBill(String id){
        return findCustomer(id).getBill();
    }
    
    /**  @return the creditCardNo of a find customer by id 
     */
    public String getCreditCardNo(String id){
        return findCustomer(id).getCreditCardNo();
    }
    
    public void changeProductsBought(String id,double total){
        Customer cs = findCustomer(id);
        cs.setProductsBought(cs.getProductsBought() + total);
        save(fileName,customers);
    }
    
    /**
     * @return the group of a find customer by id
     */
    public String getGroup(String id){
        return findCustomer(id).getGroup();
    }
    
    /** @return an arrayList of ordered goods by a customer 
     */
    public ArrayList getOrderedGoods(String id){
        return findCustomer(id).getOrderedGoods();
    }
    
    /** adds an arrayList of items to a customer order goods
    */
    public void addProducts(String id,ArrayList items){
        getOrderedGoods(id).add(items);
    }
    
    /** remove products from a customer's products 
     */
    public void removeProducts(String id,ArrayList items){
        getOrderedGoods(id).removeAll(items);
    }
    
}