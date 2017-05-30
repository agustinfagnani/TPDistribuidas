package dao;

import hbt.HibernateUtil;

import org.hibernate.Session;

import entities.UsuarioEntity;

public class UsuarioDAO {
	private static UsuarioDAO instance;
	public static UsuarioDAO getInstance(){
		if(instance == null){
			instance = new UsuarioDAO();
		}
		return instance;
	}
	
	public void save(UsuarioEntity usu){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(usu);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	
}
