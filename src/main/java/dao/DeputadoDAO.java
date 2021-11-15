package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import modelo.Deputado;

public class DeputadoDAO {

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

	public Deputado read(int idDeputado) {

		Session session = sessionFactory.openSession();

		Deputado dep = session.get(Deputado.class, idDeputado);

		session.close();

		return dep;
	}

	public void create(Deputado deputado) {

		if (deputado != null && read(deputado.getId()) == null) {

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.save(deputado);

			session.getTransaction().commit();
			session.close();
		}

	}
	
	public void update(Deputado dep) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(dep);

		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Deputado d) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.delete(d);

		session.getTransaction().commit();
		session.close();
	}
	

}
