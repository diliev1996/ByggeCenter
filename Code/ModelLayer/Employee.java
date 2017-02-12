
package ModelLayer;
import java.util.ArrayList;
/**
 * Public class Employee subclass of Person
 */
public class Employee extends Person{
    private String bankAcc;
    private String position;
    private double salary;
    private double productsSold;
    private ArrayList<Rent> rents;
    /** Constructor of class Employee
     */
    public Employee(String name, String address, String phone, String email, String id,String bankAcc,String position,double salary) {
        super(name, address, phone, email, id);
        this.bankAcc = bankAcc;
        this.position = position;
        this.salary = salary;
        rents = new ArrayList<Rent>();
    }
    
    /** @return the products sold by the employee as price 
     */
    public double getProductsSold(){
        return productsSold;
    }
    
    /** @return all rents the employee has made 
     */
    public ArrayList<Rent> getRents(){
        return rents;
    }

    /** Changing the price of the products an employee object has sold
     */
    public void setProductsSold(double newProducts){
        productsSold = newProducts;
    }
    
    /** Returns the bank account of the employee
     */
    public String getBankAcc(){
        return bankAcc;
    }
    
    /** Returns the position of the employee
     */
    public String getPosition(){
        return position;
    }
    
    /** Returns the salary of the employee
     */
    public double getSalary(){
        return salary;
    }
    
    /** Changes the salary of the employee
     */
    public void setSalary(Double newSalary){
            salary = newSalary;
    }
    
    /** Changes the bank account of the employee
     */
    public void setBankAcc(String newBankAcc){
        bankAcc = newBankAcc;
    }
    
    /** Changes the position of the employee 
     */
    public void setPosition(String newPosition){
        position = newPosition;
    }
    
    /** Returns a string represeting the employee
     */
    public String toString(){
       return super.toString() + " bankAcc " + bankAcc + " position " + position + " Salary " + salary + "Products sold " + productsSold;
    }
}
