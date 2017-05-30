package modelo.areas;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Prenda;
import Exceptions.ClienteNoExisteException;
import dao.ClienteDAO;
import dao.PrendaDAO;
import dto.ClienteDTO;
import dto.ItemPrendaDTO;
import dto.PrendaDTO;

public class Administracion {
	
	private static Administracion instance;
	public static Administracion getinstance(){
		if(instance == null){
			instance = new Administracion();
		}
		return instance;
	}
	
	//========================Area de recursos=====================================================
	private List<Cliente> clientes;
//	private List facturas;
	private List<Prenda> prendas;
//	private List notasDeDebito;
	
	//===============================================================================================
	
	private Administracion() {
		super();
		clientes = ClienteDAO.getinstance().findAllClientesActivos();
	}
	
	
	//================================ABM Ciente=====================================================
	public Cliente buscarCliente(int nroCliente) throws ClienteNoExisteException{
		for (Cliente cliente : clientes) {
			if(cliente.sosCliente(nroCliente)){
				return cliente;
			}
		}
		return ClienteDAO.getinstance().findClienteByNroCliente(nroCliente);
	}
	
	public ClienteDTO obtenerCliente(int nroCliente) throws ClienteNoExisteException{
		
		return buscarCliente(nroCliente).getDTO();
		
	}
	
	public void altaCliente(int nroCliente,String nombre,String cuit,float limite,String condiciones,int nroSucursal){		
		Cliente cliente;
		try {
			cliente=buscarCliente(nroCliente);
			// se necesita enviar un exception de cliente ya existente¿?
			//posiblemente ya que despues se envia un mensaje de confirmacion a la sucursal
			
		} catch (ClienteNoExisteException e) {
			cliente = new Cliente(nroCliente, nombre, cuit, limite, condiciones, nroSucursal);
			cliente.saveMe();
			clientes.add(cliente);	
		}
		
	
	}
	
	public void bajaCliente(int nroCliente){
		try {
			Cliente cliente = buscarCliente(nroCliente);
			cliente.cambiarEstado(false);
						
		} catch (ClienteNoExisteException e) {
			// TODO Auto-generated catch block
			
		}
		
	}
	
	public void modificarCliente(ClienteDTO clienteView) throws ClienteNoExisteException{
		buscarCliente(clienteView.getNroCliente()).updateMe(clienteView);
		
	}
	
	
	//=========================================================================================
	
	//======================prenda===============
	public List<PrendaDTO> getAllPrendas(){
		List<PrendaDTO> prendasView = new ArrayList<PrendaDTO>();
		for (Prenda prenda : prendas) {
			prendasView.add(prenda.getView());
		}
		
		return prendasView;
	}
	
	public Prenda buscarPrenda(int codPrenda){
		for (Prenda prenda : prendas) {
			if(prenda.sosPrenda(codPrenda)){
				return prenda;
			}
		}
		return PrendaDAO.getInstacne().findPrendaByCodPrenda(codPrenda);
	}
	
}
