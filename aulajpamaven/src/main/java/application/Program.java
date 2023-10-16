package application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entities.Pessoa;

public class Program {
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa pessoa1 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa pessoa2 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
//		em.getTransaction().begin();
//		em.persist(pessoa);
//		em.persist(pessoa1);
//		em.persist(pessoa2);
//		em.getTransaction().commit();
		
		Pessoa p = em.find(Pessoa.class, 2);
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
