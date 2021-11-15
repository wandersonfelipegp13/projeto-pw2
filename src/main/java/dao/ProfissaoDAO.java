package dao;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import modelo.Profissao;

public class ProfissaoDAO {

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

	public Profissao read(int idProfissao) {

		Session session = sessionFactory.openSession();

		Profissao p = session.get(Profissao.class, idProfissao);

		session.close();

		return p;
	}

	public void create(Profissao profissao) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(profissao);
		session.getTransaction().commit();
		session.close();
	}
	
	public void update(Profissao profissao) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(profissao);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Profissao profissao) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(profissao);
		session.getTransaction().commit();
		session.close();
	}

}
