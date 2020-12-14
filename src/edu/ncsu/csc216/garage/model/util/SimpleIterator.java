/**
 * 
 */
package edu.ncsu.csc216.garage.model.util;

import edu.ncsu.csc216.garage.model.vehicle.Vehicle;

/**
 * Interface describing behaviors of a generic type of iterator with two methods.
 * This is identical to the Java API Iterator except it does not declare a remove method.
 * @author jhnguye4
 * @param <E> is the object that iterator will go through
 *
 */
public interface SimpleIterator<E> {
	/**
	 * Does the iterator have more elements to traverse?
	 * @return true if the list iterator has more elements.
	 */
	boolean hasNext();
	
	/**
	 * This method gets the next element in the list and pushes the iterator down the list
	 * @return The next vehicle.
	 * 
	 */
	Vehicle next();
}
