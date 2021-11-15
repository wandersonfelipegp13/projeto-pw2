package dao;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import modelo.Legislatura;

public class LegislaturaDAO {

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

	public Legislatura read(int idLegislatura) {

		Session session = sessionFactory.openSession();

		Legislatura leg = session.get(Legislatura.class, idLegislatura);

		session.close();

		return leg;
	}

	public void create(Legislatura legislatura) {

		if (legislatura != null && read(legislatura.getIdLegislatura()) == null) {

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.save(legislatura);

			session.getTransaction().commit();
			session.close();
		}

	}
	
	public void update(Legislatura l) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(l);

		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Legislatura l) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(l);

		session.getTransaction().commit();
		session.close();
	}

}
