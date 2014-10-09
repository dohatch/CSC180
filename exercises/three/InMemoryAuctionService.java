package three;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAuctionService implements AuctionService {

	Map<Integer, Auction> items = new HashMap<Integer, Auction>();
	
	Auction cookies = new Auction(1, "Cookies", 0);
	Auction grapes = new Auction(2, "Grapes", 0);
	Auction potatoes = new Auction(3, "Potatoes", 0);
	Auction book = new Auction(4, "Book", 0);
	Auction mayonnaise = new Auction(5, "Mayonnaise", 0);
	Auction caterpillar = new Auction(6, "Caterpillar", 0);
	Auction cat = new Auction(7, "Cat", 0);
	Auction duck = new Auction(8, "Duck", 0);
	Auction ducks = new Auction(9, "Ducks", 0);
	Auction duckSauce = new Auction(10, "Duck Sauce", 0);
	Auction schoolBooks = new Auction(11, "School Books", 0);
	Auction potatoBook = new Auction(12, "The Big Book of Potatoes", 0);
	Auction foodBook = new Auction(13, "The Food Book", 0);
	
	Auction[] searchedItems;
	
	@Override
	public Auction[] search(String criteria) {
		searchedItems = new Auction[items.size()];
		int j = 0;
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getName().contains(criteria)) {
				searchedItems[j] = items.get(i);
				j++;
			}
		}
		return searchedItems;
	}

	@Override
	public void bid(String username, int itemId) {
		for(int i = 0; i < searchedItems.length; i++) {
			if(searchedItems[i] != null) {
				if(itemId == searchedItems[i].getId()) {
					searchedItems[i].setCurrentBid(1);
					searchedItems[i].setOwner(username);
				}
			}
		}
	}

	@Override
	public Auction create(Auction auction) {
		items.put(auction.getId(), auction);
		return auction;
	}

	@Override
	public Auction retreive(Integer id) {
		return items.get(id);
	}

	@Override
	public Auction update(Auction auction, Integer id) {
		items.remove(id);
		items.put(id, auction);
		return auction;
	}

	@Override
	public void delete(Integer id) {
		items.remove(id);
		
	}
	
	public void init() {
		items.put(1, cookies);
		items.put(2, grapes);
		items.put(3, potatoes);
		items.put(4, book);
		items.put(5, mayonnaise);
		items.put(6, caterpillar);
		items.put(7, cat);
		items.put(8, duck);
		items.put(9, ducks);
		items.put(10, duckSauce);
		items.put(11, schoolBooks);
		items.put(12, potatoBook);
		items.put(13, foodBook);
	}

}
