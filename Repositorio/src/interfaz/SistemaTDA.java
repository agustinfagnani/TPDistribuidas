package interfaz;

import java.rmi.RemoteException;

import dto.ClienteDTO;

public interface SistemaTDA {
	
	//======ABM Clientes==================
	public void altaCliente(int nroCliente,String nombre,String cuit, float limite,String condiciones,int nroSucursal) throws RemoteException;
	public void bajaCliente(int nroCliente);
	public void modificarCliente(ClienteDTO clienteView) throws RemoteException;
	public ClienteDTO obtenerCliente(int nroCliente) throws RemoteException;
	//==========================

	
	
}
