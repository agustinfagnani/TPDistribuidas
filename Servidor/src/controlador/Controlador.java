package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.areas.Administracion;
import modelo.areas.Sucursal;
import Exceptions.ClienteNoExisteException;
import Exceptions.SucursalNoExisteException;
import Exceptions.TalleYColorException;
import dao.SucursalDAO;
import dto.ClienteDTO;
import dto.ItemPrendaDTO;
import dto.PrendaDTO;

public class Controlador {
	private static Controlador instance;
	
	public static Controlador getInstance(){
		if(instance == null){
			instance = new Controlador();
		}
		return instance;
	}
	
	//==================Area de recursos==============================================
	private Administracion administracion;
	private List<Sucursal> sucursales;
	
	//================================================================================
	private Controlador(){
		super();
		administracion = Administracion.getinstance();
		sucursales = new ArrayList<Sucursal>();
		
	}
	
	
	//=====================Metodos del controlador==========================================
	private Sucursal obtenerSucursal(int nroSucursal) throws SucursalNoExisteException{
		
		for (Sucursal sucursal : sucursales) {
			if(sucursal.sosSucursal(nroSucursal)){
				return sucursal;
			}
		}
		
		return SucursalDAO.getInstance().findSucursalByNroSucursal(nroSucursal);		
	}
				//======AMB CLiente ===============
	public ClienteDTO obtenerCliente(int nroCliente) throws ClienteNoExisteException{
		return administracion.obtenerCliente(nroCliente);
		
	}
	
	public void newCliente(int nroCliente,String nombre,String cuit,float limite, String condiciones,int nroSucursal) throws SucursalNoExisteException{
		administracion.altaCliente(nroCliente, nombre, cuit, limite, condiciones, nroSucursal);
		obtenerSucursal(nroSucursal).informeClienteCreado(nroCliente, nombre, cuit);
				
	}
	
	public void bajaCliente(int nroCliente){
		
		administracion.bajaCliente(nroCliente);
		
	}
	
	public void modificarCliente(ClienteDTO clienteView) throws ClienteNoExisteException{
		administracion.modificarCliente(clienteView);
	}
				//===========================
	
	
	
	
	
	//=========================Pedidos======================================================
	
	public List<PrendaDTO> obtenerPrendas(){
		
		return administracion.getAllPrendas();
	}

	public Administracion getAdministracion(){
		return this.administracion;
	}
	
	public int newPedido(int nroCliente,List<ItemPrendaDTO> pedidos) throws ClienteNoExisteException, SucursalNoExisteException, TalleYColorException{
		Cliente cliente = administracion.buscarCliente(nroCliente);
		Sucursal sucursal = obtenerSucursal(cliente.getNroSucursal());
		return sucursal.newPedidoCliente(cliente, pedidos);
	}
	
}
