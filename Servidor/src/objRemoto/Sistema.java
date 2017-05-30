package objRemoto;

import interfaz.SistemaTDA;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Exceptions.ClienteNoExisteException;
import Exceptions.SucursalNoExisteException;
import controlador.Controlador;
import dto.ClienteDTO;

public class Sistema extends UnicastRemoteObject implements SistemaTDA {

	private static final long serialVersionUID = -5946184801302260056L;
	
	
	private Controlador controlador;
	
	private Sistema() throws RemoteException {
		super();
		this.controlador=Controlador.getInstance();
	}
	
	
	public void altaCliente(int nroCliente, String nombre, String cuit,
			float limite, String condiciones, int nroSucursal) throws RemoteException  {
		try {
			controlador.newCliente(nroCliente, nombre, cuit, limite, condiciones, nroSucursal);
		} catch (SucursalNoExisteException e) {
			throw new RemoteException(e.getMessage(),e);
		}
		
		
	}

	public void bajaCliente(int nroCliente) {
		// TODO Auto-generated method stub
		controlador.bajaCliente(nroCliente);
		
	}

	public void modificarCliente(ClienteDTO clienteView) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			controlador.modificarCliente(clienteView);
		} catch (ClienteNoExisteException e) {
			throw new RemoteException(e.getMessage(),e);
		}
		
	}

	public ClienteDTO obtenerCliente(int nroCliente) throws RemoteException {
		try {
			return controlador.obtenerCliente(nroCliente);
		} catch (ClienteNoExisteException e) {
			throw new RemoteException(e.getMessage(),e);
		}
	}

}
