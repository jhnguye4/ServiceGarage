/**
 * 
 */
package edu.ncsu.csc216.garage.model.vehicle;

import edu.ncsu.csc216.garage.model.service_garage.BayCarMismatchException;
import edu.ncsu.csc216.garage.model.service_garage.BayOccupiedException;
import edu.ncsu.csc216.garage.model.service_garage.Garage;
import edu.ncsu.csc216.garage.model.service_garage.NoAvailableBayException;
import edu.ncsu.csc216.garage.model.service_garage.ServiceBay;

/**
 * Concrete class representing a vehicle that can be serviced in HybridElectricBays.
 * @author jhnguye4
 *
 */
public class HybridElectricCar extends Vehicle  { 

	/**
	 * Constructor for HybridElectricCar that will set the licenses, name, and tier of the vehicle 
	 * @param license is the license of vehicle
	 * @param name is the name of owner of vehicle
	 * @param tierIndex is the tier of the vehicle
	 * @throws BadVehicleInformationException is thrown if invalid information of the vehicle is submitted
	 */
	public HybridElectricCar(String license, String name, int tierIndex) throws BadVehicleInformationException {
		super(license, name, tierIndex);
	}

	/**
	 * Goes through the list of service bays, starting at the front, searching for an empty one.
	 * @param g is the garage that has the service bays 
	 * @throws NoAvailableBayException if no bays are open
	 */
	@Override
	public void pickServiceBay(Garage g) throws NoAvailableBayException{
		if(g.numberOfEmptyBays() == 0) {
			throw new NoAvailableBayException();
		}
		for(int i = g.getSize() - 1; i >= 0; i--) {
			ServiceBay bay = g.getBayAt(i);
			if(!bay.isOccupied()) {
				try {
					bay.occupy(this);
					return;
				} catch(BayOccupiedException | BayCarMismatchException e) {
					//This try block will not do anything
				}
			}
		}

	}
	
	/**
	 * String representation of the vehicle, prefixed by “E “.
	 * @return String representation of vehicle
	 */
	public String toString() {
		return "E " + super.toString();
	}

}
