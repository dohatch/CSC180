package two;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CollectionUtils
{
	public static <T> Set<T> filter(Collection<T> t, Predicate<T> p) {
		Set<T> returning = new HashSet<T>();
		for(T a : t) {
			if(p.evaluate(a)) {
				returning.add(a);
			}
		}
		return returning;
	}
}