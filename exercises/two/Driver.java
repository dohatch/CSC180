package two;

import java.util.Scanner;

public class Driver {
	
	
	public static void main(String[] args) {
		InMemoryAuctionService a = new InMemoryAuctionService();
		JUnitTest tester = new JUnitTest();
		
		tester.InMemSetTest();
		tester.AuctionServiceTest();
		tester.AuctionTest();
		
	}
	
}