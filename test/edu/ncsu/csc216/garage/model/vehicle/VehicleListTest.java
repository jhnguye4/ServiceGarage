/**
 * 
 */
package edu.ncsu.csc216.garage.model.vehicle;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc216.garage.model.util.SimpleIterator;

/**
 * This class tests the VehicleList
 * @author jhnguye4
 *
 */
public class VehicleListTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.VehicleList#VehicleList(java.util.Scanner)}.
	 */
	@Test
	public void testVehicleListScanner() {
		Scanner line = new Scanner("R 0 NC-122 Doe, John ");
		
		VehicleList list = new VehicleList(line);
		assertEquals("Doe, John", list.get("d", 0).getName());
		assertEquals("NC-122", list.get("d", 0).getLicense());
		assertEquals(0, list.get("d", 0).getTier());
		assertEquals("R None      NC-122    Doe, John", list.get("d", 0).toString());
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.VehicleList#VehicleList(java.util.Scanner)}.
	 */
	@Test
	public void testVehicleListScannerLarge() {
		VehicleList list = null;
		File f = new File("test-files/cars.txt");
		try {
			list = new VehicleList(new Scanner(f));
		} catch (FileNotFoundException e) {
			System.err.println("VehicleList constructor: Starting with an empty file.");
		}
		int count = 0;
		try {
			SimpleIterator<Vehicle> i = list.iterator();
			while(i.hasNext()) {
				i.next();
				count++;
			}
		} catch(NoSuchElementException e) {
			System.out.print("null");
		}
		assertEquals(27, count);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.VehicleList#VehicleList()}.
	 */
	@Test
	public void testVehicleList() {
		VehicleList list = new VehicleList();
		try {
			Vehicle v = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			Vehicle v1 = new HybridElectricCar("def-456", "Lee, Joe", 3);
			Vehicle v2 = new HybridElectricCar("ghi-789", "Smith, Mike", 2);
			Vehicle v3 = new RegularCar("jkl-123", "Randle, Julius", 0);
			Vehicle v4 = new RegularCar("mno-123", "James, Lebron", 3);
			Vehicle v5 = new RegularCar("pqr-123", "James, Le", 3);
			list.add(v);
			list.add(v1);
			list.add(v2);
			list.add(v3);
			list.add(v4);
			list.add(v5);
			assertEquals("abc-123", list.get("Ng", 0).getLicense());
			assertEquals("James, Le", list.get("Jam", 1).getName());
			assertEquals("Lee, Joe", list.get("Lee", 0).getName());
			assertEquals("Smith, Mike", list.get("s", 0).getName());
			
			
		} catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.VehicleList#VehicleList()}.
	 */
	@Test
	public void testVehicleListRemoveLast() {
		VehicleList list = new VehicleList();
		try {
			Vehicle v = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			Vehicle v1 = new HybridElectricCar("def-456", "Lee, Joe", 3);
			Vehicle v2 = new HybridElectricCar("ghi-789", "Smith, Mike", 2);
			Vehicle v3 = new RegularCar("jkl-123", "Randle, Julius", 0);
			Vehicle v4 = new RegularCar("mno-123", "James, Lebron", 3);
			Vehicle v5 = new RegularCar("pqr-123", "James, Le", 3);
			list.add(v);
			list.add(v1);
			list.add(v2);
			list.add(v3);
			list.add(v4);
			list.add(v5);
			assertEquals("abc-123", list.get("Ng", 0).getLicense());
			assertEquals("James, Le", list.get("Jam", 1).getName());
			assertEquals("Lee, Joe", list.get("Lee", 0).getName());
			assertEquals("Smith, Mike", list.get("s", 0).getName());
			list.remove("ra", 0);
		} catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
	}


	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.VehicleList#remove(java.lang.String, int)}.
	 */
	@Test
	public void testRemove() {
		VehicleList list = new VehicleList();
		try {
			Vehicle v = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			Vehicle v1 = new HybridElectricCar("def-456", "Lee, Joe", 3);
			Vehicle v2 = new HybridElectricCar("ghi-789", "Smith, Mike", 2);
			Vehicle v3 = new RegularCar("jkl-123", "Randle, Julius", 0);
			Vehicle v4 = new RegularCar("mno-123", "James, Lebron", 3);
			Vehicle v5 = new RegularCar("pqr-123", "James, Le", 3);
			list.add(v);
			list.add(v1);
			list.add(v2);
			list.add(v3);
			list.add(v4);
			list.add(v5);
			assertEquals("abc-123", list.get("Ng", 0).getLicense());
			assertEquals("James, Le", list.get("Jam", 1).getName());
			assertEquals("Lee, Joe", list.get("Lee", 0).getName());
			assertEquals("Smith, Mike", list.get("s", 0).getName());
			
			list.remove("l", 0);
			assertNull(list.get("Lee", 0));
			list.remove("ja", 1);
		} catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.VehicleList#remove(java.lang.String, int)}.
	 */
	@Test
	public void testRemoveFirst() {
		VehicleList list = null;
		File f = new File("test-files/cars.txt");
		try {
			list = new VehicleList(new Scanner(f));
		} catch (FileNotFoundException e) {
			System.err.println("VehicleList constructor: Starting with an empty file.");
		}
		list.remove("Rhyne", 0);
		assertNull(list.get("Rhyne", 0));
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.VehicleList#remove(java.lang.String, int)}.
	 */
	@Test
	public void testRemoveMiddle() {
		VehicleList list = null;
		File f = new File("test-files/cars.txt");
		try {
			list = new VehicleList(new Scanner(f));
		} catch (FileNotFoundException e) {
			System.err.println("VehicleList constructor: Starting with an empty file.");
		}
		list.remove("Doe", 1);
		assertEquals("Doe, John", list.get("Doe", 0).getName());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.VehicleList#filteredList(java.lang.String)}.
	 */
	@Test
	public void testFilteredList() {
		VehicleList list = new VehicleList();
		try {
			Vehicle v = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			Vehicle v1 = new HybridElectricCar("def-456", "Lee, Joe", 3);
			Vehicle v2 = new HybridElectricCar("ghi-789", "Smith, Mike", 2);
			Vehicle v3 = new RegularCar("jkl-123", "Randle, Julius", 0);
			Vehicle v4 = new RegularCar("mno-123", "James, Lebron", 3);
			Vehicle v5 = new RegularCar("pqr-123", "James, Le", 2);
			Vehicle v6 = new RegularCar("stu-123", "James, Leb", 1);
			list.add(v);
			list.add(v1);
			list.add(v2);
			list.add(v3);
			list.add(v4);
			list.add(v5);
			list.add(v6);
			
			assertEquals("R Platinum  mno-123   James, Lebron\nR Gold      pqr-123   James, Le\nR Silver    stu-123   James, Leb\n", list.filteredList("ja"));
			
			
		} catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
	}
	
	/**
	 * Test method for iterator.
	 */
	@Test
	public void testIterator() {
		VehicleList list = new VehicleList();
		try {
			Vehicle v = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			Vehicle v1 = new HybridElectricCar("def-456", "Lee, Joe", 3);
			Vehicle v2 = new HybridElectricCar("ghi-789", "Smith, Mike", 2);
			Vehicle v3 = new RegularCar("jkl-123", "Randle, Julius", 0);
			Vehicle v4 = new RegularCar("mno-123", "James, Lebron", 3);
			Vehicle v5 = new RegularCar("pqr-123", "James, Le", 2);
			Vehicle v6 = new RegularCar("st-123", "James, Leb", 1);
			list.add(v);
			list.add(v1);
			list.add(v2);
			list.add(v3);
			list.add(v4);
			list.add(v5);
			list.add(v6);
			int count = 0;
			try {
				SimpleIterator<Vehicle> i = list.iterator();
				while(i.hasNext()) {
					count++;
					System.out.println(i.next());
				}
			} catch(NoSuchElementException e) {
				System.out.println("null");
			}
			assertEquals(7, count);
			
			
		} catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.VehicleList#remove(java.lang.String, int)}.
	 */
	@Test
	public void testRemoveEmpty() {
		VehicleList list = new VehicleList();
		try {
			Vehicle v = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			Vehicle v1 = new HybridElectricCar("def-456", "Lee, Joe", 3);
			Vehicle v2 = new HybridElectricCar("ghi-789", "Smith, Mike", 2);
			Vehicle v3 = new RegularCar("jkl-123", "Randle, Julius", 0);
			Vehicle v4 = new RegularCar("mno-123", "James, Lebron", 3);
			Vehicle v5 = new RegularCar("pqr-123", "James, Le", 3);
			list.add(v);
			list.add(v1);
			list.add(v2);
			list.add(v3);
			list.add(v4);
			list.add(v5);
			assertEquals("abc-123", list.get("Ng", 0).getLicense());
			assertEquals("James, Le", list.get("Jam", 1).getName());
			assertEquals("Lee, Joe", list.get("Lee", 0).getName());
			assertEquals("Smith, Mike", list.get("s", 0).getName());
			

			System.out.println();
			list.remove("", 3);
			assertNull(list.get("James", 2));
			
		} catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
	}


}
