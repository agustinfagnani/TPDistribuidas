package dao;

import modelo.CuentaCorriente;
import entities.CuentaCorrienteEntity;

public class CuentaCorrienteDAO {
	
	private static CuentaCorrienteDAO instance;
	public static CuentaCorrienteDAO getInstance(){
		if(instance == null){
			instance = new CuentaCorrienteDAO();
		}
		return instance;
	}
	
	private CuentaCorrienteDAO(){
		super();
	}
	
	public CuentaCorrienteEntity toEntity(CuentaCorriente ctacte){
		return new CuentaCorrienteEntity(ctacte.getSaldo(), ctacte.getLimite(), ctacte.getCondiciones());
	}
	
}
