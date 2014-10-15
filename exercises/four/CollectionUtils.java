package four;

import java.util.Collection;
import java.util.Iterator;

public class CollectionUtils
{
	public static int cardinality(java.lang.Object obj, Collection coll)
	{
		int numObject = 0;
		if(coll != null)	
		{
			Iterator iter = coll.iterator();
			
			while(iter.hasNext())
			{
				Object collObj = iter.next();
				
				if(collObj != null)
				{
					if(collObj.equals(obj))
					{
						numObject++;
					}
				}
				
			}
		}
		return numObject;
	}
}