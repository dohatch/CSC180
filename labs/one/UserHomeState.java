package one;

public class UserHomeState implements Event {
	String username;
	String criteria;
	
	public UserHomeState(String username) {
		this.username = username;
	}
	
	@Override
	public void show() {
		System.out.println(username + ", what would you like to search for? (Hit enter to log out)");
	}

	@Override
	public Event next() {
		if(criteria == null) {
			return new DefaultState();
		}
		return new SearchResultsState(username, criteria);
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
