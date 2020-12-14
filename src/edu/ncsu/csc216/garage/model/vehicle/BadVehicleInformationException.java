/**
 * 
 */
package edu.ncsu.csc216.garage.model.vehicle;

/**
 * Custom made Exception if the license or owner are not valid.
 * @author jhnguye4
 *
 */
public class BadVehicleInformationException extends Exception { 
	
	/**
	 * ID used for serialization
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor method for custom exception  if the license or owner are not valid.
	 * This constructor does not have a parameter and will display the default message.
	 * @param message Is the message that will be displayed if this exception is thrown
	 */
	public BadVehicleInformationException(String message){
		super(message);
	}
	/**
	 * Constructor method for custom exception  if the license or owner are not valid.
	 * This constructor has a parameter of the String that will be displayed
	 * 
	 */
	public BadVehicleInformationException() {
		this("Invalid");
	}
	

}
