package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name ="clientes")
public class ClienteEntity {
	
	@Id
	@Column(name = "nroCliente")
	private int nroCliente;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "cuit")
	private String cuit;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCtaCte")
	private CuentaCorrienteEntity ctacte;
	
	private int nroSucursal;
	private boolean activo;
	
	
	
	public ClienteEntity(int nroCliente, String nombre, String cuit,
			CuentaCorrienteEntity ctacte, int nroSucursal, boolean activo) {
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
	public CuentaCorrienteEntity getCtacte() {
		return ctacte;
	}
	public void setCtacte(CuentaCorrienteEntity ctacte) {
		this.ctacte = ctacte;
	}
	public int getNroSucursal() {
		return nroSucursal;
	}
	public void setNroSucursal(int nroSucursal) {
		this.nroSucursal = nroSucursal;
	}
	
	public void setActivo(boolean activo){
		this.activo = activo;
	}
	
	
}
