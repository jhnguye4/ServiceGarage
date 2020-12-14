/**
 * 
 */
package edu.ncsu.csc216.garage.model.vehicle;



import edu.ncsu.csc216.garage.model.service_garage.Garage;
import edu.ncsu.csc216.garage.model.service_garage.NoAvailableBayException;

/**
 * Vehicle is an Abstract class that holds all the information for a vehicle.
 * Such as the name of owner, license and tier that it is under. 
 * @author jhnguye4
 *
 */
public abstract class Vehicle implements Tiered { 
	/**private field for license*/
	private String license;
	/**private field for name*/
	private String name;
	/**private field for tier*/
	private int tierIndex;
	/**private String array*/
	private static final String[] CUSTOMER_TIER = {"None", "Silver", "Gold", "Platinum"};
	/**Constant for max length of license string*/
	private static final int LICENSE_MAX = 8;
	/**Constant for max tier for vehicle*/
	private static final int TIER_MAX = 3;
	
	/**
	 * Constructor that creates a vehicle out of a license, owner name, and tier status.
	 * @param license is the license of vehicle
	 * @param name is the name of owner of vehicle
	 * @param tierIndex is the tier that the vehicle is under
	 * @throws BadVehicleInformationException if the license or owner are not valid.
	 */
	public Vehicle(String license, String name, int tierIndex) throws BadVehicleInformationException {
		setName(name);
		setLicense(license);
		setTier(tierIndex);
	}
	
	/**
	 *  Abstract. The vehicle picks a service bay in garage. 
	 * @param g is the Garage object
	 * @throws NoAvailableBayException if no available bays are open
	 */
	public abstract void pickServiceBay(Garage g) throws NoAvailableBayException;
	
	/**
	 * True if filter is a prefix to the owner’s last name. The check is case 
	 * insensitive. A filter of null or the null string (e.g., “”) would return true.
	 * @param filter is last name of owner
	 * @return True if filter of owner's last name
	 */
	public boolean meetsFilter(String filter) {
		
		if(filter == null || filter.equals("")) {
			return true;
		}
		String newFilter = filter.trim();
		if(name.toLowerCase().indexOf(newFilter.toLowerCase()) == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * String representation of the vehicle.
	 * @return String of vehicle
	 */
	public String toString() {
		return  String.format("%-10s%-10s%s", CUSTOMER_TIER[tierIndex], license, name);
	}
	
	/**
	 * Returns of owner of vehicle
	 * @return String of name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns license of vehicle
	 * @return String of license
	 */
	public String getLicense() {
		return license;
	}
	
	/**
	 * Gets the tier of the vehicle
	 * @return the tier of the Vehicle
	 */
	public int getTier() {
		return tierIndex;
	}
	
	/**
	 * Compare the tier status of this object with another. Returns 0 if the two match, a negative number if the tier status of this 
	 * object is less than the other’s, a positive number if the tier status of this object is greater. Required for ordering.
	 * @return 0 if the two match, a negative number if the tier status of this 
	 * object is less than the other’s, a positive number if the tier status of this object is greater.
	 * @param tier is the Tier that the object is going to be compared to
	 */
	public int compareToTier(Tiered tier) {
//		if(tierIndex == tier.getTier()) {
//			return 0;
//		}	
//		if(tierIndex > tier.getTier()) {
//			return 1;
//		}
//		return -1;
		return tierIndex - tier.getTier();
	}
	
	/**
	 * Setting the tier of a vehicle
	 * @param tier is the tier that the vehicle is set to
	 * @throws BadVehicleInformationException when a invalid tier is passed through
	 */
	public void setTier(int tier) throws BadVehicleInformationException {
		if(tier < 0 || tier > TIER_MAX) {
			throw new BadVehicleInformationException("Invalid tier.");
		}
		tierIndex = tier;
	}
	
	/**
	 * Sets name of owner of vehicle
	 * @param name of owner of vehicle
	 * @throws BadVehicleInformationException 
	 */
	private void setName(String name) throws BadVehicleInformationException {
		if(name == null) {
			throw new BadVehicleInformationException("Owner name cannot be blank.");
		}
		String newName = name.trim();
		if(newName == null || newName.equals("")) {
			throw new BadVehicleInformationException("Owner name cannot be blank.");
		}
		this.name = newName;
		
	}
	
	/**
	 * Sets license of vehicle
	 * @param license that is set for vehicle
	 * @throws BadVehicleInformationException 
	 */
	private void setLicense(String license) throws BadVehicleInformationException {
		int length = 0;
		if(license == null || license.equals("")) {
			throw new BadVehicleInformationException("License cannot be blank.");
		}
		String newLicense = license.trim();
		if(newLicense.contains(" ") || newLicense.equals("")) {
			throw new BadVehicleInformationException("License cannot be blank.");
		}
		for(int i = 0; i < newLicense.length(); i++) {
			length++; 
		}
		if(length > LICENSE_MAX) {
			throw  new BadVehicleInformationException();
		}
		this.license = newLicense;
	}
}
