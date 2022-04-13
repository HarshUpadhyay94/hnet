package in.co.sunrays.mapping;

import java.util.Set;

public class Auction {
	private int id;
	private String desc;
	private Set<Bid> bids;
	
	public Auction() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Set<Bid> getBids() {
		return bids;
	}
	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}
	
	
	
}
