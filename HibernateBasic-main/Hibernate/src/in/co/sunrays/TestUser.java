package in.co.sunrays;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestUser {
	public static void main(String[] args) throws Exception {
		// testAdd();
		//testGet();
	//testList();
		testCriteria();
		
	
	}


	private static void testCriteria() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session s = factory.openSession();
		Query q = s.createQuery("from User");
		Criteria crit= s.createCriteria(User.class);
		List<User> l = crit.list();
		Iterator<User> it = l.iterator();
		User u;
		while(it.hasNext()) {
			u = (User)it.next();
			System.out.println(u.getId());
			System.out.println(u.getFname());
			System.out.println(u.getLname());
		}
		}
	

	private static void testList() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session s = factory.openSession();
		
		Query q = s.createQuery("from User");
		List list =q.list();
		Iterator it = list.iterator();
		
		User p;
		while(it.hasNext()) {
			 p = (User)it.next();
			 System.out.println(p.getId());
			System.out.println(p.getFname());
			System.out.println(p.getLname());
			
			}
		}

	private static void testGet() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session s = factory.openSession();

		User pojo = (User) s.get(User.class, 1);
		System.out.println(pojo.getFname());
		System.out.println(pojo.getLname());

	}

	private static void testAdd() throws Exception {

		User u = new User();
		u.setFname("Dolly");
		u.setLname("Pandey");
		u.setUserName("DollyPandey");
		u.setPwd("Dolly123");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session s = factory.openSession();

		Transaction t = s.beginTransaction();

		s.save(u);

		t.commit();
		s.close();

	}

}
