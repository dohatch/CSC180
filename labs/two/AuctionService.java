package two;

import java.util.Map;

public interface AuctionService {

	public Auction[] search(String criteria);

	public void bid(String username, int itemId);
	
	public Auction create(Auction auction);
	
	public Auction retreive(Integer id);
	
	public Auction update(Auction auction, Integer id);
	
	public void delete(Integer id);
}