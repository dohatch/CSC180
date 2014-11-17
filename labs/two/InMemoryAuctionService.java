package two;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class InMemoryAuctionService implements AuctionService {

	Map<Integer, Auction> items = new HashMap<Integer, Auction>();
	Auction[] searchResults;

	Auction cookies = new Auction(1, "Cookies", "Good Cookies", 0);
	Auction pGrapes = new Auction(2, "Grapes", "Purple Grapes", 0);
	Auction potatoes = new Auction(3, "Potatoes", "A bag of Potatoes", 0);
	Auction book = new Auction(4, "Book", "A novel about school", 0);
	Auction mayonnaise = new Auction(5, "Mayonnaise", "Best Foods Mayo", 0);
	Auction caterpillar = new Auction(6, "Caterpillar", "He is Hungry", 0);
	Auction cat = new Auction(7, "Cat", "He is Hungry", 0);
	Auction duck = new Auction(8, "Duck", "A high-quality Duck", 0);
	Auction ducks = new Auction(9, "Ducks", "Quantity over Quality", 0);
	Auction duckSauce = new Auction(10, "Duck Sauce", "Asian Orange Sauce", 0);
	Auction schoolBooks = new Auction(11, "School Books", "Books for School", 0);
	Auction potatoBook = new Auction(12, "The Big Book of Potatoes", "A recipe book solely for Potatoes", 0);
	Auction foodBook = new Auction(13, "The Food Book", "A high-quality cook book", 0);
	Auction gGrapes = new Auction(14, "Grapes", "Green Grapes", 0);

	@Override
	//Author: Joshua Cummings
	public Auction[] search(String criteria) {
		if(InputUtils.isEmpty(criteria))
			return new Auction[0];
		Set<Auction> filtered = filter(criteria);
		return filtered.toArray(new Auction[filtered.size()]);
	}
	
	//Author: Joshua Cummings
	private Set<Auction> filter(String criteria) {
		Stack<Predicate<Auction>> predicates = new Stack<>();
		Stack<String> operators = new Stack<>();
		
		Scanner scan = new Scanner(criteria);
		while(scan.hasNext()) {
			String nextCriterion = scan.next();
			String nextOperator = scan.hasNext() ? scan.next() : null;
			
			predicates.push(new ContainsPredicate(nextCriterion));
			while(nextOperator!= null && !operators.isEmpty() && "OR".equals(nextOperator) && "AND".equals(operators.peek())) {
				Predicate<Auction> right = predicates.pop();
				Predicate<Auction> left = predicates.pop();
				String and = operators.pop();
				predicates.push(new AndPredicate(left, right));
			}
			if(nextOperator != null) {
				operators.push(nextOperator);
			}
		}
		
		while(predicates.size() > 1) {
			Predicate<Auction> right = predicates.pop();
			Predicate<Auction> left = predicates.pop();
			String operator = operators.pop();
			predicates.push("AND".equals(operator) ? new AndPredicate(left, right) : new OrPredicate(left, right));
		}
		
		Predicate<Auction> finalPredicate = predicates.pop();
		return CollectionUtils.filter(items.values(), finalPredicate);
	}

	@Override
	public void bid(String username, int itemId) {
		Auction temp = items.get(itemId);
		temp.setCurrentBid(temp.getCurrentBid() + 1);
		temp.setOwner(username);
	}

	@Override
	public Auction create(Auction auction) {
		auction.setId(items.size() + 1);
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
		items.put(2, pGrapes);
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
		items.put(14, gGrapes);
	}
}