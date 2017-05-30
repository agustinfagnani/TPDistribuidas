package modelo;

import Exceptions.TalleYColorException;

public class ItemPrenda {
	private Prenda prenda;
	private TalleYColor talleYColor;
	private int cantidad;
	
	public ItemPrenda(Prenda prenda, String talle,String color, int cantidad) throws TalleYColorException {
		super();
		this.prenda = prenda;
		this.talleYColor=prenda.getTalleYColor(talle, color);
		this.cantidad = cantidad;
		
	}
	
	
	
	

}
