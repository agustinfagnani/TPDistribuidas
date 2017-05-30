package modelo;

import dao.ClienteDAO;
import dto.ClienteDTO;

public class Cliente {
	
	private int nroCliente;
	private String nombre;
	private String cuit;
	private CuentaCorriente ctacte;
	private int nroSucursal;
	private boolean activo;
	
	public Cliente(int nroCliente, String nombre, String cuit,float limite,String condiciones,
			int nroSucursal) {
		super();
		this.nroCliente = nroCliente;
		this.nombre = nombre;
		this.cuit = cuit;
		this.nroSucursal = nroSucursal;
		this.activo = true;
		this.ctacte = new CuentaCorriente(limite, condiciones);
		
	}
	
	public boolean sosCliente(int nroCliente){
		return this.nroCliente==nroCliente;
	}
	
	
	//NOTA GUARDAR TAMBIEN A LA CUENTA CORRIENTE
		//se puede guardar directamente con cascade de entity¿? --> si
	
	public void saveMe(){
		
		ClienteDAO.getinstance().save(this);
		
	}
	
	public ClienteDTO getDTO(){
		
		return new ClienteDTO(nroCliente, nombre, cuit, ctacte.getDTO(), nroSucursal, activo);		
	}

	public void cambiarEstado(boolean estado){
		this.activo=estado;
		ClienteDAO.getinstance().updateClientStatus(nroCliente,estado);
	}
	
	public void updateMe(ClienteDTO clienteView){
	
		this.nombre = clienteView.getNombre();
		this.cuit = clienteView.getCuit();
		this.nroSucursal = clienteView.getNroSucursal();
		this.activo = clienteView.getActivo();
		
		ClienteDAO.getinstance().update(this);
				
	}

	public int getNroSucursal() {
		return nroSucursal;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCuit() {
		return cuit;
	}

	public CuentaCorriente getCtacte() {
		return ctacte;
	}
	
	public boolean isActivo(){
		return activo;
	}
	
	
}
