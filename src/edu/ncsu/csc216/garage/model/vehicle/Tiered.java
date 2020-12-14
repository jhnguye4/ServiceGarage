package edu.ncsu.csc216.garage.model.vehicle;

/**
 * Interface that describes behaviors of objects that can be ordered by tiers (0, 1, 2 and so on, with higher tiers having higher numbers).
 * @author jhnguye4
 *
 */
public interface Tiered {
	/**
	 * Gets the tier of the vehicle
	 * @return the tier of the Vehicle
	 */
	int getTier();
	
	/**
	 * Compare the tier status of this object with another. Returns 0 if the two match, a negative number if the tier status of this 
	 * object is less than the other’s, a positive number if the tier status of this object is greater. Required for ordering.
	 * @param t is the tier that it is being compared to
	 * @return 0 if the two match, a negative number if the tier status of this 
	 * object is less than the other’s, a positive number if the tier status of this object is greater.
	 */
	int compareToTier(Tiered t);
}
