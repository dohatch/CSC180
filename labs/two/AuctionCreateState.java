package two;

import java.util.Scanner;

public class AuctionCreateState implements State {
	Scanner scan = new Scanner(System.in);
	String username;
	
	AuctionCreateState(String username) {
		this.username = username;
	}

	@Override
	public void run() {
		show();
		collectInfo();
	}

	@Override
	public void show() {
		System.out.println("Enter the name of your auction item. (Hit enter to go back to the home page)");
	}

	@Override
	public State next() {
		return new UserHomeState(username);
	}
	
	public void collectInfo() {
		String name = scan.nextLine();
		if((name != "") && (name != null)) {
			System.out.println("Please input a brief description of your auction item.");
			String description = scan.nextLine();
			System.out.println("Please input a starting price for your auction item.");
			String cost = scan.nextLine();
			int price = 0;
			
			if(!(cost == null)) {
				price = Integer.parseInt(cost);
			}
			Auction auction = new Auction(IMAS.items.size() + 2, name, description, price);
			IMAS.create(auction);
		}
	}

}
