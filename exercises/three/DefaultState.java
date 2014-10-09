package three;

public class DefaultState implements Event {
	String username;
	
	@Override
	public void show() {
		System.out.println("New User, would you like to log in? (hit enter to decline)");
	}

	@Override
	public Event next() {
		if(username.length() == 0) {
			return new DefaultState();
		}
		return new UserHomeState(username);
	}
	
	public void logIn() {
		String temp = scan.nextLine();
		
		if(temp != "") {
			username = temp;
		}
	}

	@Override
	public void run() {
		show();
		logIn();
	}

}
