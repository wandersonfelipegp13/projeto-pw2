package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import modelo.UrlRedeSocial;

public class UrlRedeSocialDAO {

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

	public UrlRedeSocial read(int idUrlRedeSocial) {

		Session session = sessionFactory.openSession();

		UrlRedeSocial url = session.get(UrlRedeSocial.class, idUrlRedeSocial);

		session.close();

		return url;
	}

	public void create(UrlRedeSocial urlRedeSocial) {

		if (urlRedeSocial != null && read(urlRedeSocial.getId()) == null) {

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.save(urlRedeSocial);

			session.getTransaction().commit();
			session.close();
		}

	}
	
	public void update(UrlRedeSocial r) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(r);

		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(UrlRedeSocial r) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(r);

		session.getTransaction().commit();
		session.close();
	}


}
