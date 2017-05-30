package Enum;

public enum EstadosPedido {
	REVISION("Pedido en revision"),
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
