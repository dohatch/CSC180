package four;

import java.util.Scanner;

public interface Event {
	InMemoryAuctionService IMAS = new InMemoryAuctionService();
	Scanner scan = new Scanner(System.in);
	
	public void run(); //runs the inside methods in the necessary order
	
	public void show(); //prints a message to the screen indicating what the user should do
	
	public Event next(); //takes in the user's next request and decides what state the user is now in
}