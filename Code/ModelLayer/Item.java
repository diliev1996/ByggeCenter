package ModelLayer;

import java.io.Serializable;

public abstract class Item implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8256556348195959378L;
	private String name;
	private String barcode;
	private double price;
	private int quantity;
	private String category;
	
	public Item(String name, String barcode, double price, int quantity, String category){
		setName(name);
		setBarcode(barcode);
		setPrice(price);
		setQuantity(quantity);
		setCategory(category);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Item [name=" + name + ", barcode=" + barcode + ", price=" + price + ", quantity=" + quantity
				+ ", category=" + category + "]";
	}
	

}
