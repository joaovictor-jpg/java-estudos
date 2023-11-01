package br.com.jloja.main;

import br.com.jloja.DAO.FabricanteDAO;
import br.com.jloja.entity.FabricanteEntity;

public class MainBanco {

	public static void main(String[] args) {
//		try {
//			HibernateUtil.getSessionFactory();
//			HibernateUtil.getSessionFactory().close();
//			System.out.println("Conexão realizada com sucesso!");
//		} catch(RuntimeException ex) {
//			ex.printStackTrace();
//		}
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		
		fabricanteDAO.adicionar(new FabricanteEntity(null, "Paulo"));
	}

}
