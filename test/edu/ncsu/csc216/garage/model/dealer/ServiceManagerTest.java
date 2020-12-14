/**
 * 
 */
package edu.ncsu.csc216.garage.model.dealer;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc216.garage.model.service_garage.ServiceBay;
import edu.ncsu.csc216.garage.model.vehicle.BadVehicleInformationException;
import edu.ncsu.csc216.garage.model.vehicle.HybridElectricCar;

import edu.ncsu.csc216.garage.model.vehicle.Vehicle;

/**
 * Tests the ServiceManager class
 * @author jhnguye4
 *
 */
public class ServiceManagerTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.dealer.ServiceManager#ServiceManager()}.
	 */
	@Test
	public void testServiceManager() {
		ServiceBay.startBayNumberingAt101();
		ServiceManager serviceMgr = new ServiceManager();
		assertEquals("", serviceMgr.printWaitList(""));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.dealer.ServiceManager#ServiceManager(java.util.Scanner)}.
	 */
	@Test
	public void testServiceManagerScanner() {
		ServiceBay.startBayNumberingAt101();
		ServiceManager serviceMgr = null;
		File f = new File("test-files/cars.txt");
		try {
			serviceMgr = new ServiceManager(new Scanner(f));
		} catch (FileNotFoundException e) {
			System.err.println("VehicleList constructor: Starting with an empty file.");
		}
		assertEquals("HI-01345", ((Vehicle) serviceMgr.getWaitingItem("Rhyne", 0)).getLicense());
		System.out.println(serviceMgr.printWaitList(""));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.dealer.ServiceManager#putOnWaitingList(java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testPutOnWaitingListStringStringStringInt() {
		ServiceBay.startBayNumberingAt101();
		ServiceManager serviceMgr = new ServiceManager();
		serviceMgr.putOnWaitingList("RegularCar", "abc-123", "Nguyen, Jonathan", 3);
		assertEquals("R Platinum  abc-123   Nguyen, Jonathan\n", serviceMgr.printWaitList(""));
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.dealer.ServiceManager#putOnWaitingList(edu.ncsu.csc216.garage.model.vehicle.Tiered)}.
	 */
	@Test
	public void testPutOnWaitingListTiered() {
		ServiceBay.startBayNumberingAt101();
		ServiceManager serviceMgr = new ServiceManager();
		serviceMgr.putOnWaitingList("H", "abc-123", "Nguyen, Jonathan", 3);
		serviceMgr.putOnWaitingList("RegularCar", "abc-123", "Nguyen, Jonathan", -1);
		Vehicle v = null;
		try {
			v = new HybridElectricCar("def-456", "James, Lebron", 2);
			serviceMgr.putOnWaitingList(v);
		} catch(BadVehicleInformationException e) {
			System.out.println("Invalid Vehicle");
		}
		
		
		assertEquals("E Gold      def-456   James, Lebron\n", serviceMgr.printWaitList(""));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.dealer.ServiceManager#getWaitingItem(java.lang.String, int)}.
	 */
	@Test
	public void testGetWaitingItem() {
		ServiceBay.startBayNumberingAt101();
		ServiceManager serviceMgr = new ServiceManager();

		
		
		serviceMgr.putOnWaitingList("RegularCar", "abc-123", "Nguyen, Jonathan", 3);
		serviceMgr.putOnWaitingList("HybridElectricCar", "ghi-123", "Smith, John", 2);
		assertEquals("R Platinum  abc-123   Nguyen, Jonathan\nE Gold      ghi-123   Smith, John\n", serviceMgr.printWaitList(""));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.dealer.ServiceManager#remove(java.lang.String, int)}.
	 */
	@Test
	public void testRemove() {
		Vehicle v = null;
		ServiceBay.startBayNumberingAt101();
		ServiceManager serviceMgr = new ServiceManager();
		try {
			v = new HybridElectricCar("def-456", "James, Lebron", 1);
			serviceMgr.putOnWaitingList(v);
		} catch(BadVehicleInformationException e) {
			System.out.println("Invalid Vehicle");
		}
		
		
		serviceMgr.putOnWaitingList("RegularCar", "abc-123", "Nguyen, Jonathan", 3);
		serviceMgr.putOnWaitingList("HybridElectricCar", "ghi-123", "Smith, John", 2);
		assertEquals("R Platinum  abc-123   Nguyen, Jonathan\nE Gold      ghi-123   Smith, John\n"
				+ "E Silver    def-456   James, Lebron\n", serviceMgr.printWaitList(""));
		serviceMgr.remove("j", 0);
		System.out.println(serviceMgr.printWaitList(""));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.dealer.ServiceManager#fillServiceBays()}.
	 */
	@Test
	public void testFillServiceBays() {
		ServiceBay.startBayNumberingAt101();
		ServiceManager serviceMgr = null;
		File f = new File("test-files/cars.txt");
		try {
			serviceMgr = new ServiceManager(new Scanner(f));
		} catch (FileNotFoundException e) {
			System.err.println("VehicleList constructor: Starting with an empty file.");
		}
		System.out.print(serviceMgr.printWaitList(""));
		serviceMgr.fillServiceBays();
		assertEquals("NC-1233", ((Vehicle)serviceMgr.getWaitingItem("Doe", 1)).getLicense());
		assertNull((Vehicle)serviceMgr.getWaitingItem("Rhyne", 0));
		System.out.println();
		System.out.println(serviceMgr.printServiceBays());
		System.out.print(serviceMgr.printWaitList(""));
	
	}

//	/**
//	 * Test method for {@link edu.ncsu.csc216.garage.model.dealer.ServiceManager#releaseFromService(int)}.
//	 */
//	@Test
//	public void testReleaseFromService() {
//
//	}

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.dealer.ServiceManager#addNewBay()}.
	 */
	@Test
	public void testAddNewBay() {
		ServiceBay.startBayNumberingAt101();
		ServiceManager serviceMgr = new ServiceManager();
		serviceMgr.putOnWaitingList("RegularCar", "abc-123", "Nguyen, Jonathan", 3);
		serviceMgr.putOnWaitingList("HybridElectricCar", "ghi-123", "Smith, John", 2);
		serviceMgr.putOnWaitingList("RegularCar", "def-123", "Williams, Bob", 1);
		serviceMgr.putOnWaitingList("HybridElectricCar", "jkl-123", "Le, Henry", 0);
		//serviceMgr.fillServiceBays();
		assertEquals("108: EMPTY\n106: EMPTY\n105: EMPTY\n103: EMPTY\n102: EMPTY\nE01: EMPTY\nE04: EMPTY\nE07: EMPTY\n", serviceMgr.printServiceBays());
		serviceMgr.addNewBay();
		assertEquals("109: EMPTY\n108: EMPTY\n106: EMPTY\n105: EMPTY\n103: EMPTY\n102: EMPTY\nE01: EMPTY\nE04: EMPTY\nE07: EMPTY\n", serviceMgr.printServiceBays());
	}

}
