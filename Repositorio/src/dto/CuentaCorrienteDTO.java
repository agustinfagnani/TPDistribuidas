package dto;

import java.io.Serializable;

public class CuentaCorrienteDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6037099149681575002L;
	
	private float saldo;
	private float limite;
	private String condiciones;
	
	public CuentaCorrienteDTO(){
		super();
	}

	public CuentaCorrienteDTO(float saldo, float limite, String condiciones) {
		super();
		this.saldo = saldo;
		this.limite = limite;
		this.condiciones = condiciones;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	public String getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}
	
	
	
	
}
