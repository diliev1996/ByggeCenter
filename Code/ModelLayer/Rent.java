package ModelLayer;

import java.io.Serializable;

public class Rent extends Trade implements Serializable {
    private static final long serialVersionUID = 1459389525018201029L;
    private int period;
    private String borrowDate ;
    private String copy;
    private String machineBarcode;


    public Rent(double price, int dicount, String custID, String empID,String id, int period, String borrowDate,String copy ,String machineBarcode) {
        super(price, dicount, custID, empID,id);
		
		setPeriod(period);
		setBorrowDate(borrowDate);
	
		setCopy(copy);
		setMachineBarcode(machineBarcode);
		
	}
    
    public int getPeriod() {
        return period;
    }

    public void setPeriod(int newPeriod) {
        period = newPeriod;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String newBorrowDate) {
        borrowDate = borrowDate;
    }
   



	public String getCopy() {
		return copy;
	}





	public void setCopy(String copy) {
		this.copy = copy;
	}





	public String getMachineBarcode() {
		return machineBarcode;
	}





	public void setMachineBarcode(String machineBarcode) {
		this.machineBarcode = machineBarcode;
	}
	public String toString() {
		return "Rent [ period=" + period + ", borrowDate=" + borrowDate + ", copy=" + copy
				+ ", machineBarcode=" + machineBarcode +  super.toString() + "]";
	}

}
