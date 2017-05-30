package test;

import modelo.Cliente;
import modelo.CuentaCorriente;
import dao.ClienteDAO;
import entities.ClienteEntity;
import entities.CuentaCorrienteEntity;

public class test1ClienteCtaCte {
	
	public static void main(String[] args) {
		
		CuentaCorrienteEntity ctacte = new CuentaCorrienteEntity(100, 2000, "condiciones 1");
		ClienteEntity cliente = new ClienteEntity(001, "cliente1", "cuit1", ctacte, 123456, true);
		ClienteDAO.getinstance().pruebaSave(cliente);

//		Cliente cliente = new Cliente(001, "cliente1", "cuit1", 2000, "condiciones1", 123456);
//		cliente.saveMe();		
	}
}
