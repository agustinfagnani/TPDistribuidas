package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Enum.EstadosPedido;
import Exceptions.TalleYColorException;
import controlador.Controlador;
import dto.ItemPrendaDTO;

public class PedidoCliente {
	
	private int nroPedido;
	private Cliente cliente;
	private Date fechaGeneracion;
	private Date fechaRealDeDespacho;
	private Date fechaProbableDespacho;
	private List<ItemPrenda> prendasPedidas;
	private String estado;
	public PedidoCliente(Cliente cliente) {
		super();
		
		//nro pedido como se genera?
		this.cliente=cliente;
		Calendar cal = Calendar.getInstance();
		Date fechaGeneracion = cal.getTime();
		this.fechaGeneracion=fechaGeneracion;
		this.estado = EstadosPedido.REVISION.getEstado();
	}
	
	public void addPrendaPedida(ItemPrendaDTO item) throws TalleYColorException{
		ItemPrenda itemPrenda= new ItemPrenda(Controlador.getInstance().getAdministracion().buscarPrenda(item.getPrenda().getCodPrenda()),item.getTalleYColor().getTalle(),item.getTalleYColor().getColor(),item.getCantidad());
		prendasPedidas.add(itemPrenda);
	}

	public int getNroPedido() {
		return nroPedido;
	}
	public void cambiarEstado(String estado){
		this.estado=estado;
	}
	
	public boolean sosPedido(int nroPedido){
		return this.nroPedido == nroPedido;
	}
	
	public void saveMe(){
		// guardar el pedido a la base de datos
	}
	
	public int getNroCliente(){
		return cliente.getNroCliente();
	}
	
}
