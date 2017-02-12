package ModelLayer;

import java.io.Serializable;

public class Copy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7228761213389637380L;
	private String serialNumber;
	private boolean status;
	
	public Copy(String serialNumber, boolean status){
		setSerialNumber(serialNumber);
		setStatus(status);
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	public String toString() {
		return "Copy [getSerialNumber()=" + getSerialNumber() + ", getStatus()=" + getStatus() + "]"+ "\n";
	}

}
