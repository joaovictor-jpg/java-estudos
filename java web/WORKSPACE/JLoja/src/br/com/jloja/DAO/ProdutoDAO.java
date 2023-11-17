package br.com.jloja.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.jloja.entity.ProdutoEntity;
import br.com.jloja.util.HibernateUtil;

public class ProdutoDAO {
	
	public void adicionar(ProdutoEntity produto) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.persist(produto);
			transacao.commit();
		} catch (Exception ex) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}
	
	
	public void editar(ProdutoEntity produto) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.merge(produto);
			transacao.commit();
		} catch (Exception ex) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}
	
	public void excluir(ProdutoEntity produto) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.remove(produto);
			transacao.commit();
		} catch (Exception ex) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	public ProdutoEntity buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		ProdutoEntity produto = null;

		try {
			Query<ProdutoEntity> consulta = sessao.createNamedQuery("ProdutoEntity.buscarPorCodigo",
					ProdutoEntity.class);
			consulta.setParameter("codigo", codigo);
			produto = (ProdutoEntity) consulta.uniqueResult();

		} catch (Exception ex) {
			throw ex;
		} finally {
			sessao.close();
		}

		return produto;
	}
	
	public List<ProdutoEntity> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<ProdutoEntity> produtos = null;
		
		try {
			Query<ProdutoEntity> consulta = sessao.createNamedQuery("ProdutoEntity.listar", ProdutoEntity.class);	
			produtos = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return produtos;		
	}

}
