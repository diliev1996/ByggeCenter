
package ModelLayer;

import java.util.ArrayList;

/**
 *  public class Customer subclass of Person
 */
public class Customer extends Person{
    private String group;
    private double balance;
    private String creditCardNo;
    private ArrayList<Item> orderedGoods;
    private double bill;
    private double productsBought;
    private ArrayList<Rent> rents;
   /** Constructor of class Customer
    */
   public Customer(String name, String address, String phone, String email, String id,String group,double balance,String creditCardNo,double bill) {
        super(name, address, phone, email, id);
        this.group = group;
        this.balance = balance;
        this.creditCardNo = creditCardNo;
        this.bill = bill;
        orderedGoods = new ArrayList<Item>();
        rents = new ArrayList<Rent>();
        productsBought = 0;
    }
    
   /** @retutn the price of the products bought by a customer object
    */
   public double getProductsBought(){
       return productsBought;
    }
    
   /** Return all the rents a customer has 
    */
   public ArrayList<Rent> getRents(){
      return rents;
   }
    
   /** Changes the price of the products bought by a customer object
    */
   public void setProductsBought(double newDouble){
       productsBought = newDouble;
    }
    
   /** Return the group of the customer
    */
   public String getGroup(){
        return group;
    }
   
   /** Return the balance of the customer
    */
   public double getBalance(){
        return balance;
    }
    
   /** Return the creditCardNo of the customer
    */
   public String getCreditCardNo(){
        return creditCardNo;
    }
    
   /** Return a list of products ordered by the customer
    */
   public ArrayList getOrderedGoods(){
        return orderedGoods;
    }
    
   /** Return the amount of bill of the customer
    */
   public double getBill(){
        return bill;
    }
    
   /** Changes the group of the customer
    */
   public void setGroup(String newGroup){
        group = newGroup;
    }
    
   /** Changes the balance of the customer
    */
   public void setBalance(double newBalance){
        balance = newBalance;
    }
    
   /**
    *  Changes the creditCardNo of the customer
    */
   public void setCreditCardNo(String newCreditCard){
     creditCardNo = newCreditCard;   
    }
    
   /**  Changes the amount of bill the customer owns     
    */
   public void setBill(double newBill){
       bill = newBill;
   }
   
   /** Returns a String representative of the customer
    */
   public String toString(){
       return super.toString() + " Group " + group + " Balance " + balance + " CreditCardNo " + creditCardNo + " Bill " + bill + "Products bought " + productsBought;
    }
}
