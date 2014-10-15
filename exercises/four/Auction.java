package four;

import java.util.HashMap;
import java.util.Map;

public class Auction {
	private int id;
	private int currentBid;
	private String owner;
	private String name;
	private Map<String, Object> properties = new HashMap<String, Object>();
	
	public Auction(int id, String name, int currentBid) {
		this.id = id;
		this.name = name;
		this.currentBid = currentBid;
	}
	
	public Auction(Integer id, String name, Integer currentBid, Map<String, Object> properties) {
		
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
	
	public Map<String, Object> getProperties() {
		return properties;
	}
	
	public Object getProperty(String propertyName) {
		return properties.get(propertyName);
	}
	
	public <T> T getProperty(String propertyName, Class<T> propertyType) {
		return (T)properties.get(propertyName);
	}
	
	public void setProperty(String propertyName, Object propertyValue) {
		properties.put(propertyName, propertyValue);
	}
}