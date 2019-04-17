package businessService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class MetodeRegistracija {
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	private Session session = sf.openSession();
	
	public boolean ubaciUsera(String userName , String password) {
		User user = new User();
		session.beginTransaction();
	 try {
		user.setUserName(userName);
		user.setPassword(password);
		session.save(user);
		session.getTransaction().commit();
		System.out.println("Uspesan unos");
	}catch (Exception e) {
		session.getTransaction().rollback();
		System.out.println("Neuspesan unos");
	} return false;

 }
}
