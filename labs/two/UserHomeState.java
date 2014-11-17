package two;

public class UserHomeState implements State {
	String username;
	String criteria;
	
	public UserHomeState(String username) {
		this.username = username;
	}
	
	@Override
	public void show() {
		System.out.println(username + ", what would you like to search for? (Type \"Create\" to add an auction item or hit enter to log out)");
	}

	@Override
	public State next() {
		if(!criteria.isEmpty() && criteria != null) {
			if(criteria.equalsIgnoreCase("Create")) {
				return new AuctionCreateState(username);
			}
			return new SearchResultsState(username, criteria);
		}
		return new DefaultState();
	}
	
	public void search() {
		this.criteria = scan.nextLine();
	}
	
	public String getCriteria() {
		return this.criteria;
	}

	@Override
	public void run() {
		show();
		search();
	}
	

}