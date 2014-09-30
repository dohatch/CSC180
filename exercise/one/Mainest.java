package stuff;

import java.util.ArrayList;

public class Mainest
{
	public static void main(String[] args)
	{
		Doge superDoge = new Doge(1, "Terrier");
		
		ArrayList<Doge> animals = new ArrayList<Doge>();
		animals.add(superDoge);
		animals.add(new Doge(2, "Windshield"));
		animals.add(superDoge);
		animals.add(superDoge);
		animals.add(superDoge);
		animals.add(superDoge);
		animals.add(null);
		animals.add(null);
		animals.add(new Doge(2, "Windshield"));
		animals.add(new Doge(3, "Pit Bull"));
		
		System.out.println(CollectionUtils.cardinality(superDoge, animals));
		System.out.println(CollectionUtils.cardinality(null, animals));
		System.out.println(CollectionUtils.cardinality(superDoge, null));
		System.out.println(CollectionUtils.cardinality(null, null));
	}
}
