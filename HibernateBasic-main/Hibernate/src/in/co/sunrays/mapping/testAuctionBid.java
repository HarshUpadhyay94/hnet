package in.co.sunrays.mapping;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class testAuctionBid {
	
	public static void main(String[] args) {
		
		testAB();
		
		
	}

	private static void testAB() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Auction iteamA= new Auction();
		iteamA.setDesc("Iphone");
		
		Bid B = new Bid();
		B.setAmount(2900);
		
		Set bids = new HashSet();
		bids.add(B);
		
		iteamA.setBids(bids);
		Transaction t = s.beginTransaction();
		
		
		/*
		 * String hql = "from Auction"; Query query = s.createQuery(hql);
		 */
		
		s.save(iteamA);
		t.commit();
		s.close();
	}
	
}
