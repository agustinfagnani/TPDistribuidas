package modelo;

import dto.CuentaCorrienteDTO;

public class CuentaCorriente {
	
	
	private float saldo;
	private float limite;
	private String condiciones;
	
	
	
	public CuentaCorriente(float limite, String condiciones) {
		super();
		this.saldo = 0;
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
	
	public void saveMe(){
		//desarrollar
		//se puede guardar directamente con cascade de entity¿?
	}
	
	public CuentaCorrienteDTO getDTO(){
		return new CuentaCorrienteDTO(saldo, limite, condiciones);
	}
	
	
	
	
}
