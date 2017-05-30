package businessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dto.ClienteDTO;
import interfaz.SistemaTDA;

public class BusinessDelegate {
	
	private static BusinessDelegate instance;
	
	public static BusinessDelegate getInstance(){
		if(instance == null){
			instance = new BusinessDelegate();
		}
		return instance;
	}
	
	
	private BusinessDelegate(){
		super();
	}
	
	
	
	
	private SistemaTDA sistema;
	
	public boolean getStub(){
		
		try {
			sistema = (SistemaTDA) Naming.lookup("//localhost/sistema");
			return true;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public void altaCliente(int nroCliente,String nombre,String cuit,float limite,String condiciones,int nroSucursal) throws Exception{
		if(getStub()){
			try {
				sistema.altaCliente(nroCliente, cuit, condiciones, limite, condiciones, nroSucursal);
			} catch (RemoteException e) {
				throw new Exception(e.getMessage());
			}
		}
	}
	
	public void bajaCliente(int nroCliente){
		if(getStub()){
			sistema.bajaCliente(nroCliente);
		}
	}
	
	public void modificarCliente(ClienteDTO clienteView) throws Exception{
		try {
			sistema.modificarCliente(clienteView);
		} catch (RemoteException e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	public ClienteDTO obtenerCliente(int nroCliente) throws Exception{
		try {
			return sistema.obtenerCliente(nroCliente);
		} catch (RemoteException e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
}
