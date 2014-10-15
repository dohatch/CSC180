package four;

import java.util.HashMap;
import java.util.Map;

public class Test {
	static InMemoryAuctionService IMAS = new InMemoryAuctionService();
	static Auction testAuction = new Auction(1234, "Test", 999);
	
	public static void main(String[] args) {
		testAuction.setProperty("Test", String.class);
		
		System.out.println("Auction Service Tests::");
		System.out.println("Create Test: " + testCreate(testAuction));
		System.out.println("Retreive Test: " + testRetreive(testAuction));
		System.out.println("Update Test: " + testUpdate(testAuction));
		System.out.println("Delete Test: " + testDelete());
		System.out.println("\n");
		
		System.out.println("Auction Tests::");
		System.out.println("Set Property Test: " + testSetProperty(testAuction));
		System.out.println("(String) Get Property Test: " + testGetPropertyString(testAuction));
		System.out.println("(T) Get Property Test: " + testGetPropertyT(testAuction));
		System.out.println("Get Properties Test: " + testGetProperties(testAuction));
	}
	
	//Auction Service Tests::
	public static String testCreate(Auction expected) {
		Auction actual = IMAS.create(expected);
		
		if((expected.getId() == actual.getId()) && (expected.getName().equals(actual.getName())) && (expected.getCurrentBid() == actual.getCurrentBid())) {
			return "Succeeded";
		}	
		return "Failed";
		
	}
	
	public static String testRetreive(Auction expected) {
		Auction actual = IMAS.retreive(1234);
		
		if((expected.getId() == actual.getId()) && (expected.getName().equals(actual.getName())) && (expected.getCurrentBid() == actual.getCurrentBid())) {
			return "Succeeded";
		}	
		return "Failed";
	}
	
	public static String testUpdate(Auction compare) {
		Auction expected = new Auction(1234, "Test Update", 300);
		Auction actual = IMAS.update(expected, 1234);
		
		if((expected.getId() == actual.getId()) && (!(actual.getName() == compare.getName())) && (!(actual.getCurrentBid() == compare.getCurrentBid()))) {
			return "Succeeded";
		}
		return "Failed";
	}
	
	public static String testDelete() {
		IMAS.delete(1234);
		if(IMAS.retreive(1234) == null) {
			return "Succeeded";
		}
		return "Failed";
	}
	
	//Auction Tests::
	public static String testSetProperty(Auction a) {
		a.setProperty("Test", new String());
		if(a.getProperty("Test") != null) {
			return "Succeeded";
		}
		return "Failed";
	}
	
	public static String testGetPropertyString(Auction a) {
		Auction actual = testAuction;
		String test = (String)actual.getProperty("Test");
		if(test == testAuction.getProperty("Test")) {
			return "Succeeded";
		}
		return "Failed";
	}
	
	public static String testGetPropertyT(Auction a) {
		Auction actual = testAuction;
		String test = (String)actual.getProperty("Test", String.class);
		if(test == testAuction.getProperty("Test", String.class)) {
			return "Succeeded";
		}
		return "Failed";
	}
	
	public static String testGetProperties(Auction a) {
		Auction actual = testAuction;
		Map<String, Object> test = actual.getProperties();
		if(!(test == testAuction.getProperties())) {
			return "Succeeded";
		}
		return "Failed";
	}
}