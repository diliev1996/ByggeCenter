
package ModelLayer;
import java.util.ArrayList;

/**
 * Public class Contractor subclass of Person
 */
public class Contractor extends Person{
    
    private ArrayList<Item> requestForReorder;
    
    /** Constructor of class Contractor
     */
    public Contractor(String name, String address, String phone, String email, String id) {
        super(name, address, phone, email, id);
        requestForReorder = new ArrayList<>();
    }
    
    /** Returns a list of products requested from the contractor
     */
    public ArrayList getRequestForReorder(){
        return requestForReorder;
    }
}
