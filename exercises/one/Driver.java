package stuff;

import java.util.ArrayList;

public class Driver
{
	public static void main(String[] args)
	{
		Animal superDog = new Animal(1, "Terrier");
		
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(superDog);
		animals.add(new Animal(2, "Windshield"));
		animals.add(superDog);
		animals.add(superDog);
		animals.add(superDog);
		animals.add(superDog);
		animals.add(null);
		animals.add(null);
		animals.add(new Animal(2, "Windshield"));
		animals.add(new Animal(3, "Pit Bull"));
		
		System.out.println(CollectionUtils.cardinality(superDog, animals));
		System.out.println(CollectionUtils.cardinality(null, animals));
		System.out.println(CollectionUtils.cardinality(superDog, null));
		System.out.println(CollectionUtils.cardinality(null, null));
	}
}
