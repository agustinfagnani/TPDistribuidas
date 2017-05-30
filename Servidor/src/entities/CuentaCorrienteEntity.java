package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "cuentasCorrientes")
public class CuentaCorrienteEntity {
	
	@Id
	@Column(name = "idCtaCte")
	private int idCtaCte;
	
	private float saldo;
	
	private float limite;
	
	private String condiciones;
	
	public CuentaCorrienteEntity(float saldo, float limite, String condiciones) {
		super();
		this.saldo = saldo;
		this.limite = limite;
		this.condiciones = condiciones;
	}
	
	
	
	
}
