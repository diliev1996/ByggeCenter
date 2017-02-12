package ControlLayer;

import java.util.ArrayList;

import ModelLayer.Order;
import ModelLayer.Rent;

public class RentCtrl extends TradeCtrl{
    private ArrayList<Rent> rents;
    private String fileName ;
    private MachineCtrl machineCtrl;
    
    /**
     *  Constructor of class ItemCtrl
     */
    public RentCtrl(){
        
        super();
        setFileName(super.getTradeCont().getFileNameRent());
        rents = super.getTradeCont().getRents();
        machineCtrl = new MachineCtrl();
    }
     /**
     * Creates a new newRent, add it to a collection and save it to the file
     */
    public void newRent( int dicount, String custID, String empID,String id, int period, String borrowDate, String copyID, String machineBarcode){
    
        
        double price= machineCtrl.getItemPrice(machineBarcode)*period;
        
        if(dicount> 0){
            float discount = (float)price* dicount/100;
         price =  (float)(price - discount);
        }
        machineCtrl.changeCopyStatus(copyID, false);
        Rent rent  = new Rent(price, dicount,  custID, empID, id, period,  borrowDate, copyID, machineBarcode);
        
    
        rents.add(rent);
        machineCtrl.storeItemInFile();
        super.storeTradeInFile(fileName, rents);
        
    }
     /**
     * @return fileName is the name of the file which is used for storing order instances
     */
    
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    
   /**
     * Returns all Rents instance
     * @return rents is the collection which store all rents instance
     */

    public ArrayList<Rent> getRents() {
        return rents;
    }

    public void setRents(ArrayList<Rent> rents) {
        this.rents = rents;
    }
    /**
     * Search instance of the class Rent by id and if it is found remove it.
     */

    @Override
    public void removeTrade(String id) {
        
        getRents().remove(findTrade(id));
        
    }

    /**
     * Search instance of the class Order by id and if it is found return its price.
     * @return findTrade(id).getPrice() is the price field of the class Order.
     */
    @Override
    public double getTradePrice(String id) {
        
        return findTrade(id).getPrice();
    }
     /**
     * Search instance of the class Order by id and if it is found return it.
     * @return or is the instance of the class Order
     */

    @Override
    public Rent findTrade(String id) {
        try{
        for(Rent r: getRents()){
            if(r.getId().equals(id))
                return r;
        }
        }catch(Exception ex ){
            ex.printStackTrace();
        }
        return null;
    }

     /**
     * Search instance of the class Rent by id and if it is found return it.
     * @return findTrade(id).getCustID() is the custID field of the class Rent.
     */

    @Override
    public String getTradeCustID(String id) {
    
        return findTrade(id).getCustID();
    }

     /**
     * Search instance of the class Rent by id and if it is found return it.
     * @return findTrade(id).getEmpID() is the empID field of the class Rent.
     */
    @Override
    public String getTradeEmplID(String id) {
        
        return findTrade(id).getEmpID();
    }

    public MachineCtrl getMachineCtrl() {
        return machineCtrl;
    }

    public void setMachineCtrl(MachineCtrl machineCtrl) {
        this.machineCtrl = machineCtrl;
    }

}
