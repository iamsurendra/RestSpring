package com.cg.jpastart.entities;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Greet greet = new Greet();
		greet.setMessage("Welcome to JPA!");

		em.persist(greet);// generates the sql qry

		System.out.println("Added greeting to database.");

		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
