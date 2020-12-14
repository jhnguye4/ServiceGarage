/**
 * 
 */
package edu.ncsu.csc216.garage.model.service_garage;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.garage.model.vehicle.BadVehicleInformationException;
import edu.ncsu.csc216.garage.model.vehicle.HybridElectricCar;
import edu.ncsu.csc216.garage.model.vehicle.RegularCar;
import edu.ncsu.csc216.garage.model.vehicle.Vehicle;

/**
 * Tests the Garage class
 * @author jhnguye4
 *
 */
public class GarageTest {


	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.service_garage.Garage#Garage()}.
	 */
	@Test
	public void testGarage() {
		ServiceBay.startBayNumberingAt101();
		Garage g = new Garage();
		assertEquals(8, g.getSize());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.service_garage.Garage#addRepairBay()}.
	 */
	@Test
	public void testAddRepairBay() {
		int count = 0;
		ServiceBay.startBayNumberingAt101();
		Garage g = new Garage();
		g.addRepairBay();
		g.addRepairBay();
		assertEquals(10, g.getSize());
		for(int i = 0; i < g.getSize(); i++) {
			if(g.getBayAt(i) instanceof HybridElectricBay) {
				count++;
			}
		}
		assertEquals(4, count);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.service_garage.Garage#numberOfEmptyBays()}.
	 */
	@Test
	public void testNumberOfEmptyBays() {
		try {
			Vehicle v = new HybridElectricCar("abc-123", "Nguyen, Jonathan", 1);
			Vehicle v1 = new HybridElectricCar("def-456", "Smith, John", 2);
			ServiceBay.startBayNumberingAt101();
			Garage g = new Garage();
			try {
				g.getBayAt(0).occupy(v);
				g.getBayAt(1).occupy(v1);
				assertTrue(g.getBayAt(0).isOccupied());
				assertTrue(g.getBayAt(1).isOccupied());
				assertFalse(g.getBayAt(2).isOccupied());
				assertEquals(6 , g.numberOfEmptyBays());
			} catch(BayOccupiedException | BayCarMismatchException e) {
				System.out.println("Bay Occupied.");
			}
		} catch(BadVehicleInformationException e){
			System.out.println("Invalid Vehicle.");
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.service_garage.Garage#release(int)}.
	 */
	@Test
	public void testRelease() {
		try {
			Vehicle v = new HybridElectricCar("abc-123", "Nguyen, Jonathan", 1);
			Vehicle v1 = new HybridElectricCar("def-456", "Smith, John", 2);
			ServiceBay.startBayNumberingAt101();
			Garage g = new Garage();
			try {
				g.getBayAt(0).occupy(v);
				g.getBayAt(1).occupy(v1);
				assertTrue(g.getBayAt(0).isOccupied());
				assertTrue(g.getBayAt(1).isOccupied());
				assertFalse(g.getBayAt(2).isOccupied());
				g.getBayAt(1).release();
				assertFalse(g.getBayAt(1).isOccupied());
			} catch(BayOccupiedException | BayCarMismatchException e) {
				System.out.println("Bay Occupied.");
			}
		} catch(BadVehicleInformationException e){
			System.out.println("Invalid Vehicle.");
		}

	}
	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.service_garage.Garage#release(int)}.
	 */
	@Test
	public void testInvalid() {
		ServiceBay.startBayNumberingAt101();
		Garage g = new Garage();
		try {
			g.getBayAt(10);
			fail();
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Bay Occupied.");
		}
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.service_garage.Garage#release(int)}.
	 */
	@Test
	public void testRelease2() {
		try {
			Vehicle v = new HybridElectricCar("abc-123", "Nguyen, Jonathan", 1);
			Vehicle v1 = new RegularCar("def-456", "Smith, John", 2);
			Vehicle v2 = new RegularCar("ghi-678", "Lee, Mike", 3);
			ServiceBay.startBayNumberingAt101();
			Garage g = new Garage();
			try {
				g.getBayAt(0).occupy(v);
				g.getBayAt(1).occupy(v1);
				g.getBayAt(2).occupy(v2);
				assertEquals("106", g.getBayAt(1).getBayID());
				assertTrue(g.getBayAt(0).isOccupied());
				assertTrue(g.getBayAt(1).isOccupied());
				assertTrue(g.getBayAt(2).isOccupied());
				assertEquals("108", g.getBayAt(0).getBayID());
				assertEquals("106", g.getBayAt(1).getBayID());
				assertEquals("105", g.getBayAt(2).getBayID());
				assertEquals("108: abc-123  Nguyen, Jonathan", g.getBayAt(0).toString());
				assertFalse(g.getBayAt(3).isOccupied());
				g.release(1);
				assertFalse(g.getBayAt(1).isOccupied());
			} catch(BayOccupiedException | BayCarMismatchException e) {
				System.out.println("Bay Occupied.");
			}
		} catch(BadVehicleInformationException e){
			System.out.println("Invalid Vehicle.");
		}
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.service_garage.Garage#release(int)}.
	 */
	@Test
	public void testOccupied() {
		try {
			Vehicle v = new HybridElectricCar("abc-123", "Nguyen, Jonathan", 1);
			Vehicle v1 = new HybridElectricCar("def-456", "Smith, John", 2);
			ServiceBay.startBayNumberingAt101();
			Garage g = new Garage();
			try {
				g.getBayAt(0).occupy(v);
				
				assertEquals("108", g.getBayAt(0).getBayID());
				assertTrue(g.getBayAt(0).isOccupied());
				g.getBayAt(0).occupy(v1);
				fail();
			} catch(BayOccupiedException | BayCarMismatchException e) {
				System.out.println("Bay Occupied.");
			}
		} catch(BadVehicleInformationException e){
			System.out.println("Invalid Vehicle.");
		}
	}
	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.service_garage.Garage#release(int)}.
	 */
	@Test
	public void testRegCarInHybridBay() {
		try {
			Vehicle v = new RegularCar("abc-123", "Nguyen, Jonathan", 1);
			ServiceBay.startBayNumberingAt101();
			Garage g = new Garage();
			try {
				g.getBayAt(7).occupy(v);
				fail();
			} catch(BayOccupiedException | BayCarMismatchException e) {
				System.out.println("Bay Occupied.");
			}
		} catch(BadVehicleInformationException e){
			System.out.println("Invalid Vehicle.");
		}
	}
	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.service_garage.Garage#release(int)}.
	 */
	@Test
	public void testGetNumberOfEmptyBays() {
		try {
			Vehicle v = new RegularCar("abc-123", "Nguyen, Jonathan", 1);
			ServiceBay.startBayNumberingAt101();
			Garage g = new Garage();
			try {
				g.getBayAt(7).occupy(v);
				fail();
			} catch(BayOccupiedException | BayCarMismatchException e) {
				System.out.println("Bay Occupied.");
			}
		} catch(BadVehicleInformationException e){
			System.out.println("Invalid Vehicle.");
		}
	}
	

}
