/**
 * 
 */
package edu.ncsu.csc216.garage.model.service_garage;

/**
 * Custom made Exception if the service bay is already occupied.
 * @author jhnguye4
 *
 */
public class BayCarMismatchException extends Exception { 
	
	/**
	 * ID used for serialization
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor method for custom exception if the service bay is already occupied.. 
	 * This constructor has a parameter of the String that will be displayed
	 * 
	 * @param message Is the message that will be displayed if this exception is thrown
	 */
	
	public BayCarMismatchException(String message) {
		super(message);
	}
	/**
	 * Constructor method for custom exception if user adds an activity that conflicts time. 
	 * This constructor does not have a parameter and will display the default message.
	 * 
	 */
	public BayCarMismatchException() {
		this("Bay Mismatch Exception.");
	}

}
