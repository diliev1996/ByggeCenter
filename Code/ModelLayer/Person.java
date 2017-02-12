package ModelLayer;
import java.io.Serializable;
/** 
 * Super claass Person 
 * 
 */
public class Person implements Serializable{
    private String name;
    private String address;
    private String phone;
    private String email;
    private String id;
    
    /** Constructor of super class Person 
     */
    public Person(String name,String address, String phone, String email, String id){
        this.name = name; 
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.id = id;
    }
    
    /** Return the name of the person
     */
    public String getName(){
        return name;
    }
    
    /**  Return the address of the person
     */
    public String getAddress(){
        return address;
    }
    
    /**  Return the phone of the person
     */
    public String getPhone(){
        return phone;
    }
    
    /**  Return the email of the person
     */
    public String getEmail(){
        return email;
    }
    
    /**  Return the id of the person
     */
    public String getID(){
        return id;
    }
    
    /**  Changes the name of the person
     */
    public void setName(String newName){
        name = newName;
    }
    
    /**  Changes the address of the person
     */
    public void setAddress(String newAddress){
        address = newAddress;
    }
    
    /**  Changes the phone of the person
     */
    public void setPhone(String newPhone){
        phone = newPhone;
    }
    
    /**  Changes the email of the person
     */
    public void setEmail(String newMail){
        email = newMail;
    }
    
    /**  Changes the id of the person
     */
    public void setID(String newID){
        id = newID;
    }
    
    /** Return a String representation of the person
     */
    public String toString(){
        return "Name " + name + " Address " + address + " Phone " + phone 
        + " Email " + email + " Id " + id;
    }
    
}
