package Enum;

public enum EstadosPedido {
	//usado cuando ingresa al sistema y tiene que pasar por el control de sucursal
	REVISION("Pedido en revision"),
	
	//llega a este estado cuando la sucursal termina la revision
	APROBADO("Pedido aprobado"),
	//despacho lo usa
	COMPLETO("Pedido Completo");
	
	
	
	private final String estado;
	
	private EstadosPedido(String estado){
		this.estado = estado;
	}
	public String getEstado(){
		return estado;
	}

}
