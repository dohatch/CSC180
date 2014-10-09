package one;

public class InMemoryAuctionService implements AuctionService {

	Auction cookies = new Auction(1, "Cookies", 0);
	Auction grapes = new Auction(2, "Grapes", 0);
	Auction potatoes = new Auction(3, "Potatoes", 0);
	Auction book = new Auction(4, "Book", 0);
	Auction mayonaise = new Auction(5, "Mayonaise", 0);
	Auction caterpiller = new Auction(6, "Caterpiller", 0);
	Auction cat = new Auction(7, "Cat", 0);
	Auction duck = new Auction(8, "Duck", 0);
	Auction ducks = new Auction(9, "Ducks", 0);
	Auction duckSauce = new Auction(10, "Duck Sauce", 0);
	Auction schoolBooks = new Auction(11, "School Books", 0);
	Auction potatoBook = new Auction(12, "The Big Book of Potatoes", 0);
	Auction foodBook = new Auction(13, "The Food Book", 0);
	
	Auction[] searchedItems;
	
	Auction[] items = {cookies, grapes, potatoes,
					   book, mayonaise, caterpiller,
					   cat, duck, ducks, duckSauce,
					   schoolBooks, potatoBook, foodBook};
	
	
	@Override
	public Auction[] search(String criteria) {
		searchedItems = new Auction[items.length];
		int j = 0;
		for(int i = 0; i < items.length; i++) {
			if(items[i].getName().contains(criteria)) {
				searchedItems[j] = items[i];
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

}
