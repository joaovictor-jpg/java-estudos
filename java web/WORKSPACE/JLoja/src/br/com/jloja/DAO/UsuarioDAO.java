package br.com.jloja.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.jloja.entity.UsuarioEntity;
import br.com.jloja.util.HibernateUtil;

public class UsuarioDAO {

	public void adicionar(UsuarioEntity usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.persist(usuario);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void editar(UsuarioEntity usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.merge(usuario);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void excluir(UsuarioEntity usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.remove(usuario);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public UsuarioEntity buscarPorCodigo(Long codigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		UsuarioEntity usuario = null;

		try {
			Query<UsuarioEntity> consulta = session.createNamedQuery("UsuarioEntity.buscarPorCodigo",
					UsuarioEntity.class);
			consulta.setParameter("codigo", codigo);
			usuario = (UsuarioEntity) consulta.uniqueResult();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return usuario;
	}

	public List<UsuarioEntity> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<UsuarioEntity> usuarios = new ArrayList<>();

		try {
			Query<UsuarioEntity> consulta = session.createNamedQuery("UsuarioEntity.listar", UsuarioEntity.class);
			usuarios = consulta.list();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return usuarios;
	}

	public UsuarioEntity autenticar(String login, String senha) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		UsuarioEntity usuario = null;

		try {
			Query<UsuarioEntity> consulta = session.createNamedQuery("UsuarioEntity.login", UsuarioEntity.class);
			consulta.setParameter("login", login);
			consulta.setParameter("senha", senha);
			usuario = (UsuarioEntity) consulta.uniqueResult();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return usuario;
	}

}
