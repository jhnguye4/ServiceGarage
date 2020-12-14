/**
 * 
 */
package edu.ncsu.csc216.garage.model.vehicle;

import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.garage.model.util.SimpleIterator;

/**
 * Maintains its vehicles in a linked list.
 * @author jhnguye4
 *
 */
public class VehicleList {
	/**private state for Node*/
	private Node head;
	/**
	 * Creates a list of vehicles from a Scanner. The Scanner would have been 
	 * initialized by the calling code as a Scanner on an input text file. 
	 * @param s is the Scanner on a input text file
	 */
	public VehicleList(Scanner s) {
		head = null;
		Vehicle v = null;
		try {
			
			while(s.hasNextLine()) {
				String line = s.nextLine();
				Scanner lineScan = new Scanner(line);
				while(lineScan.hasNext()) {
					try {
						String type = lineScan.next();
						String tier = lineScan.next();
						String license = lineScan.next().trim();
						String name = lineScan.nextLine().trim();
						if(type.toLowerCase().equals("e")) {
							try {
								v = new HybridElectricCar(license, name, Integer.parseInt(tier));
								this.add(v);
							} catch(BadVehicleInformationException e) {
								//do nothing
							}
						}
						if(type.toLowerCase().equals("r")) {
							try {
								v = new RegularCar(license, name, Integer.parseInt(tier));
								this.add(v);
							} catch(BadVehicleInformationException e) {
								//do nothing
							}
						}
					} catch(NoSuchElementException e) {
						break;
					}
					
				}
				lineScan.close();
			}
		} catch(NullPointerException e) {
			//This try block catches the null pointer and then does nothing
		}
	}
	
	/**
	 * Creates an empty list of vehicles.
	 */
	public VehicleList() {
		head = null;
	}

	/**
	 * Returns a SimpleIterator initialized to point to the first element in the list.
	 * @return SimpleIterator that points to the first element 
	 */
	public SimpleIterator<Vehicle> iterator() {
		return new Cursor();
	}
	
	/**
	 * Removes the vehicle that appears in the filtered list in the given position. 
	 * @param filter is the filter of the vehicle 
	 * @param index is the index of the vehicle
	 * @return Vehicle at the index
	 */
	public Vehicle remove(String filter, int index) {
		Node current = findTrailingNode(filter, index);
		Node previous = null;
		Vehicle v;
		if(current == null) {
			if(head.v.meetsFilter(filter)) {
				v = head.v;
				head = head.next;
				return v;
			} else {
				return null;
			}
		}
		v = current.next.v;
		if(current.next.next == null) {
			return null;
		}
		
		previous = current;
		previous.next = current.next.next;
		return v;
	}
	
	/**
	 * Gets the vehicle that appears in the filtered list in the given position. 
	 * @param filter is the filter of owners last name of the vehicle 
	 * @param index is the index of the vehicle
	 * @return Vehicle at the index
	 */
	public Vehicle get(String filter, int index) {
		Node current = findTrailingNode(filter, index);
		if(current == null) {
			if(head.v.meetsFilter(filter)) {
				return head.v;
			} else {
				return null;
			}
		}
		return current.next.v;
	}
	
	/**
	 * Adds the given vehicle to the list of those awaiting service.
	 * @param v is the Vehicle being added to the waiting list
	 */
	public void add(Vehicle v) {
		if (v == null) {
			throw new NullPointerException();
		}

		if(head == null) {
			head = new Node(v, null);
		}
		else if(v.compareToTier(head.v) > 0) {
			head = new Node(v, head);
		}
		else {
			Node previous = head;
			while(previous.next != null) {
				if(previous.next.v.compareToTier(v) >= 0) {
					previous = previous.next;
				} else {
					break;
				}
			}
			previous.next = new Node(v, previous.next);
		}

	}
	
	private Node findTrailingNode(String filter, int position) {
		if(head == null) {
			throw new NoSuchElementException();
		}
		Node current = head; 
		Node previous = null;
		int count = -1;
		while(current.next != null) {
			if(current.v.meetsFilter(filter)) {
				count++;
			}
			if(count == position) {
				break;
			}
			previous = current;
			current = current.next;
		}
		if(current.next == null && current.v.meetsFilter(filter)) {
			return previous;
		}
		if(count != position) {
			return null;
		}
		return previous;
	}
	/**
	 * String representation of all vehicles that meet the filter. Each substring corresponding to a vehicle is terminated by a newline. 
	 * @param filter Strings that will be filtered in list
	 * @return String representation of all vehicles
	 */
	public String filteredList(String filter) {
		Node current = head;
		String s = "";
		String newFilter = filter.trim();
		while(current != null) {
			if(current.v.meetsFilter(newFilter)) {
				s += current.v.toString() + "\n";
			}
			current = current.next;
		}
		return s;
	}
	
	/**
	 * This class is used in the linked list and is used to keep track of the next node and Vehicle object
	 */ 
	public class Node {
		/**private field Node that lets user know of the next object*/
		public Node next;
		/**private field for vehicle that will get the vehicle at the node*/
		public Vehicle v;
		/**
		 * Node constructor that creates a new vehicle for the next node
		 * @param v if the vehicle object being placed at the next node
		 * @param next the node next to the current one
		 */
		public Node(Vehicle v, Node next) {
			this.v = v;
			this.next = next;
		}
	}
	
	/**
	 * This class is used to iterate through the list 
	 * 
	 *
	 */
	public class Cursor implements SimpleIterator<Vehicle> { 
		/**private field for current node*/
		private Node cursor;
		/**private constructor that makes the cursor the head*/
		private Cursor() {
			cursor = head;
		}
		/**
		 * Does the iterator have more elements to traverse?
		 * @return true if the list iterator has more elements.
		 */
		@Override
		public boolean hasNext() {
			if(cursor == null) {
				return false;
			}
			return true;
		}
		/**
		 * This method gets the next element in the list and pushes the iterator down the list
		 * @return The next vehicle.
		 * @throws NoSuchElementException if there is no element
		 */
		@Override
		public Vehicle next() {
			if(cursor == null) {
				throw new NoSuchElementException();
			}
			Vehicle data = cursor.v;
			cursor = cursor.next;
			return data;
		}
	}
}