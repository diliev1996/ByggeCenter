package ModelLayer;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Trade implements Serializable {
    private static final long serialVersionUID = -4048681096091498081L;
    private double price;
    private int dicount;
    private  String custID;
    private String empID;
    private String id;
    public Trade(double price, int dicount, String custID, String empID,String id) {
        this.price = price;
        this.dicount = dicount;
        this.custID = custID;
        this.empID = empID;
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDicount() {
        return dicount;
    }

    public void setDicount(int dicount) {
        this.dicount = dicount;
    }
    
    public void setId(String newId){
        id = newId;
    }
    
    public String getId(){
        return id;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String newCustID) {
        custID = newCustID;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String newEmpID) {
        empID = newEmpID;
    }

    @Override
    public String toString() {
		//set the number of decimal places
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);
		return "Trade [price=" + df.format(price) + ", dicount=" + dicount + ", custID=" + custID + ", empID= " + empID + " id " + id + "\n";
	}


}
