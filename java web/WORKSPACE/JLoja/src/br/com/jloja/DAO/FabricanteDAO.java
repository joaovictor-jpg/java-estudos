package br.com.jloja.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.jloja.entity.FabricanteEntity;
import br.com.jloja.util.HibernateUtil;

public class FabricanteDAO {

	public void adicionar(FabricanteEntity fabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.persist(fabricante);
			transacao.commit();
		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	public void editar(FabricanteEntity fabricante) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();
			session.merge(fabricante);
			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void excluir(FabricanteEntity fabricante) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.remove(fabricante);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public FabricanteEntity buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		FabricanteEntity fabricante = null;
		
		try {
			Query<FabricanteEntity> consulta = sessao.createNamedQuery("FabricanteEntity.buscarPorCodigo", FabricanteEntity.class);		
			consulta.setParameter("codigo", codigo);
			fabricante = consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return fabricante;
		
	}

	public List<FabricanteEntity> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<FabricanteEntity> fabricantes = null;

		try {
			Query<FabricanteEntity> consultar = session.createNamedQuery("FabricanteEntity.listar",
					FabricanteEntity.class);
			fabricantes = consultar.list();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}

		return fabricantes;
	}

}
