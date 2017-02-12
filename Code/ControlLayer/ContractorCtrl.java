package ControlLayer;
import ModelLayer.Contractor;
import ModelLayer.PersonContainer;
import java.util.ArrayList;

/**
 * Public class ContractorCtrl used to manipulate Contractor objects
 */
public class ContractorCtrl extends PersonCtrl{    
    private ArrayList<Contractor> contractors;
    private final String fileName = "contractors.ser";
     
    /**
     * Constructor of clas ContractorCtrl
     */
    public ContractorCtrl(){
        contractors = new ArrayList<>();
    }
    
    /**
     *  Creates a new contractor and add it to a file
     */
    public void createContractor(String name,String address, String phone, String email,String id, ArrayList contractors){
        Contractor cont = new Contractor(name,address,phone,email,id);
        addPerson(fileName,cont,contractors);
    }
    
    /**
     * Return a Contractor object if it was found in the collection null otherwise
     */
    public Contractor findContractor(String id){
        loadPeople(fileName);
        for(Contractor contractor : contractors){
            if(contractor.getID().equals(id)){
                return contractor;
            }
        }
        return null;
    }
    
    /** @return the filename where the contractors are saved
     */
    public String getFileName(){
        return fileName;
    }
}
