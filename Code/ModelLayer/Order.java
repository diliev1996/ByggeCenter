package ModelLayer;

import java.io.Serializable;

public class Order extends Trade implements Serializable{
	private static final long serialVersionUID = -4768524439131783770L;
	
	public Order(double price, int dicount, String custID, String empID, String id) {
		super(price, dicount, custID, empID,id);
	}
}
