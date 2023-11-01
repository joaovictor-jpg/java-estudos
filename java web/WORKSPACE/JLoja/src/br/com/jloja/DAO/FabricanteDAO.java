package br.com.jloja.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.jloja.entity.FabricanteEntity;
import br.com.jloja.util.HibernateUtil;

public class FabricanteDAO {

	public void adicionar(FabricanteEntity fabricante) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.persist(fabricante);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

}
