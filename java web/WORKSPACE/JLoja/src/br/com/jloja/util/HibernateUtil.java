package br.com.jloja.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	//Criando da fabrica de sessão ou SessionFactory

    private static final SessionFactory sessionFactory = buildSessionFactory();

    

    //Método que constroi a sessão

    private static SessionFactory buildSessionFactory() {
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    			.configure() // configurações do hibernate.cfg.xml
    			.build();
    	try {
    		return new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    	}
    	catch (Exception e) {
    		// Caso ocorra algum erro o SessionFactory sera destruido.
    		System.err.println("Falha ao criar SessionFactory." + e);
    		StandardServiceRegistryBuilder.destroy( registry );
    		throw new ExceptionInInitializerError(e);
    		}
    }


    //Método que retorna a sessão criada

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}