package modelo.areas;

import java.time.LocalTime;
import java.util.List;

import modelo.Cliente;
import modelo.PedidoCliente;
import Exceptions.ClienteNoExisteException;
import Exceptions.TalleYColorException;
import controlador.Controlador;
import dto.ItemPrendaDTO;

public class Sucursal {
	
	private int nroSucursal;
	private String nombre;
	private String ubicacion;
	private LocalTime horario;
	private String informacion;
	private List<PedidoCliente> pedidos;
	
	
	public boolean sosSucursal(int nroSucursal){
		return this.nroSucursal==nroSucursal;
	}
	
	public void informeClienteCreado(int nroCliente, String nombre, String cuit){
		String string = new String("Cliente creado Exitosamente\n"+"Datos del Cliente: \n"+
						"numero de Cliente:"+nroCliente+"\n"+
						"Nombre:"+nombre+"\n"+
						"CUIT:"+cuit+"\n");
		
		//devolver string a la pantalla¿?, a un tablero de mensajes¿?
		
	}
	
	public int newPedidoCliente(Cliente cliente,List<ItemPrendaDTO> pedidos) throws ClienteNoExisteException, TalleYColorException{
		
		PedidoCliente pedido = new PedidoCliente(cliente);
		
		for (ItemPrendaDTO item : pedidos) {
			pedido.addPrendaPedida(item);
		}
		this.pedidos.add(pedido);
		//save pedido¿?
		return pedido.getNroPedido();
	}
	
	
	
}
