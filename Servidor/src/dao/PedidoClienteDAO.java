package dao;

import modelo.PedidoCliente;
		
public class PedidoClienteDAO {
	
	private static PedidoClienteDAO instance;
	
	public static PedidoClienteDAO getInstance(){
		if(instance == null){
			instance = new PedidoClienteDAO();
		}
		return instance;
	}

	private PedidoClienteDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PedidoCliente findPedidoByNroPedido(int nroPedido){
		
		//buscar el pedido por nroPedido
		return null;
		
	}
	
	
	
}
