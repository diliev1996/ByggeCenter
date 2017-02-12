package ControlLayer;


import ModelLayer.Item;
import ModelLayer.ItemContainer;

public abstract class ItemCtrl {
	
	
	private ItemContainer items;
	/**
     *  Constructor of class TradeCtrl
     */
	public  ItemCtrl(){
		items = ItemContainer.getInstance();
	}
	
	public abstract Item getItem(String barcode);
	public abstract void storeItemInFile();
	public abstract void removeItem(String barcode);
	public abstract String getItemName(String barcode);
	public abstract double getItemPrice(String barcode);
	public abstract int getItemQuantity(String barcode);
	public abstract String getItemCategory(String barcode);
	
	
	public ItemContainer getItems() {
		return items;
	}
	public void setItems(ItemContainer items) {
		this.items = items;
	}
	
}
