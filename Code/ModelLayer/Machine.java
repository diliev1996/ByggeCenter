package ModelLayer;

import java.io.Serializable;
import java.util.ArrayList;

public class Machine extends Item implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5315657149769871414L;
	private ArrayList<Copy> copies;
	
	//create Machine
	public Machine(String name, String barcode, double price, int quantity, String category){
		super(name, barcode, price, quantity, category);
		copies = new ArrayList<Copy>();
	}

	public ArrayList<Copy> getCopies() {
		return copies;
	}

	public void setCopies(ArrayList<Copy> copies) {
		this.copies = copies;
	}

	@Override
	public String toString() {
		return "Machine [ "+ super.toString()  + "]"+ "\n";
	}

	
	
	

}
