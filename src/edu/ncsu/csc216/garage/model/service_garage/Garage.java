/**
 * 
 */
package edu.ncsu.csc216.garage.model.service_garage;

import edu.ncsu.csc216.garage.model.vehicle.Vehicle;

/**
 * This class holds all the functionalities of the Garage such as adding a bay in the garage 
 * or releasing a vehicle from the bay.
 * @author jhnguye4
 *
 */
public class Garage {
	/** private constant for max bays*/
	private static final int MAX_BAYS = 30;
	/** private constant for default size*/
	private static final int DEFAULT_SIZE = 8;
	/**private field for size of garage*/
	private int size;
	/**private state for ServiceBay*/
	private ServiceBay[] bay;
	
	/**
	 * Constructor for the Garage class that has no parameters.
	 * Creates a list of 8 empty service bays.
	 */
	public Garage() {
		ServiceBay.startBayNumberingAt101();
		bay = new ServiceBay[MAX_BAYS];
		initBays(DEFAULT_SIZE);
	}
	
	/**
	 * Private method that is used to set the initial bays
	 * @param bays is the number of bays that will be initialized
	 */
	private void initBays(int bays) {
	    for (int k = 0; k < bays; k++) {
		     addRepairBay();
		}
	}
	
	/**
	 * Adds a repair bay. At least 1/3 of the bays in the garage are dedicated to hybrid/electric vehicles.
	 */
	public void addRepairBay()  {
		
		if(bay == null) {
			throw new NullPointerException();
		}
		if(size == MAX_BAYS) {
			throw new IllegalArgumentException();
		}
//		if(size == 0) {
//			bay[size] = new HybridElectricBay();
//		}
		
		if((size + 1) % 3 == 1) {
			bay[size] = new HybridElectricBay();
		} else {
			for(int i = size; i > 0; i--) {
				bay[i] = bay[i - 1];
			}
			bay[0] = new ServiceBay();
		}
		size++;
		
	}
	
	/**
	 * Number of open service bays that are currently empty.
	 * @return number of empty bays
	 */
	public int numberOfEmptyBays() {
		int count = 0;
		for(int i = 0; i < getSize(); i++) {
			if(bay[i].isOccupied()) {
				count++;
			}
		}
		return getSize() - count;
	}
	
	/**
	 * Service bay at the given index.
	 * @param index of the service bay user wants to get
	 * @return ServiceBay object
	 */
	public ServiceBay getBayAt(int index) {
		if(index < 0 || index > getSize()) {
			throw new IndexOutOfBoundsException();
		}
		return bay[index];
	}
	
	/**
	 * Total number of open service bays. 
	 * @return number of service bays open
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Removes the vehicle currently in the service bay and returns it.
	 * @param index of the service bay that will release vehicle
	 * @return Vehicle object
	 */
	public Vehicle release(int index) {
		if(size == 0) {
			throw new IndexOutOfBoundsException();
		}
		if(index < 0 || index >= size ) {
			return null;
		}
		ServiceBay e = bay[index];
		return e.release();
	}
}
