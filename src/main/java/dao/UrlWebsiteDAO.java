package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import modelo.UrlWebsite;

public class UrlWebsiteDAO {

	protected SessionFactory sessionFactory;

	public void setup() {

		// configures settings from hibernate.cfg.xml
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			System.out.println("Erro no setup: " + ex.getMessage() + "\n");
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	public void exit() {
		sessionFactory.close();
	}

	public UrlWebsite read(int idUrlWebsite) {

		Session session = sessionFactory.openSession();

		UrlWebsite url = session.get(UrlWebsite.class, idUrlWebsite);

		session.close();

		return url;
	}

	public void create(UrlWebsite urlWebsite) {

		if (urlWebsite != null && read(urlWebsite.getId()) == null) {

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.save(urlWebsite);

			session.getTransaction().commit();
			session.close();
		}

	}
	
	public void update(UrlWebsite urlWebsite) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(urlWebsite);

		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(UrlWebsite urlWebsite) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(urlWebsite);

		session.getTransaction().commit();
		session.close();
	}


}
