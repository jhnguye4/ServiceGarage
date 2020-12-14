package edu.ncsu.csc216.garage.model.service_garage;

import edu.ncsu.csc216.garage.model.vehicle.Vehicle;

/**
 * The ServiceBay class holds all the functionalities of the service bay such as occupying or 
 * releasing a vehicle in a service bay.
 * @author jhnguye4
 *
 */
public class ServiceBay {
	/**private field for occupied*/
	private boolean occupied;
	/**private field for bayId*/
	private String bayID;
	/**private field for nextNumbder*/
	private static int nextNumber;
	/**private field for current vehicle*/
	private Vehicle myVehicle;
	
	/**
	 * Static method. Resets the service bay numbering to start from 1 
	 * (so the next 3 bays added for this project would have numbers/IDs E01, 102, and 103).
	 */
	public static void startBayNumberingAt101() {
		nextNumber = 101;
	}
	
	/**
	 * Same as null constructor but the prefix is the first non-whitespace character in the argument or “1” if there is no such character. 
	 * @param prefix the first non-whitespace character in the argument or "1" if no character
	 */
	public ServiceBay(String prefix) {
		if(nextNumber == 0) {
			startBayNumberingAt101();
		}
		if(prefix == null) {
			bayID = Integer.toString(nextNumber);
		}
		else if(prefix.trim().equals("")) {
			bayID = Integer.toString(nextNumber);
			
		} else {
			String num = String.valueOf(nextNumber).substring(1);
			bayID = prefix.trim().substring(0, 1) + num;
			
		}
		occupied = false;
		nextNumber++;
	}
	
	/**
	 * Creates a new empty service bay according to the current bay numbering, then increments that number. The prefix is “1”.
	 */
	public ServiceBay() {
		this("");

	}
	
	/**
	 * Returns the BayID
	 * @return String of BayID
	 */
	public String getBayID() {
		return bayID;
	}
	
	/**
	 * Checks if the bay is occupied
	 * @return true if bay is occupied
	 */
	public boolean isOccupied() {
		return occupied;
	}
	
	/**
	 * Removes the vehicle currently in the service bay and returns it. 
	 * @return Vehicle that is released from service bay
	 */
	public Vehicle release() {
		occupied = false;
		Vehicle vehicle = myVehicle;
		myVehicle = null;
		return vehicle;
	}
	
	/**
	 * Occupies the service bay with the given vehicle. Throws a BayOccupiedException if the service bay is already occupied.
	 * @param v is the vehicle that the bay will occupy
	 * @throws BayOccupiedException if the service bay is already occupied.
	 * @throws BayCarMismatchException  if the vehicle is not the correct vehicle for the bay.
	 */
	public void occupy(Vehicle v) throws BayOccupiedException, BayCarMismatchException {
		if(occupied) {
			throw new BayOccupiedException();
		}
		myVehicle = v;
		occupied = true;
	}
	
	/**
	 * Formats the string representation of the service bay. 
	 * @return String representation of the service bay.
	 */
	public String toString() {
		if(myVehicle == null) {
			return bayID + ": EMPTY"; 
		}
		return String.format("%s: %-9s%s", bayID, myVehicle.getLicense(), myVehicle.getName());
	}
}
