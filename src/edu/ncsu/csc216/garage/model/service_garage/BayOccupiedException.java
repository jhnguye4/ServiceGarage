/**
 * 
 */
package edu.ncsu.csc216.garage.model.service_garage;

/**
 * Custom made Exception if a vehicle attempts to occupy a non-empty, open service bay.
 * @author jhnguye4
 *
 */
public class BayOccupiedException extends Exception { 
	
	/**
	 * ID used for serialization
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor method for custom exception if a vehicle attempts to occupy a non-empty, open service bay. 
	 * This constructor has a parameter of the String that will be displayed
	 * 
	 * @param message Is the message that will be displayed if this exception is thrown
	 */

	public BayOccupiedException(String message) {
		super(message);
	}
	/**
	 * Constructor method for custom exception if a vehicle attempts to occupy a non-empty, open service bay.
	 * This constructor does not have a parameter and will display the default message.
	 * 
	 */
	public BayOccupiedException() {
		this("Bay is occupied.");
	}
	

}
