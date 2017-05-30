package dto;

import java.io.Serializable;



public class ClienteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8655239895983395351L;
	
	private int nroCliente;
	private String nombre;
	private String cuit;
	private CuentaCorrienteDTO ctacte;
	private int nroSucursal;
	private boolean activo;
	
	public ClienteDTO(){
		super();
	}

	public ClienteDTO(int nroCliente, String nombre, String cuit,
			CuentaCorrienteDTO ctacte, int nroSucursal, boolean activo) {
		super();
		this.nroCliente = nroCliente;
		this.nombre = nombre;
		this.cuit = cuit;
		this.ctacte = ctacte;
		this.nroSucursal = nroSucursal;
		this.activo = activo;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public CuentaCorrienteDTO getCtacte() {
		return ctacte;
	}

	public void setCtacte(CuentaCorrienteDTO ctacte) {
		this.ctacte = ctacte;
	}

	public int getNroSucursal() {
		return nroSucursal;
	}

	public void setNroSucursal(int nroSucursal) {
		this.nroSucursal = nroSucursal;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
