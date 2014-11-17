package two;

public class OrPredicate implements Predicate<Auction> {
	Predicate a;
	Predicate b;
	
	public OrPredicate(Predicate a, Predicate b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public boolean evaluate(Auction t) {
		return a.evaluate(t) || b.evaluate(t);
	}

}
