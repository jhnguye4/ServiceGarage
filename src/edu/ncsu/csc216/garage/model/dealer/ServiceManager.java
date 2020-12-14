/**
 * 
 */
package edu.ncsu.csc216.garage.model.dealer;

import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.garage.model.service_garage.Garage;
import edu.ncsu.csc216.garage.model.service_garage.NoAvailableBayException;
import edu.ncsu.csc216.garage.model.util.SimpleIterator;
import edu.ncsu.csc216.garage.model.vehicle.BadVehicleInformationException;
import edu.ncsu.csc216.garage.model.vehicle.HybridElectricCar;
import edu.ncsu.csc216.garage.model.vehicle.RegularCar;
import edu.ncsu.csc216.garage.model.vehicle.Tiered;
import edu.ncsu.csc216.garage.model.vehicle.Vehicle;
import edu.ncsu.csc216.garage.model.vehicle.VehicleList;


/**
 * This class implements Manageable and contains both Garage and Vehicle class
 * @author jhnguye4
 *
 */
public class ServiceManager implements Manageable { 
	/**private state for the Garage object*/
	private Garage myGarage;
	/**private state for VehicleList*/
	private VehicleList waitingCars;

	/**
	 * Constructor for ServiceManager that has no parameters.
	 * Creates a service manager with no vehicles awaiting service.
	 */
	public ServiceManager() {
		waitingCars = new VehicleList();
		myGarage = new Garage();
	}
	/**
	 * Constructor for ServiceManager that has one parameter that is a Scanner.
	 * Initializes the list of vehicles awaiting service with data from the Scanner.
	 * @param s is the Scanner parameter that places data into list 
	 */
	public ServiceManager(Scanner s) {
		waitingCars = new VehicleList(s);
		myGarage = new Garage();
	}
	
	/**
	 * Puts an item in the service wait list.
	 * @param t  Type of item
	 * @param b  Item data (such as license)
	 * @param c  Item data (such as owner name)
	 * @param x  Item tier
	 */
	@Override
	public void putOnWaitingList(String t, String b, String c, int x) {
		Vehicle v;
		if(t.equals("RegularCar")) {
			try {
				v = new RegularCar(b, c, x);
				waitingCars.add(v);
			} catch(BadVehicleInformationException e) { 
				//do nothing
			}
		} 
		if(t.equals("HybridElectricCar")) {
			try {
				v = new HybridElectricCar(b, c, x);
				waitingCars.add(v);
			} catch(BadVehicleInformationException e) { 
				//do nothing
			}
		}
		
		
	}

	/**
	 * Puts an item in the list of those awaiting service.
	 * @param v  The item to put on waiting list
	 */
	@Override
	public void putOnWaitingList(Tiered v) {
		waitingCars.add((Vehicle) v);
	}

	/**
	 * Returns the Tiered item meeting the given filter and position from the list of items awaiting service.
	 * @param filter Filters the list of items considered
	 * @param position Position in the filtered list of items
	 * @return The item at the position in the list that meets the given filter
	 */
	@Override
	public Tiered getWaitingItem(String filter, int position) {
		try {
			waitingCars.get(filter, position);
		} catch(NoSuchElementException e) {
			return null;
		}
		return waitingCars.get(filter, position);
	}

	/**
	 * Removes an item meeting the given filter from the list of items awaiting service.
	 * @param filter  Filters the list of items considered for removal
	 * @param position  Position in the filtered list of the item to be removed
	 * @return  The item that was removed, or null if nothing was removed
	 */
	@Override
	public Tiered remove(String filter, int position) {
		return waitingCars.remove(filter, position);
	}

	/**
	 * Fills the service bays with items awaiting service.
	 */
	@Override
	public void fillServiceBays() {
		SimpleIterator<Vehicle> i = waitingCars.iterator();
		while(myGarage.numberOfEmptyBays() != 0 && i.hasNext()) {
			Vehicle vehicle = null;
			vehicle = i.next();
				try {
					
					vehicle.pickServiceBay(myGarage);
					waitingCars.remove(vehicle.getName(), 0);
				} catch(NoAvailableBayException e){
					//do nothing
				}
		}
		
	}
	/**
	 * Releases the item from the given service bay.
	 * @param bay  Location of the bay where the item is being serviced
	 * @return  Item that was released from service, or null if the bay was empty
	 */
	@Override
	public Tiered releaseFromService(int bay) {
		return myGarage.release(bay);
	}

	/**
	 * Adds a new service bay to the service area.
	 */
	@Override
	public void addNewBay() {
		myGarage.addRepairBay();
		
	}

	/**
	 * A string representation of the list of items awaiting service that meet 
	 *    the given filter.
	 * @param filter  Determines which items are are of interest
	 * @return String  String representation of the filtered list
	 */
	@Override
	public String printWaitList(String filter) {
		return waitingCars.filteredList(filter);
	}

	/**
	 * A string representation of the list of bays in the service area.
	 * @return  String representation of the service area 
	 */
	@Override
	public String printServiceBays() {
		String s = "";
		for(int i = 0; i < myGarage.getSize(); i++) {
			//ServiceBay bay = myGarage.getBayAt(i);
			s += myGarage.getBayAt(i).toString() + "\n";
		}
		return s;
	}

}
