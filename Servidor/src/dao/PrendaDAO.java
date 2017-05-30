package dao;

import modelo.Prenda;

public class PrendaDAO {
	
	private static PrendaDAO instance;
	public static PrendaDAO getInstacne(){
		if(instance == null){
			instance = new PrendaDAO();
		}
		return instance;
	}
	
	private PrendaDAO(){
		super();
	}
	
	
	
	public Prenda findPrendaByCodPrenda(int codPrenda){
		
		//busca prenda por codigo
		return null;
	}

}
