package two;

public class AndPredicate implements Predicate<Auction> {
	Predicate a;
	Predicate b;
	
	public AndPredicate(Predicate a, Predicate b) {
		this.a = a;
		this.b = b; 
	}
	
	@Override
	public boolean evaluate(Auction t) {
		return a.evaluate(t) && b.evaluate(t);
	}
}
