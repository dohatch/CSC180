package four;

public class ContainsPredicate implements Predicate<Auction> {

	private String criteria;
	
	public ContainsPredicate(String criteria) {
		this.criteria = criteria;
	}
	@Override
	public boolean evaluate(Auction t) {
		if(t.getName().contains(criteria)) {
			return true;
		}
		return false;
	}

}