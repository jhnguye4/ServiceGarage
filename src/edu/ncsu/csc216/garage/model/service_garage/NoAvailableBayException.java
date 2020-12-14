package edu.ncsu.csc216.garage.model.service_garage;

/**
 * Custom made Exception if a vehicle attempts to enter the garage for service but no appropriate bays are open.
 * @author jhnguye4
 *
 */
public class NoAvailableBayException extends Exception { 
	
	/**
	 * ID used for serialization
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor method for custom exception if a vehicle attempts to enter the garage for service but no appropriate bays are open.
	 * This constructor does not have a parameter and will display the default message.
	 * @param message Is the message that will be displayed if this exception is thrown
	 */
	public NoAvailableBayException(String message) {
		super(message);
	}
	
	/**
	 * Constructor method for custom exception if a vehicle attempts to enter the garage for service but no appropriate bays are open.
	 * This constructor has a parameter of the String that will be displayed
	 * 
	 */
	public NoAvailableBayException() {
		this("No Bays Open.");
	}
	

}
