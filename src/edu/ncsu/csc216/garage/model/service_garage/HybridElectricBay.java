/**
 * 
 */
package edu.ncsu.csc216.garage.model.service_garage;

import edu.ncsu.csc216.garage.model.vehicle.Vehicle;

/**
 * Is an extension of Service bays 
 * @author jhnguye4
 *
 */
public class HybridElectricBay extends ServiceBay { 
	/**
	 * Creates a new empty bay for servicing hybrid/electric 
	 * vehicles according to the current bay numbering, then increments that number. The prefix is “E”.
	 */
	public HybridElectricBay() {
		super("E");
	}
	/**
	 * Occupies the service bay with the given vehicle. Throws a BayCarMismatchException if the vehicle is not a hybrid/electric car.
	 * @param v is the Vehicle that will occupy the service bay
	 * @throws BayOccupiedException if the bay is already occupied
	 * @throws BayCarMismatchException if the car is not a hybrid/electric car 
	 */
	public void occupy(Vehicle v) throws BayCarMismatchException, BayOccupiedException {
		if(super.isOccupied()) {
			throw new BayOccupiedException();
		}
		if(v.toString().charAt(0) != 'E') {
			throw new BayCarMismatchException();
		}
		super.occupy(v);
	}
}
