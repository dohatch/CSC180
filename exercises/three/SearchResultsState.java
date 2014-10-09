package three;

public class SearchResultsState implements Event {
	Auction [] results;
	String username;
	String criteria;
	
		
	SearchResultsState(String username, String criteria) {
		this.username = username;
		this.criteria = criteria;
	}
	
	@Override
	public void show() {
		System.out.println(username + ", here are your search results:");
		displayResults();
		System.out.println("Enter the item id to increase the bid by $1. Otherwise, enter another search: (hit enter to go back to the home page)");
	}

	@Override
	public Event next() {
		String command = getCommand();
		if(command.equals("Search")) {
			return new UserHomeState(username);
		}
		return new SearchResultsState(username, criteria);
	}
	
	public void  displayResults() {
		results = IMAS.search(criteria);
		
		System.out.println("========================================");
		System.out.println("===          Search Results          ===");
		System.out.println("========================================");
		for(int i = 0; i < results.length; i++) {
			if(results[i] != null) 
			{
				if(results[i].getOwner() == null) {
					results[i].setOwner("No Owner");
				}
				System.out.println("    " + results[i].getId() + "    " + results[i].getName() + "    " + results[i].getCurrentBid() + "      " + results[i].getOwner());
			}
		}
		System.out.println("========================================");
	}
	
	public String getCommand() {
		String command = scan.nextLine();
		
		if(tryParse(command)) {
			int value = Integer.parseInt(command);
			for(int i = 0; i < results.length; i++) {
				if(results[i] != null) {
					if(value == results[i].getId()) {
						IMAS.bid(username, results[i].getId());
						return "Bid";
					}
				}
			}
		}
		return "Search";
	}

	@Override
	public void run() {
		show();
	}
	
	public boolean tryParse(String value) {
		try {
			Integer.parseInt(value);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}

}
