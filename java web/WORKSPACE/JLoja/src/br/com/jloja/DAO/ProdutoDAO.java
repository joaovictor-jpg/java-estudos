package br.com.jloja.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.jloja.entity.ProdutoEntity;
import br.com.jloja.util.HibernateUtil;

public class ProdutoDAO {

	public void adicionar(ProdutoEntity produto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.persist(produto);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void editar(ProdutoEntity produto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.merge(produto);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

	}

	public void excluir(ProdutoEntity produto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.remove(produto);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public ProdutoEntity buscarProdutoPorCodigo(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ProdutoEntity produto = null;

		try {
			Query<ProdutoEntity> consulta = session.createNamedQuery("ProdutoEntity.buscarPorCodigo",
					ProdutoEntity.class);
			consulta.setParameter("codigo", id);
			produto = (ProdutoEntity) consulta.uniqueResult();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return produto;
	}

	public List<ProdutoEntity> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<ProdutoEntity> produtos = null;

		try {
			Query<ProdutoEntity> consulta = session.createNamedQuery("ProdutoEntity.listar", ProdutoEntity.class);
			produtos = consulta.list();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return produtos;
	}

}
