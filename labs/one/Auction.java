package one;

public class Auction {
	private int id;
	private int currentBid;
	private String owner;
	private String name;
	
	public Auction(int id, String name, int currentBid) {
		this.id = id;
		this.name = name;
		this.currentBid = currentBid;
	}

	public boolean equals(int id) {
		return this.id == id;
	}
	
	public int hashCode() {
		//TODO: Override
		return 0;
	}

	public String toString() {
		return this.name;
	}

	public int getId() {
		return id;
	}

	public int getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(int currentBid) {
		this.currentBid += currentBid;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		if (owner == null) {
			this.owner = owner;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (owner != null) {
			this.name = name;
		}
	}
}