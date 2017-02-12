package ModelLayer;

import java.io.Serializable;

public class Product extends Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1722116074418945698L;
	private String location;
	private int minimum;
	private int maximum;
	
	public Product(String name, String barcode, double price, int quantity, String category,String location){
		super(name, barcode, price , quantity, category);
		
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Product [location=" + location + ", toString()=" + super.toString() + "]";
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
}
