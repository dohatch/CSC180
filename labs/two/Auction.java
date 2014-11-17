package two;

public class Auction {
	private int id;
	private int currentBid;
	private String owner;
	private String description;
	private String name;
	
	public Auction(int id, String name, String description, int currentBid) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.currentBid = currentBid;
	}

	public boolean equals(int id) {
		return this.id == id;
	}
	
	public int hashCode() {
		return this.getId();
	}

	public String toString() {
		return this.name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
			this.owner = owner;
			
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (owner != null) {
			this.name = name;
		}
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}