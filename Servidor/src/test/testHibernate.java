package test;

import dao.UsuarioDAO;
import entities.UsuarioEntity;


public class testHibernate {
	public static void main(String[] args) {
		UsuarioEntity usu = new UsuarioEntity(1234, "usuario1");
		
		UsuarioDAO.getInstance().save(usu);
		
	}

}
