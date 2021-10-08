package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import entities.User;



public class UserDao implements IUser {
private EntityManager em;
	
	public UserDao() {
		EntityManagerFactory emf = Persistence
						.createEntityManagerFactory("jee_securite");
		
		em = emf.createEntityManager();
	}
	@Override
	public int add(User user) {
		int ok = 0;
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			ok = 0;
		}
		
		return ok;
	}
	@Override
	public int delete(int idU) {
		int ok = 0;
		try {
			em.getTransaction().begin();
			em.remove(em.find(User.class, idU));
			em.getTransaction().commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			ok = 0;
		}
		return ok;
	}
	@Override
	public int update(User user) {
		int ok = 0;
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			ok = 0;
		}
		return ok;
	}
	@Override
	public List<User> liste() {
		
		return em.createNamedQuery("User.findAll").getResultList();
	}

	@Override
	public User getServeurById(int idU) {
		
		return em.find(User.class,idU);
	}
}
