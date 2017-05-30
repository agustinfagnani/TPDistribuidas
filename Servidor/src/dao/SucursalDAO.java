package dao;

import Exceptions.SucursalNoExisteException;
import modelo.areas.Sucursal;

public class SucursalDAO {
	private static SucursalDAO instance;
	
	public static SucursalDAO getInstance(){
		if(instance == null){
			instance = new SucursalDAO();
		}
		return instance;
	}
	
	private SucursalDAO(){
		super();
	}
	
	
	public Sucursal findSucursalByNroSucursal(int nroSucursal) throws SucursalNoExisteException{
		
		//en caso de no encontrar una sucursal devolver una exception
		throw new SucursalNoExisteException("El sucursal con el numero:"+nroSucursal+"no existe");
		
		
	}
	
	
	
	
}
