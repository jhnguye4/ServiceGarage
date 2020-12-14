/**
 * 
 */
package edu.ncsu.csc216.garage.model.vehicle;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.garage.model.service_garage.Garage;
import edu.ncsu.csc216.garage.model.service_garage.NoAvailableBayException;
import edu.ncsu.csc216.garage.model.service_garage.ServiceBay;


/**
 * This class is used to test Vehicle
 * @author jhnguye4
 *
 */
public class VehicleTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.Vehicle#Vehicle(java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testVehicle() {
		try {
			Vehicle v = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			assertEquals("abc-123", v.getLicense());
			assertEquals("Nguyen, Jonathan", v.getName());
			assertEquals(0, v.getTier());
			assertEquals("R None      abc-123   Nguyen, Jonathan", v.toString());
		}
		catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
		
		try {
			Vehicle v1 = new HybridElectricCar("def-456", "Lee, Joe", 3);
			assertEquals("def-456", v1.getLicense());
			assertEquals("Lee, Joe", v1.getName());
			assertEquals(3, v1.getTier());
			assertEquals("E Platinum  def-456   Lee, Joe", v1.toString());
		}
		catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
		
	}
	
	/**
	 * Test method for invalid vehicles.
	 */
	@Test
	public void testVehicleInvalid() {
		try {
			new RegularCar("", "Nguyen, Jonathan", 0);
			fail();
		}
		catch(BadVehicleInformationException e) {
			System.out.println("invalid license");
		}
		
		try {
			new HybridElectricCar("def-456", "", 3);
			fail();
		}
		catch(BadVehicleInformationException e) {
			System.out.println("invalid name");
		}
		
		try {
			new RegularCar(null, "Nguyen, Jonathan", 0);
			fail();
		} catch(BadVehicleInformationException e) {
			System.out.println("invalid license");
		}
		
		try {
			new RegularCar(null, "Nguyen, Jonathan", 0);
			fail();
		} catch(BadVehicleInformationException e) {
			System.out.println("invalid license");
		}
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.Vehicle#pickServiceBay(edu.ncsu.csc216.garage.model.service_garage.Garage)}.
	 */
	@Test
	public void testPickServiceBay() {
		ServiceBay.startBayNumberingAt101();
		Garage g = new Garage();
		try {
			Vehicle v1 = new HybridElectricCar("def-456", "Lee, Joe", 3);
			Vehicle v2 = new HybridElectricCar("ghi-789", "Smith, Mike", 2);
			Vehicle v3 = new RegularCar("jkl-123", "Randle, Julius", 0);
			Vehicle v4 = new RegularCar("mno-123", "James, Lebron", 3);
			Vehicle v5 = new RegularCar("pqr-123", "James, Le", 3);
			Vehicle v6 = new HybridElectricCar("abc-123", "Nguyen, Jonathan", 0);
			Vehicle v7 = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			Vehicle v8 = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			Vehicle v9 = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			try {
				assertFalse(g.getBayAt(0).isOccupied());
				v1.pickServiceBay(g);
				v2.pickServiceBay(g);
				v3.pickServiceBay(g);
				v4.pickServiceBay(g);
				v5.pickServiceBay(g);
				v6.pickServiceBay(g);
				v7.pickServiceBay(g);
				v8.pickServiceBay(g);
				v9.pickServiceBay(g);
				fail();
			} catch(NoAvailableBayException e) {
				System.out.println("No Bays Open");
			}
			
		} catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
	}
	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.Vehicle#pickServiceBay(edu.ncsu.csc216.garage.model.service_garage.Garage)}.
	 */
	@Test
	public void testPickServiceBayInvalid() {
		ServiceBay.startBayNumberingAt101();
		Garage g = new Garage();
		try {
			Vehicle v1 = new RegularCar("def-456", "Lee, Joe", 3);
			Vehicle v2 = new RegularCar("ghi-789", "Smith, Mike", 2);
			Vehicle v3 = new RegularCar("jkl-123", "Randle, Julius", 0);
			Vehicle v4 = new RegularCar("mno-123", "James, Lebron", 3);
			Vehicle v5 = new RegularCar("pqr-123", "James, Le", 3);
			Vehicle v6 = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			try {
				v1.pickServiceBay(g);
				v2.pickServiceBay(g);
				v3.pickServiceBay(g);
				v4.pickServiceBay(g);
				v5.pickServiceBay(g);
				v6.pickServiceBay(g);
				fail();
			} catch(NoAvailableBayException | IllegalArgumentException e) {
				System.out.println("No Bays Open");
			}
			
		} catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.Vehicle#pickServiceBay(edu.ncsu.csc216.garage.model.service_garage.Garage)}.
	 */
	@Test
	public void testPickServiceBayAllHybrid() {
		ServiceBay.startBayNumberingAt101();
		Garage g = new Garage();
		try {
			Vehicle v1 = new HybridElectricCar("def-456", "Lee, Joe", 3);
			Vehicle v2 = new HybridElectricCar("ghi-789", "Smith, Mike", 2);
			Vehicle v3 = new HybridElectricCar("jkl-123", "Randle, Julius", 0);
			Vehicle v4 = new HybridElectricCar("mno-123", "James, Lebron", 3);
			Vehicle v5 = new HybridElectricCar("pqr-123", "James, Le", 3);
			Vehicle v6 = new HybridElectricCar("abc-123", "Nguyen, Jonathan", 0);
			Vehicle v7 = new HybridElectricCar("abc-123", "Nguyen, Jonathan", 0);
			Vehicle v8 = new HybridElectricCar("abc-123", "Nguyen, Jonathan", 0);
			Vehicle v9 = new HybridElectricCar("abc-123", "Nguye, Jonathan", 0);
			try {
				assertFalse(g.getBayAt(0).isOccupied());
				v1.pickServiceBay(g);
				v2.pickServiceBay(g);
				v3.pickServiceBay(g);
				v4.pickServiceBay(g);
				v5.pickServiceBay(g);
				v6.pickServiceBay(g);
				v7.pickServiceBay(g);
				v8.pickServiceBay(g);
				v9.pickServiceBay(g);
			} catch(NoAvailableBayException e) {
				System.out.println("No Bays Open");
			}
			
		} catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.Vehicle#meetsFilter(java.lang.String)}.
	 */
	@Test
	public void testMeetsFilter() {
		try {
			Vehicle v = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			assertEquals("abc-123", v.getLicense());
			assertEquals("Nguyen, Jonathan", v.getName());
			assertEquals(0, v.getTier());
			assertEquals("R None      abc-123   Nguyen, Jonathan", v.toString());
			Vehicle v1 = new HybridElectricCar("def-456", "Lee, Joe", 3);
			assertEquals("def-456", v1.getLicense());
			assertEquals("Lee, Joe", v1.getName());
			assertEquals(3, v1.getTier());
			assertEquals("E Platinum  def-456   Lee, Joe", v1.toString());
			assertTrue(v.meetsFilter("Nguyen"));
			assertTrue(v.meetsFilter(""));
			assertFalse(v.meetsFilter("Nguyen, Jonathon"));
		}
		catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
		
	}


	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.Vehicle#compareToTier(edu.ncsu.csc216.garage.model.vehicle.Tiered)}.
	 */
	@Test
	public void testCompareToTier() {
		try {
			Vehicle v = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			assertEquals("abc-123", v.getLicense());
			assertEquals("Nguyen, Jonathan", v.getName());
			assertEquals(0, v.getTier());
			assertEquals("R None      abc-123   Nguyen, Jonathan", v.toString());
			v.setTier(3);
			assertEquals(3, v.getTier());
			assertEquals("R Platinum  abc-123   Nguyen, Jonathan", v.toString());
			
		}
		catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.Vehicle#setTier(int)}.
	 */
	@Test
	public void testSetTier() {
		try {
			Vehicle v = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			assertEquals("abc-123", v.getLicense());
			assertEquals("Nguyen, Jonathan", v.getName());
			assertEquals(0, v.getTier());
			assertEquals("R None      abc-123   Nguyen, Jonathan", v.toString());
			v.setTier(3);
			assertEquals(3, v.getTier());
			assertEquals("R Platinum  abc-123   Nguyen, Jonathan", v.toString());
		}
		catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
		
		try {
			Vehicle v = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			assertEquals("abc-123", v.getLicense());
			assertEquals("Nguyen, Jonathan", v.getName());
			assertEquals(0, v.getTier());
			assertEquals("R None      abc-123   Nguyen, Jonathan", v.toString());
			v.setTier(-1);
			fail();
		}
		catch(BadVehicleInformationException e) {
			System.out.println("invalid tier");
		}
		
		try {
			Vehicle v = new RegularCar("abc-123", "Nguyen, Jonathan", 0);
			assertEquals("abc-123", v.getLicense());
			assertEquals("Nguyen, Jonathan", v.getName());
			assertEquals(0, v.getTier());
			assertEquals("R None      abc-123   Nguyen, Jonathan", v.toString());
			v.setTier(4);
			fail();
		}
		catch(BadVehicleInformationException e) {
			System.out.println("invalid tier");
		}
	}
	/**Testing " NC0 ", "Owner  ", 3*/
	@Test
	public void testValidName() {
		Vehicle v = null;
		try {
			v = new HybridElectricCar(" NC0 ", "Owner  ", 3);
			assertEquals("NC0", v.getLicense());
			assertEquals("Owner", v.getName());
			assertEquals(3, v.getTier());
			assertEquals("E Platinum  NC0       Owner", v.toString());
		}
		catch(BadVehicleInformationException e) {
			System.out.println("invalid tier");
		}
	}
	
	/**Testing TS_meetFilter ("MA-1", "My Jeep", 1)*/
	@Test
	public void testTSMeetFilter() {
		Vehicle v = null;
		try {
			v = new RegularCar("MA-1", "My Jeep", 1);
			assertTrue(v.meetsFilter("my j"));
			assertEquals("MA-1", v.getLicense());
			assertEquals("My Jeep", v.getName());
			assertEquals(1, v.getTier());
			assertEquals("R Silver    MA-1      My Jeep", v.toString());
		}
		catch(BadVehicleInformationException e) {
			System.out.println("invalid tier");
		}
	}

	/**
	 * Test method for car 7 picks serviceBay 0.
	 */
	@Test
	public void testPickServiceBay1() {
		ServiceBay.startBayNumberingAt101();
		Garage g = new Garage();
		try {
			Vehicle v1 = new HybridElectricCar("def-456", "Lee, Joe", 3);
			Vehicle v2 = new HybridElectricCar("ghi-789", "Smith, Mike", 3);
			Vehicle v3 = new HybridElectricCar("jkl-123", "Randle, Julius", 3);
			Vehicle v4 = new RegularCar("mno-123", "James, Lebron", 2);
			Vehicle v5 = new RegularCar("pqr-123", "James, Le", 2);
			Vehicle v6 = new RegularCar("abc-123", "Nguyen, Jonathan", 1);
			Vehicle v7 = new HybridElectricCar("NC-123", "Nguyen, Jonathan", 1);
			Vehicle v8 = new HybridElectricCar("abc-123", "Nguyen, Jonathan", 0);
			try {
				assertFalse(g.getBayAt(0).isOccupied());
				v1.pickServiceBay(g);
				assertEquals("E07: def-456  Lee, Joe", g.getBayAt(7).toString());
				v2.pickServiceBay(g);
				assertEquals("E04: ghi-789  Smith, Mike", g.getBayAt(6).toString());
				v3.pickServiceBay(g);
				assertEquals("E01: jkl-123  Randle, Julius", g.getBayAt(5).toString());
				v4.pickServiceBay(g);
				assertEquals("108: mno-123  James, Lebron", g.getBayAt(0).toString());
				assertEquals("106: EMPTY", g.getBayAt(1).toString());
				v5.pickServiceBay(g);
				assertEquals("106: pqr-123  James, Le", g.getBayAt(1).toString());
				v6.pickServiceBay(g);
				assertEquals("105: abc-123  Nguyen, Jonathan", g.getBayAt(2).toString());
				v7.pickServiceBay(g);
				assertEquals("102: NC-123   Nguyen, Jonathan", g.getBayAt(4).toString());
				v8.pickServiceBay(g);
				assertEquals("103: abc-123  Nguyen, Jonathan", g.getBayAt(3).toString());
			} catch(NoAvailableBayException e) {
				System.out.println("No Bays Open");
			}
			
		} catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.garage.model.vehicle.Vehicle#pickServiceBay(edu.ncsu.csc216.garage.model.service_garage.Garage)}.
	 */
	@Test
	public void testPickServiceBayHybrid() {
		ServiceBay.startBayNumberingAt101();
		Garage g = new Garage();
		try {
			Vehicle v1 = new HybridElectricCar("def-456", "Lee, Joe", 3);
			Vehicle v2 = new HybridElectricCar("ghi-789", "Smith, Mike", 2);
			Vehicle v3 = new HybridElectricCar("jkl-123", "Randle, Julius", 0);
			Vehicle v4 = new HybridElectricCar("mno-123", "James, Lebron", 3);
			Vehicle v5 = new HybridElectricCar("pqr-123", "James, Le", 3);
			Vehicle v6 = new HybridElectricCar("abc-123", "Nguyen, Jonathan", 0);
			Vehicle v7 = new HybridElectricCar("abc-123", "Nguyen, Jonathan", 0);
			Vehicle v8 = new HybridElectricCar("abc-123", "Nguyen, Jonathan", 0);
			try {
				assertFalse(g.getBayAt(0).isOccupied());
				v1.pickServiceBay(g);
				v2.pickServiceBay(g);
				v3.pickServiceBay(g);
				v4.pickServiceBay(g);
				v5.pickServiceBay(g);
				v6.pickServiceBay(g);
				v7.pickServiceBay(g);
				v8.pickServiceBay(g);
			} catch(NoAvailableBayException e) {
				System.out.println("No Bays Open");
			}
			
		} catch(BadVehicleInformationException e) {
			System.out.println("invalid vehicle");
		}
	}
}
