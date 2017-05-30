package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.ClienteEntity;
import entities.CuentaCorrienteEntity;

public class HibernateUtil {
	private static SessionFactory sf;
	
	static{
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(ClienteEntity.class);
		config.addAnnotatedClass(CuentaCorrienteEntity.class);
		
		sf= config.buildSessionFactory();
		
	}
	
	public static SessionFactory getSessionFactory(){
		return sf;
	}
	
}
