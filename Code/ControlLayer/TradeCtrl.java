package ControlLayer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ModelLayer.Order;
import ModelLayer.Trade;
import ModelLayer.TradeContainer;

public abstract class TradeCtrl {
	private TradeContainer tradeCont;
	
	 /**
     *  Constructor of class TradeCtrl
     */
	public TradeCtrl(){
		setTradeCont(TradeContainer.getInstance());
	
		
		
	}
	/**
     * @return tradeCont is the container which store all trades instance.
     */
	public TradeContainer getTradeCont() {
		return tradeCont;
	}
	public void setTradeCont(TradeContainer tradeCont) {
		this.tradeCont = tradeCont;
	}
	public abstract void removeTrade( String id);
	public abstract double getTradePrice(String id);
	public abstract Trade findTrade(String id);
	public abstract  String getTradeCustID(String id);

	public abstract  String getTradeEmplID(String id);
	
	/**
     * Store a given collection to a file
     * @param fileName is the name of the file
     * @param collection is the collection which we want to store to a file
     */
	
	public void storeTradeInFile(String filename, ArrayList collection){
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(collection);
			oos.close();
			fos.close();
		} catch (FileNotFoundException ex) {
			System.out.printf("the file   was not found");

		} catch (IOException ex) {
			ex.printStackTrace();
		} 
		
	}
	
	
}
